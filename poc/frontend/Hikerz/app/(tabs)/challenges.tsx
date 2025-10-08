import ChallengesPage from "@/pages/ChallengePage";
import { StyleSheet } from 'react-native';
import { GluestackUIProvider } from '@gluestack-ui/themed';
import { config } from '@gluestack-ui/config';

export default function ChallengesScreen() {
  return (
    <GluestackUIProvider config={config}>
      <ChallengesPage />
    </GluestackUIProvider>
  );
}

const styles = StyleSheet.create({});
