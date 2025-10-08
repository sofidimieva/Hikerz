import { styled } from "@gluestack-style/react";
import { View, Text, Image } from "react-native";

const Card = styled(View, {
  bg: "$white",
  borderRadius: "$lg",
  p: "$4",
  m: "$4",
  shadowColor: "$sm",
  alignItems: "center",
});

const Row = styled(View, {
  flexDirection: "row",
  alignItems: "center",
  justifyContent: "center",
  gap: "$8",
});

type ProfileCardProps = {
  name: string;
  avatar?: string;
  followers: number;
  following: number;
};

export const ProfileCard = ({ name, avatar, followers, following }: ProfileCardProps) => {
  const initials = name
    .split(' ')
    .map((p) => p[0])
    .slice(0, 2)
    .join('')
    .toUpperCase();

  return (
    <Card>
      {avatar ? (
        <Image
          source={{ uri: avatar }}
          style={{ width: 80, height: 80, borderRadius: 40, marginBottom: 12 }}
        />
      ) : (
        <View
          style={{
            width: 80,
            height: 80,
            borderRadius: 40,
            marginBottom: 12,
            backgroundColor: '#c7f0dc',
            alignItems: 'center',
            justifyContent: 'center',
          }}
        >
          <Text style={{ fontWeight: '700', fontSize: 20 }}>{initials}</Text>
        </View>
      )}
      <Text style={{ fontWeight: "700", fontSize: 16, marginBottom: 8 }}>{name}</Text>
      <Row>
        <View style={{ alignItems: "center" }}>
          <Text style={{ fontWeight: "600" }}>{followers}</Text>
          <Text>Followers</Text>
        </View>
        <View style={{ alignItems: "center" }}>
          <Text style={{ fontWeight: "600" }}>{following}</Text>
          <Text>Following</Text>
        </View>
      </Row>
    </Card>
  );
};
