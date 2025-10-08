import { styled } from "@gluestack-style/react";
import { View, Text, Pressable } from "react-native";

const Card = styled(View, {
  bg: "$white",
  borderRadius: "$lg",
  p: "$4",
  m: "$2",
  flex: 1,
  minHeight: 120,
  justifyContent: "center",
  alignItems: "center",
  shadowColor: "$sm",
});

const Button = styled(Pressable, {
  bg: "$green700",
  px: "$4",
  py: "$2",
  borderRadius: "$md",
  mt: "$2",
});

const ButtonText = styled(Text, {
  color: "$white",
  fontWeight: "600",
});

type ChallengeCardProps = {
  title?: string;
  onJoin?: () => void;
};

export const ChallengeCard = ({ title, onJoin }: ChallengeCardProps) => {
  return (
    <Card>
      {title && <Text style={{ marginBottom: 8, fontWeight: "600" }}>{title}</Text>}
      <Button onPress={onJoin}>
        <ButtonText>Join</ButtonText>
      </Button>
    </Card>
  );
};
