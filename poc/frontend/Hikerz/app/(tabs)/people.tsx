import { useFocusEffect } from 'expo-router';
import { useCallback, useEffect, useMemo, useRef, useState } from 'react';
import {
  ActivityIndicator,
  Alert,
  FlatList,
  Image,
  ListRenderItem,
  StyleSheet,
  Text,
  TextInput,
  TouchableOpacity,
  View,
} from 'react-native';

import type { Paginated, User } from '../services/userService';
import { fetchUser, fetchUsersPage, followUser, unfollowUser } from '../services/userService';

const ThemedView: React.FC<React.ComponentProps<typeof View>> = (props) => (
  <View style={[styles.themedView, props.style]} {...props} />
);
const ThemedText: React.FC<React.ComponentProps<typeof Text> & { type?: 'title' | 'subtitle' | 'default' }> = (props) => {
  const textStyle = useMemo(() => {
    switch (props.type) {
      case 'title':
        return styles.themedTextTitle;
      case 'subtitle':
        return styles.themedTextSubtitle;
      case 'default':
      default:
        return styles.themedTextDefault;
    }
  }, [props.type]);
  return <Text style={[textStyle, props.style]} {...props} />;
};

function StandardAvatar({ size, uri, fallbackText, style }: { size: 'lg' | 'md' | 'sm', uri: string, fallbackText: string, style?: object }) {
  const avatarSize = size === 'lg' ? 50 : size === 'md' ? 40 : 30;
  return (
    <View style={[styles.avatarBase, { width: avatarSize, height: avatarSize, borderRadius: avatarSize / 2 }, style]}>
      {uri ? (
        <Image source={{ uri }} style={{ width: avatarSize, height: avatarSize, borderRadius: avatarSize / 2 }} />
      ) : (
        <Text style={styles.avatarFallbackText}>{fallbackText.slice(0, 2).toUpperCase()}</Text>
      )}
    </View>
  );
}
function StandardAvatarGroup({ children }: { children: React.ReactNode }) {

  return (
    <View style={styles.avatarGroupContainer}>
      {children}
    </View>
  );
}

