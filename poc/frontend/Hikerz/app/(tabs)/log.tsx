import { StyleSheet } from 'react-native';
import CreateActivityPage from '@/pages/CreateActivityPage';
import { GluestackUIProvider } from '@gluestack-ui/themed';
import { config } from '@gluestack-ui/config';

export default function LogScreen() {
  return (
    <GluestackUIProvider config={config}>
      <CreateActivityPage />
    </GluestackUIProvider>
  );
}

const styles = StyleSheet.create({});
