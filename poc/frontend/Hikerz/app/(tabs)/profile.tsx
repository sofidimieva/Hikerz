import ParallaxScrollView from '@/components/parallax-scroll-view';
import { ThemedText } from '@/components/themed-text';
import { ThemedView } from '@/components/themed-view';
import { Fonts } from '@/constants/theme';
import { useEffect, useMemo, useState } from 'react';
import { ActivityIndicator, Image, StyleSheet, View } from 'react-native';

import type { User } from '../services/userService';
import { fetchUser } from '../services/userService';

type ProfileScreenProps = {
  route?: { params?: { username?: string } };
};

export default function ProfileScreen({ route }: ProfileScreenProps) {

  const username = route?.params?.username ?? 'filipcirtog';

  const [user, setUser] = useState<User | null>(null);
  const [pending, setPending] = useState(true);
  const [error, setError] = useState<string | null>(null);

  const avatarSrc = useMemo(() => {
    if (!user) return undefined;
    const anyUser = user as any;
    return anyUser.avatar_url ?? anyUser.avatarUrl ?? undefined;
  }, [user]);

  const followersCount = user?.followers?.length ?? 0;
  const followingCount = user?.following?.length ?? 0;

  useEffect(() => {
    let mounted = true;
    (async () => {
      try {
        setPending(true);
        const data = await fetchUser(username);
        if (mounted) {
          setUser(data);
          setError(null);
        }
      } catch (e: any) {
        if (mounted) setError(e?.message ?? 'Failed to load user');
      } finally {
        if (mounted) setPending(false);
      }
    })();
    return () => {
      mounted = false;
    };
  }, [username]);

  return (
    <ParallaxScrollView
      headerBackgroundColor={{ light: '#D0D0D0', dark: '#353636' }}
      headerImage={
        <View style={styles.headerImageContainer}>
          <Image
            source={{
              uri:
                avatarSrc
            }}
            style={styles.profileImage}
          />
        </View>
      }
    >
      {}
      {pending && (
        <ThemedView style={{ paddingVertical: 24 }}>
          <ActivityIndicator />
        </ThemedView>
      )}
      {error && !pending && (
        <ThemedView style={styles.infoBlock}>
          <ThemedText type="subtitle" style={styles.infoTitle}>
            Oops
          </ThemedText>
          <ThemedText style={styles.descriptionText}>{error}</ThemedText>
        </ThemedView>
      )}

      {}
      {!pending && !error && user && (
        <>
          <ThemedView style={styles.titleContainer}>
            <ThemedText type="title" style={styles.profileTitle}>
              {user.name || user.username}
            </ThemedText>
            <ThemedText type="defaultSemiBold" style={styles.profileSubtitle}>
              @{user.username}
            </ThemedText>
          </ThemedView>

          {}
          <ThemedView style={styles.statsContainer}>
            <View style={styles.statColumn}>
              <ThemedText type="title" style={styles.statNumber}>
                {followersCount}
              </ThemedText>
              <ThemedText type="defaultSemiBold" style={styles.statLabel}>
                Followers
              </ThemedText>
            </View>
            <View style={styles.statColumn}>
              <ThemedText type="title" style={styles.statNumber}>
                {followingCount}
              </ThemedText>
              <ThemedText type="defaultSemiBold" style={styles.statLabel}>
                Following
              </ThemedText>
            </View>
          </ThemedView>

          {}
          <ThemedView style={styles.infoBlock}>
            <ThemedText type="subtitle" style={styles.infoTitle}>
              Contact Information
            </ThemedText>
            <ThemedText type="default" style={styles.infoRow}>
              <ThemedText style={{ fontWeight: 'bold' }}>Email:</ThemedText>{' '}
              {user.email ?? '—'}
            </ThemedText>
          </ThemedView>

          {}
          <ThemedView style={styles.infoBlock}>
            <ThemedText type="subtitle" style={styles.infoTitle}>
              Description
            </ThemedText>
            <ThemedText style={styles.descriptionText}>
              {user.description || '—'}
            </ThemedText>
          </ThemedView>
        </>
      )}
    </ParallaxScrollView>
  );
}

const styles = StyleSheet.create({
  headerImageContainer: {
    height: 250,
    justifyContent: 'center',
    alignItems: 'center',
  },
  profileImage: {
    width: 120,
    height: 120,
    borderRadius: 60,
    borderWidth: 3,
    borderColor: '#FFFFFF',
  },
  titleContainer: {
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center',
    marginTop: 20,
  },
  profileTitle: {
    fontFamily: Fonts.rounded,
    fontSize: 28,
    fontWeight: 'bold',
    color: '#333',
    marginBottom: 4,
  },
  profileSubtitle: {
    fontSize: 16,
    color: '#666',
    marginBottom: 20,
  },
  statsContainer: {
    flexDirection: 'row',
    justifyContent: 'space-around',
    alignItems: 'center',
    paddingVertical: 15,
    marginHorizontal: 16,
    borderRadius: 10,
    backgroundColor: '#fff',
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.1,
    shadowRadius: 3,
    elevation: 3,
    marginBottom: 20,
  },
  statColumn: { alignItems: 'center' },
  statNumber: { fontSize: 22, fontWeight: 'bold', color: '#4A90E2' },
  statLabel: { fontSize: 14, color: '#666', marginTop: 4 },
  infoBlock: {
    paddingHorizontal: 16,
    marginTop: 10,
    backgroundColor: '#f9f9f9',
    borderRadius: 10,
    paddingVertical: 16,
    marginHorizontal: 16,
    marginBottom: 10,
  },
  infoTitle: {
    fontSize: 18,
    fontWeight: 'bold',
    color: '#333',
    marginBottom: 8,
    borderBottomWidth: 1,
    borderBottomColor: '#eee',
    paddingBottom: 5,
  },
  infoRow: { fontSize: 16, color: '#555' },
  descriptionText: { fontSize: 16, color: '#666', marginTop: 8, lineHeight: 24 },
});