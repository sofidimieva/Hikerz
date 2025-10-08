import { ScrollView, View, Text, Pressable } from "react-native";
import { styled } from "@gluestack-style/react";
import { ChallengeCard } from "../components/ui/ChallengeCard";
import { Home, List, Circle, Map, Settings, Send, Bell } from "lucide-react-native";

const Container = styled(View, {
  flex: 1,
  bg: "$gray100",
});

const Header = styled(View, {
  flexDirection: "row",
  justifyContent: "space-between",
  alignItems: "center",
  bg: "$green700",
  p: "$4",
});

const HeaderText = styled(Text, {
  fontSize: 18,
  fontWeight: "bold",
  color: "white",
});

const Row = styled(View, {
  flexDirection: "row",
  alignItems: "center",
  gap: "$4",
});

const Tabs = styled(View, {
  flexDirection: "row",
  justifyContent: "space-around",
  bg: "$green700",
  px: "$4",
  py: "$2",
});

const TabText = styled(Text, {
  color: "$white",
  fontWeight: "600",
});

const Section = styled(View, {
  marginVertical: "$4",
  px: "$4",
});

const SectionTitle = styled(Text, {
  fontWeight: "700",
  marginBottom: "$2",
});

const Grid = styled(View, {
  flexDirection: "row",
  flexWrap: "wrap",
  justifyContent: "space-between",
});

const BottomNav = styled(View, {
  position: "absolute",
  bottom: 0,
  left: 0,
  right: 0,
  flexDirection: "row",
  justifyContent: "space-around",
  bg: "$gray50",
  borderTopWidth: "$1",
  borderTopColor: "$gray200",
  p: "$2",
});

export default function ChallengesPage() {
  return (
    <Container>
      {/* Header */}
      <Header>
        <HeaderText>Challenges</HeaderText>
        <Row>
          <Send color="white" />
          <Bell color="white" />
          <Settings color="white" />
        </Row>
      </Header>

      {/* Tabs */}
      <Tabs>
        <Pressable>
          <TabText>Challenges</TabText>
        </Pressable>
        <Pressable>
          <TabText>LeaderBoard</TabText>
        </Pressable>
      </Tabs>

      <ScrollView style={{ marginBottom: 60 }}>
        {/* Popular Challenges */}
        <Section>
          <SectionTitle>Popular Challenges</SectionTitle>
          <Grid>
            <ChallengeCard title="5 Hikes in a Week" />
            <ChallengeCard title="Climb 2 Peaks" />
          </Grid>
        </Section>

        {/* Recommended Challenges */}
        <Section>
          <SectionTitle>Recommended For You</SectionTitle>
          <Text style={{ marginBottom: 8, color: "#555" }}>
            Based On Your Activities
          </Text>
          <Grid>
            <ChallengeCard title="Trail Explorer" />
            <ChallengeCard title="Weekend Hiker" />
            <ChallengeCard title="Sunset Walks" />
            <ChallengeCard title="100 km Month" />
          </Grid>
        </Section>
      </ScrollView>
    </Container>
  );
}
