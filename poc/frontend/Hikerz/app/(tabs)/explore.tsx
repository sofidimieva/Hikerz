import { StyleSheet } from 'react-native';
import CreateActivityPage from '@/pages/ExplorePage';
import { GluestackUIProvider } from '@gluestack-ui/themed';
import { config } from '@gluestack-ui/config';
import ExplorePage from '@/pages/ExplorePage';

export default function ExploreScreen() {
  return (
    <GluestackUIProvider config={config}>
      <ExplorePage/>
    </GluestackUIProvider>
  );
}

const styles = StyleSheet.create({});
