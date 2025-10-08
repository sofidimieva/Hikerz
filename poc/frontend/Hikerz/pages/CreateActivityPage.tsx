import { SetStateAction, useState } from "react";
import { styled } from "@gluestack-style/react";
import { View, Text, Pressable } from "react-native";
import { ActivityOption } from "../components/ui/ActivityOption";
import { Switch } from "../components/ui/Switch";
import { Input } from "../components/ui/Input";
import { Map, FileText, Mountain, ChevronRight } from "lucide-react-native";

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
  fontSize: "$lg",
  fontWeight: "$semibold",
  color: "$white",
});

const OptionsWrapper = styled(View, {
  p: "$4",
  gap: "$3",
});

const PostWrapper = styled(View, {
  bg: "$white",
  borderTopWidth: "$1",
  borderTopColor: "$gray200",
  p: "$4",
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

export default function CreateActivityPage() {
  const [postDetails, setPostDetails] = useState(false);
  const [notes, setNotes] = useState("");

  return (
    <Container>
      {/* Header */}
      <Header>
        <HeaderText>Create Activity</HeaderText>
        <Pressable>
          <ChevronRight color="white" size={24} />
        </Pressable>
      </Header>

      {/* Options */}
      <OptionsWrapper>
        <ActivityOption
          icon={<Mountain color="black" size={24} />}
          title="Track Hike"
          subtitle="Record your hike with GPS"
        />
        <ActivityOption
          icon={<FileText color="black" size={24} />}
          title="Import GPX"
          subtitle="Import from a GPS file"
        />
        <ActivityOption
          icon={<Map color="black" size={24} />}
          title="Plan Route"
          subtitle="Create a route on the map"
        />
      </OptionsWrapper>

      {/* Post */}
      <PostWrapper>
        <View
          style={{ flexDirection: "row", justifyContent: "space-between", marginBottom: 8 }}
        >
          <Text style={{ fontWeight: "500" }}>Create Post</Text>
          <Switch checked={postDetails} onChange={setPostDetails} />
        </View>
        {postDetails && (
          <Input
            placeholder="Notes"
            value={notes}
            onChangeText={(text: SetStateAction<string>) => setNotes(text)}
          />
        )}
      </PostWrapper>

    </Container>
  );
}
