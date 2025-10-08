import { ScrollView, View } from "react-native";
import { styled } from "@gluestack-style/react";
import { TrailSection } from "../components/ui/TrailSection";
import { Home, List, Circle, Map, Settings } from "lucide-react-native";

const Container = styled(View, {
  flex: 1,
  bg: "$gray100",
});

const Header = styled(View, {
  bg: "$green700",
  p: "$4",
});

import { Text } from "react-native";

const HeaderText = styled(Text, {
  fontSize: 18,
  fontWeight: "bold",
  color: "white",
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

export default function ExplorePage() {
  return (
    <Container>
      {/* Header */}
      <Header>
        <HeaderText>Explore</HeaderText>
      </Header>

      {/* Content */}
      <ScrollView style={{ marginBottom: 60 }}>
        <TrailSection
          title="Recommended Trails"
          trails={[
            { name: "Green Valley Trail", distance: "8.2 km", elevation: "450 m" },
            { name: "Eagle Peak Loop", distance: "12 km", elevation: "780 m" },
            { name: "Waterfall Walk", distance: "5 km", elevation: "200 m" },
            { name: "Sunset Ridge", distance: "10 km", elevation: "600 m" },
          ]}
        />

        <TrailSection
          title="Tried by Friends Near You"
          trails={[
            { name: "Forest Creek Path", distance: "7 km", elevation: "300 m", friend: "Alice" },
            { name: "Rocky Summit", distance: "14 km", elevation: "900 m", friend: "John" },
          ]}
        />
      </ScrollView>
    </Container>
  );
}
