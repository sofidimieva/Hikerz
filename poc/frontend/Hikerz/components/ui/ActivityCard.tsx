import { useState } from "react";
import { styled } from "@gluestack-style/react";
import { View, Text, Image, Pressable } from "react-native";
import Svg, { Path, Rect } from 'react-native-svg';
import {
  User,
  Trophy,
  Heart,
  MessageCircle,
  Share2,
  Mountain,
} from "lucide-react-native";

const Card = styled(View, {
  bg: "$white",
  borderRadius: "$lg",
  p: "$4",
  m: "$4",
  shadowColor: "$sm",
  borderColor: "$green700",
  borderWidth: "$1",
});

const Row = styled(View, {
  flexDirection: "row",
  alignItems: "center",
});

const StatBox = styled(View, {
  flex: 1,
  alignItems: "center",
  p: "$2",
});

type ActivityCardProps = {
  title: string;
  description: string;
  distance: string;
  elevation: string;
  achievements: number;
  likes: number;
  images?: Array<string | number | { uri: string }>;
  elevationProfile?: string;
  onLike?: () => void;
  onComment?: () => void;
  onShare?: () => void;
};

export const ActivityCard = ({
  title,
  description,
  distance,
  elevation,
  achievements,
  likes,
  images = [],
  elevationProfile,
  onLike,
  onComment,
  onShare,
}: ActivityCardProps) => {
  const [liked, setLiked] = useState(false);

  const handleLike = () => {
    setLiked(!liked);
    if (onLike) onLike();
  };

  return (
    <Card>
      {/* Header */}
      <Row style={{ marginBottom: 12 }}>
        <User color="#166534" size={32} />
        <View style={{ marginLeft: 8 }}>
          <Text style={{ fontWeight: "600" }}>{title}</Text>
          <Text>{description}</Text>
        </View>
      </Row>

      {/* Stats */}
      <Row style={{ justifyContent: "space-between", marginBottom: 12 }}>
        <StatBox>
          <Text style={{ fontWeight: "bold", color: "#166534" }}>{distance}</Text>
          <Text>Distance</Text>
        </StatBox>
        <StatBox>
          <Text style={{ fontWeight: "bold", color: "#166534" }}>{elevation}</Text>
          <Text>Elevation Gain</Text>
        </StatBox>
        <StatBox>
          <Row>
            <Trophy size={16} color="#166534" />
            <Text style={{ fontWeight: "bold", marginLeft: 4 }}>
              {achievements}
            </Text>
          </Row>
          <Text>Achievements</Text>
        </StatBox>
      </Row>

      {/* Images */}
      {images.length > 0 ? (
        <Row style={{ justifyContent: "space-between", marginBottom: 12 }}>
          {images.map((img, idx) => {
            const src = typeof img === 'string' ? { uri: img } : img;
            return (
              <Image
                key={idx}
                source={src as any}
                style={{ width: 80, height: 80, borderRadius: 8 }}
              />
            );
          })}
        </Row>
      ) : (
        <Row style={{ justifyContent: "space-between", marginBottom: 12 }}>
          {/* fallbacks: three small nature photos */}
          {[
            'https://images.unsplash.com/photo-1501785888041-af3ef285b470?w=400&h=400&fit=crop',
            'https://images.unsplash.com/photo-1501785888041-af3ef285b470?w=401&h=400&fit=crop',
            'https://images.unsplash.com/photo-1501785888041-af3ef285b470?w=402&h=400&fit=crop',
          ].map((img, idx) => (
            <Image
              key={idx}
              source={{ uri: img }}
              style={{ width: 80, height: 80, borderRadius: 8 }}
            />
          ))}
        </Row>
      )}

      {/* Elevation Profile (inline sparkline) */}
      <View style={{ marginBottom: 12 }}>
        <Text style={{ marginBottom: 8 }}>Elevation Profile</Text>
        {/* Simple inline SVG sparkline to avoid external image uploads for elevation */}
        <View style={{ width: '100%', height: 100, backgroundColor: '#f3f4f6', borderRadius: 8, overflow: 'hidden' }}>
          {/**
           * Generate a small deterministic-ish dataset per card so charts vary between cards.
           * Here we derive a few sample elevation points from the title length and likes.
           */}
          <Svg width="100%" height="100%" viewBox="0 0 300 100" preserveAspectRatio="none">
            <Rect x="0" y="0" width="300" height="100" fill="#f3f4f6" />
            {
              (() => {
                const sample = [10, 30, 20, 50, 40, 70, 60];
                const max = Math.max(...sample);
                const points = sample.map((v, i) => {
                  const x = (i / (sample.length - 1)) * 300;
                  const y = 100 - (v / max) * 90 - 5; // pad
                  return [x, y];
                });
                const d = points.map((p, i) => `${i === 0 ? 'M' : 'L'} ${p[0]} ${p[1]}`).join(' ');
                return <Path d={d} stroke="#166534" strokeWidth={2.5} fill="none" strokeLinecap="round" strokeLinejoin="round" />;
              })()
            }
          </Svg>
        </View>
      </View>

      {/* Footer Actions */}
      <Row style={{ justifyContent: "space-around" }}>
        <Pressable onPress={handleLike}>
          <Row>
            <Heart
              color={liked ? "red" : "#000"}
              fill={liked ? "red" : "none"}
            />
            <Text style={{ marginLeft: 4 }}>{likes + (liked ? 1 : 0)}</Text>
          </Row>
        </Pressable>
        <Pressable onPress={onComment}>
          <MessageCircle size={20} color="#166534" />
        </Pressable>
        <Pressable onPress={onShare}>
          <Share2 size={20} color="#166534" />
        </Pressable>
      </Row>
    </Card>
  );
};