const PAGE_SIZE = 10;
const username = 'filipcirtog'; 
export default function DiscoverScreen() {
  const [items, setItems] = useState<User[]>([]);
  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState<number | null>(null);
  const [loadingInitial, setLoadingInitial] = useState(true);   
  const [loadingCurrentUser, setLoadingCurrentUser] = useState(true); 
  const [loadingMore, setLoadingMore] = useState(false);        
  const [refreshing, setRefreshing] = useState(false);         
  const [replacing, setReplacing] = useState(false);         
  const [err, setErr] = useState<string | null>(null);
  const [search, setSearch] = useState('');
  const [lastQuery, setLastQuery] = useState(''); 
  const [pending, setPending] = useState<Set<string>>(new Set());
  const [user, setUser] = useState<User | null>(null);
  const currentQueryRef = useRef('');
  const reqSeqRef = useRef(0);

  const followingSet = useMemo(() => new Set(user?.following.map(f => f.username) ?? []), [user?.following]);

  type Purpose = 'init' | 'search' | 'refresh' | 'scroll';
  const loadPage = useCallback(
    async (p: number, q: string, purpose: Purpose) => {

      if (!user) return;

      const isFirst = p === 0;
      const reqId = ++reqSeqRef.current;
      try {
        setErr(null);
        if (isFirst) {
          if (purpose === 'init') setLoadingInitial(true);
          if (purpose === 'search') setReplacing(true); 
          if (purpose === 'refresh') setRefreshing(true);
        } else {
          setLoadingMore(true);
        }

        const resp: Paginated<User> = await fetchUsersPage(
          user.username,
          p,
          PAGE_SIZE,
          q?.trim() || undefined
        );

        if (reqId !== reqSeqRef.current) return;
        if (isFirst) {
          setItems(resp.data);
        } else {
          setItems(prev => {
            const map = new Map(prev.map(u => [u.username, u]));
            for (const u of resp.data) map.set(u.username, u);
            return Array.from(map.values());
          });
        }
        setPage(resp.currentPage);
        setTotalPages(resp.totalPages);
        setLastQuery(q);
      } catch (e: any) {
        if (reqId !== reqSeqRef.current) return;
        setErr(e?.message ?? 'Failed to load users.');
      } finally {
        if (reqId !== reqSeqRef.current) return;
        if (isFirst) {
          setLoadingInitial(false);
          setReplacing(false);
          setRefreshing(false);
        } else {
          setLoadingMore(false);
        }
      }
    },
    [user]
  );

    useEffect(() => {
      let mounted = true;
      (async () => {
        try {

          setLoadingCurrentUser(true); 
          const userData = await fetchUser(username);
          if (mounted) {
            setUser(userData);
          }
        } catch (e) {
          console.error("Failed to fetch current user:", e);

          Alert.alert("Error", "Failed to fetch current user data. Cannot load discover feed.");
          setErr("Failed to load current user data."); 
          setUser(null); 
        } finally {
            if (mounted) {
                setLoadingCurrentUser(false);
            }
        }
      })();
      return () => {
        mounted = false;
      };
    }, [username]);

  useFocusEffect(
    useCallback(() => {

      if (user) {
          currentQueryRef.current = search.trim();
          loadPage(0, currentQueryRef.current, 'init');
      }
      return () => {

      }

    }, [loadPage, search, user])
  );

  const hasMore = totalPages == null ? false : page + 1 < totalPages;
  const onEndReached = useCallback(() => {
    if (loadingMore || replacing || refreshing || !hasMore || !user) return; 
    loadPage(page + 1, lastQuery, 'scroll');
  }, [loadingMore, replacing, refreshing, hasMore, loadPage, page, lastQuery, user]);

  const onRefresh = useCallback(() => {
    if (!user) return; 
    currentQueryRef.current = lastQuery;
    loadPage(0, currentQueryRef.current, 'refresh');
  }, [lastQuery, loadPage, user]);

  useEffect(() => {

    if (!user) return;

    const q = search.trim();
    const t = setTimeout(() => {
      if (q !== lastQuery) {
        currentQueryRef.current = q;
        loadPage(0, currentQueryRef.current, 'search'); 
      }
    }, 300);
    return () => clearTimeout(t);
  }, [search, lastQuery, loadPage, user]);

  const onToggleFollow = async (targetUsername: string) => {

    if (!user || pending.has(targetUsername) || targetUsername === user.username) return;

    const isFollowing = followingSet.has(targetUsername); 

    const targetItem = items.find(u => u.username === targetUsername);
    if (!targetItem) return;

    setItems(prev =>
      prev.map(u => {
        if (u.username !== targetUsername) return u;
        const already = u.followers?.some(f => f.username === user.username);

        if (!isFollowing && !already) {
          const currentUserAsFollower: User = { username: user.username, name: user.name, email: user.email, description: user.description, avatar_url: user.avatar_url, followers: [], following: [] };
          return { ...u, followers: [currentUserAsFollower, ...(u.followers || [])] };
        }

        if (isFollowing && already) {
          return { ...u, followers: (u.followers || []).filter(f => f.username !== user.username) };
        }
        return u; 
      })
    );
    setPending(prev => new Set(prev).add(targetUsername));
    try {
      if (isFollowing) {
        await unfollowUser(user.username, targetUsername);
      } else {
        await followUser(user.username, targetUsername);
      }

      setUser(prev => {

        if (!prev) return null; 

        const nextFollowing = isFollowing 
          ? prev.following.filter(f => f.username !== targetUsername)
          : [...prev.following, targetItem]; 
        return { ...prev, following: nextFollowing };
      });

    } catch (e: any) {

      Alert.alert('Action failed', e?.message ?? 'Please try again.');

      setItems(prev =>
        prev.map(u => {
          if (u.username !== targetUsername) return u;

          const currentUserAsFollower: User = { username: user.username, name: user.name, email: user.email, description: user.description, avatar_url: user.avatar_url, followers: [], following: [] };

          if (!isFollowing) {

            return { ...u, followers: (u.followers || []).filter(f => f.username !== user.username) };
          } else {

            const wasPresentBeforeRevert = targetItem.followers?.some(f => f.username === user.username);

            if (wasPresentBeforeRevert && !u.followers?.some(f => f.username === user.username)) {

              return { ...u, followers: [currentUserAsFollower, ...(u.followers || [])] };
            }
            return u;
          }
        })
      );
    } finally {
      setPending(prev => {
        const next = new Set(prev);
        next.delete(targetUsername);
        return next;
      });
    }
  };

  const renderItem: ListRenderItem<User> = ({ item }) => (
    <UserRow

      currentUser={user!} 
      item={item}
      isFollowing={followingSet.has(item.username)} 
      isPending={pending.has(item.username)}
      onToggle={onToggleFollow}
    />
  );

  if (loadingCurrentUser) {
    return (
        <View style={styles.initialLoader}>
          <ActivityIndicator size="large" />
          <Text style={{ marginTop: 10 }}>Loading your profile...</Text>
        </View>
    );
  }

  if (!user) {
    return (
        <ThemedView style={[styles.container, { justifyContent: 'center', alignItems: 'center' }]}>
            <ThemedText type="title" style={{ color: 'red' }}>Error Loading Profile</ThemedText>
            <ThemedText style={{ padding: 20, textAlign: 'center' }}>{err || 'Could not retrieve your user data. Please check your connection and try again.'}</ThemedText>
        </ThemedView>
    );
  }

  const emptyList =
    !loadingInitial && !replacing && items.length === 0 ? (
      <ThemedText style={{ padding: 16, textAlign: 'center' }}>
        {err ? `Error: ${err}` : 'No users found.'}
      </ThemedText>
    ) : null;

  return (
    <ThemedView style={styles.container}>
      <ThemedText type="title" style={styles.title}>Discover People 🔎</ThemedText>
      {}
      <View style={styles.searchRow}>
        <TextInput
          value={search}
          onChangeText={setSearch}
          placeholder="Search by name or handle"
          placeholderTextColor="#999"
          style={styles.searchInput}
          returnKeyType="search"
          onSubmitEditing={() => {
            const q = search.trim();
            if (q !== lastQuery) {
              currentQueryRef.current = q;
              loadPage(0, currentQueryRef.current, 'search');
            }
          }}
        />
        <TouchableOpacity
          style={styles.searchBtn}
          onPress={() => {
            const q = search.trim();
            currentQueryRef.current = q;
            loadPage(0, currentQueryRef.current, 'search');
          }}
        >
          <Text style={{ color: '#fff', fontWeight: '600' }}>Search</Text>
        </TouchableOpacity>
      </View>
      {}
      {replacing && (
        <View style={{ paddingHorizontal: 16, paddingBottom: 8 }}>
          <ActivityIndicator />
        </View>
      )}
      <FlatList
        data={items}
        keyExtractor={(u) => u.username}
        renderItem={renderItem}
        contentContainerStyle={{ paddingHorizontal: 16, paddingBottom: 24 }}
        onEndReached={onEndReached}
        onEndReachedThreshold={0.4}
        refreshing={refreshing}
        onRefresh={onRefresh}
        keyboardShouldPersistTaps="handled"
        ListEmptyComponent={emptyList}
        ListFooterComponent={
          loadingMore ? <ThemedText style={{ padding: 12, textAlign: 'center' }}>Loading more…</ThemedText> : null
        }
      />
      {}
      {}
      {loadingInitial && items.length === 0 && !replacing && (
        <View style={styles.initialLoader}>
          <ActivityIndicator size="large" />
        </View>
      )}
    </ThemedView>
  );
}

