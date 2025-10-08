import { styled } from "@gluestack-style/react";
import { View, Text, Pressable, Image } from "react-native";

const Card = styled(View, {
  bg: "$white",
  borderRadius: "$xl",
  p: "$3",
  m: "$3",
  shadowColor: "$sm",
  width: "92%", // expand across the screen
  alignSelf: "center",
});

const TrailImage = styled(Image, {
  width: "100%",
  height: 180, // bigger image
  borderRadius: "$lg",
  marginBottom: "$3",
});

const Title = styled(Text, {
  fontWeight: "700",
  fontSize: "$lg",
  marginBottom: "$1",
});

const Info = styled(Text, {
  fontSize: "$sm",
  color: "$gray700",
  marginBottom: "$2",
});

const Button = styled(Pressable, {
  bg: "$green700",
  px: "$4",
  py: "$3",
  borderRadius: "$md",
  alignItems: "center",
  justifyContent: "center",
});

const ButtonText = styled(Text, {
  color: "$white",
  fontWeight: "600",
  fontSize: "$sm",
});

type TrailCardProps = {
  name: string;
  distance: string;
  elevation: string;
  friend?: string;
  onView?: () => void;
};

export const TrailCard = ({ name, distance, elevation, friend, onView }: TrailCardProps) => (
  <Card>
    {/* Use a seeded picsum URL so different trails show different photos */}
    <TrailImage source={{ uri: `https://picsum.photos/seed/${encodeURIComponent(
      name
    )}/600/300` }} />
    <Title>{name}</Title>
    <Info>{distance} • {elevation}</Info>
    {friend && <Info>👤 Tried by {friend}</Info>}
    <Button onPress={onView}>
      <ButtonText>View</ButtonText>
    </Button>
  </Card>
);
