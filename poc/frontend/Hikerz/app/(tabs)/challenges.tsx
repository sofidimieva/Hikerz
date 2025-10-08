import ChallengesPage from "@/pages/ChallengePage";
import { config } from '@gluestack-ui/config';
import { GluestackUIProvider } from '@gluestack-ui/themed';
import { StyleSheet } from 'react-native';

export default function ChallengesScreen() {
  return (
    <GluestackUIProvider config={config}>
      <ChallengesPage />
    </GluestackUIProvider>
  );
}

const styles = StyleSheet.create({});