function UserRow({
  currentUser,
  item,
  isFollowing,
  isPending,
  onToggle,
}: {
  currentUser: User,
  item: User;
  isFollowing: boolean;
  isPending: boolean;
  onToggle: (username: string) => void;
}) {
  const alreadyListed = item.followers?.some(f => f.username === currentUser.username);

  const derivedFollowers = useMemo(() => {
    let base = item.followers || [];

    const currentUserAsFollower: User = { username: currentUser.username, name: currentUser.name, email: currentUser.email, description: currentUser.description, avatar_url: currentUser.avatar_url, followers: [], following: [] };

    if (isFollowing && !alreadyListed) base = [currentUserAsFollower, ...base];

    if (!isFollowing && alreadyListed) base = base.filter(f => f.username !== currentUser.username);
    return base;
  }, [item.followers, isFollowing, alreadyListed, currentUser]);
  const shown = derivedFollowers.slice(0, 2);
  const rest = Math.max(0, derivedFollowers.length - shown.length);
  return (
    <ThemedView style={styles.card}>
      <View style={styles.profileRow}>
        <View style={styles.profileLeft}>
          <Image source={{ uri: item.avatar_url }} style={styles.avatar} />
          <View style={{ gap: 2 }}>
            <ThemedText type="subtitle" style={styles.name}>{item.name}</ThemedText>
            <ThemedText type="default" style={styles.handle}>@{item.username}</ThemedText>
          </View>
        </View>
        <TouchableOpacity
          style={[styles.followBtn, isFollowing && styles.followingBtn, isPending && { opacity: 0.6 }]}
          disabled={isPending || item.username === currentUser.username} 
          onPress={() => onToggle(item.username)}
        >
          <Text style={{ color: isFollowing ? '#4A90E2' : '#fff', fontWeight: '600' }}>
            {item.username === currentUser.username ? 'You' : isFollowing ? 'Following' : 'Follow'}
          </Text>
        </TouchableOpacity>
      </View>
      <View style={styles.followersRow}>
        <StandardAvatarGroup>
          {shown.map((f, idx) => (
            <StandardAvatar
              key={`${item.username}-f-${f.username}`}
              size="lg"
              uri={f.avatar_url}
              fallbackText={f.name}
              style={idx !== 0 ? styles.avatarOverlap : {}}
            />
          ))}
          {rest > 0 && (
            <View style={[styles.avatarBase, styles.avatarOverlap, styles.avatarFallbackRest]}>
              <Text style={styles.avatarFallbackText}>{`+${rest}`}</Text>
            </View>
          )}
        </StandardAvatarGroup>
        <Text style={styles.followerCountText}>
          {derivedFollowers.length > 0 ? `${derivedFollowers.length} follower${derivedFollowers.length !== 1 ? 's' : ''}` : 'No followers'}
        </Text>
      </View>
    </ThemedView>
  );
}

