import { Image } from 'expo-image';
import { StyleSheet } from 'react-native';
import ParallaxScrollView from '@/components/parallax-scroll-view';
import { ThemedText } from '@/components/themed-text';
import { ThemedView } from '@/components/themed-view';
import { Link } from 'expo-router';

export default function HomeScreen() {
  return (
    <ParallaxScrollView
      headerBackgroundColor={{ light: '#A1CEDC', dark: '#1D3D47' }}
      headerImage={
        <Image
          source={require('@/assets/images/partial-react-logo.png')}
          style={styles.headerArt}
        />
      }
    >
      {/* Title */}
      <ThemedView style={styles.titleRow}>
        <ThemedText type="title">TrailShare</ThemedText>
        <ThemedText type="default" style={styles.subtitle}>
          Turn solo hikes into shared experiences.
        </ThemedText>
      </ThemedView>

      {/* One-liner / purpose */}
      <ThemedView style={styles.card}>
        <ThemedText type="subtitle">Why TrailShare?</ThemedText>
        <ThemedText>
          Hiking is often a solo activity with few ways to connect. Inspired by running
          apps like Strava, TrailShare builds community around the trail—so you can
          discover, share, and stay motivated.
        </ThemedText>
      </ThemedView>

      {/* Primary functions */}
      <ThemedView style={styles.card}>
        <ThemedText type="subtitle">What you can do</ThemedText>
        <ThemedText>{'• Log hikes (route, distance, time, difficulty)'}</ThemedText>
        <ThemedText>{'• See your interactive map of completed hikes'}</ThemedText>
        <ThemedText>{'• Explore friends’ maps & popular trails'}</ThemedText>
        <ThemedText>{'• Upload & share photos for each activity'}</ThemedText>
        <ThemedText>{'• View per-route stats (e.g., avg duration/difficulty)'}</ThemedText>
        <ThemedText>{'• Create or join challenges for motivation'}</ThemedText>
      </ThemedView>

      {/* Quick actions */}
      <ThemedView style={styles.actions}>
        <Link href="/log" asChild>
          <ThemedView style={[styles.actionBtn, styles.primary]}>
            <ThemedText type="defaultSemiBold">Log a Hike</ThemedText>
          </ThemedView>
        </Link>

        <Link href="/explore" asChild>
          <ThemedView style={styles.actionBtn}>
            <ThemedText type="defaultSemiBold">Explore Routes</ThemedText>
          </ThemedView>
        </Link>

        <Link href="/challenges" asChild>
          <ThemedView style={styles.actionBtn}>
            <ThemedText type="defaultSemiBold">Join a Challenge</ThemedText>
          </ThemedView>
        </Link>
      </ThemedView>

      {/* Inspiration / motivation footer */}
      <ThemedView style={styles.footer}>
        <ThemedText type="default">
          Motivation: connection, discovery, and healthy activity.
        </ThemedText>
      </ThemedView>
    </ParallaxScrollView>
  );
}

const styles = StyleSheet.create({
  headerArt: {
    height: 180,
    width: 300,
    position: 'absolute',
    bottom: 0,
    left: 0,
  },
  titleRow: {
    gap: 4,
    marginBottom: 4,
  },
  subtitle: {
    opacity: 0.8,
  },
  card: {
    gap: 6,
    padding: 12,
    borderRadius: 16,
    borderWidth: StyleSheet.hairlineWidth,
    borderColor: 'rgba(0,0,0,0.08)',
    marginBottom: 12,
  },
  actions: {
    gap: 10,
    marginTop: 4,
    marginBottom: 12,
  },
  actionBtn: {
    paddingVertical: 12,
    paddingHorizontal: 14,
    borderRadius: 14,
    alignItems: 'center',
    borderWidth: StyleSheet.hairlineWidth,
    borderColor: 'rgba(0,0,0,0.12)',
  },
  primary: {
    borderColor: 'transparent',
    backgroundColor: 'rgba(0,0,0,0.06)',
  },
  footer: {
    marginTop: 8,
    alignItems: 'center',
    opacity: 0.8,
  },
});