const styles = StyleSheet.create({

  themedView: {
    backgroundColor: '#fff', 
  },
  themedTextDefault: {
    color: '#000', 
    fontSize: 14,
  },
  themedTextSubtitle: {
    color: '#000',
    fontSize: 16,
    fontWeight: '600',
  },
  themedTextTitle: {
    color: '#000',
    fontSize: 24,
    fontWeight: 'bold',
  },
  avatarBase: {
    backgroundColor: '#ccc',
    alignItems: 'center',
    justifyContent: 'center',
  },
  avatarFallbackText: {
    color: '#fff',
    fontSize: 16,
    fontWeight: 'bold',
  },
  avatarGroupContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    marginRight: 10,
  },
  avatarOverlap: {
    marginLeft: -15, 
    borderColor: '#fff',
    borderWidth: 2,
  },
  avatarFallbackRest: {
    width: 50,
    height: 50,
    borderRadius: 25,
    backgroundColor: '#4A90E2', 
  },
  followerCountText: {
    fontSize: 14,
    color: '#666',
  },

  container: { flex: 1, paddingTop: 50, backgroundColor: '#f0f0f0' },
  title: { fontSize: 24, fontWeight: 'bold', marginBottom: 10, paddingHorizontal: 16 },
  searchRow: { flexDirection: 'row', alignItems: 'center', gap: 8, paddingHorizontal: 16, marginBottom: 16 },
  searchInput: {
    flex: 1, height: 40, borderWidth: 1, borderColor: '#ccc', borderRadius: 8,
    paddingHorizontal: 10, backgroundColor: '#fff', color: '#000',
  },
  searchBtn: {
    backgroundColor: '#4A90E2',
    paddingHorizontal: 14,
    height: 40,
    borderRadius: 8,
    justifyContent: 'center',
  },
  card: {
    backgroundColor: '#fff',
    borderRadius: 12,
    padding: 15,
    marginBottom: 15,
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.1,
    shadowRadius: 4,
    elevation: 3,
  },
  profileRow: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    marginBottom: 10,
  },
  profileLeft: { flexDirection: 'row', alignItems: 'center' },
  avatar: { width: 50, height: 50, borderRadius: 25, marginRight: 12, backgroundColor: '#eee' },
  name: { fontSize: 16, fontWeight: 'bold' },
  handle: { fontSize: 13, color: '#666' },
  followBtn: { backgroundColor: '#4A90E2', paddingVertical: 8, paddingHorizontal: 15, borderRadius: 20 },
  followingBtn: { backgroundColor: '#E8F1FD', borderWidth: 1, borderColor: '#4A90E2' },
  followersRow: {
    flexDirection: 'row',
    alignItems: 'center',
    paddingTop: 10,
    borderTopWidth: 1,
    borderTopColor: '#eee',
  },
  initialLoader: {
    ...StyleSheet.absoluteFillObject,
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: 'rgba(255, 255, 255, 0.7)',
  },
});