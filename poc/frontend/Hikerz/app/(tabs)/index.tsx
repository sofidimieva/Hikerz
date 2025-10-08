import { styled } from "@gluestack-style/react";
import { Bell, Send, Settings } from "lucide-react-native";
import { ScrollView, Text, View } from "react-native";
import { ActivityCard } from "../../components/ui/ActivityCard";
import { ProfileCard } from "../../components/ui/ProfileCard";

// Local photos uploaded to components/photos/
const local = {
    dolomites1: require('../../components/photos/dolomites1.jpg'),
    dolomites2: require('../../components/photos/dolomites2.avif'),
    dolomites3: require('../../components/photos/dolomites3.jpg'),
    forest1: require('../../components/photos/forest1.webp'),
    forest2: require('../../components/photos/forest2.webp'),
    forest3: require('../../components/photos/forest3.webp'),
};

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

export default function HomePage() {
    const hikes = [
        {
            title: "Morning Hike in the Alps",
            description: "Scenic route with amazing views.",
            distance: "14.7 km",
            elevation: "1,160 m",
            achievements: 2,
            likes: 24,
            images: [local.dolomites1, local.dolomites2, local.dolomites3],
            elevationProfile:
                'https://images.unsplash.com/photo-1501785888041-af3ef285b470?w=800&h=200&fit=crop',
        },
        {
            title: "Evening Forest Hike",
            description: "Quiet trail through the woods.",
            distance: "7.2 km",
            elevation: "320 m",
            achievements: 1,
            likes: 12,
            images: [local.forest1, local.forest2, local.forest3],
        },
    ];

    return (
        <Container>
            {/* Header */}
            <Header>
                <HeaderText>Home</HeaderText>
                <Row>
                    <Send color="white" />
                    <Bell color="white" />
                    <Settings color="white" />
                </Row>
            </Header>

            <ScrollView>
                {/* Profile */}
                <ProfileCard name="Polly Dimieva" followers={120} following={80} />

                {/* Hikes */}
                {hikes.map((hike, idx) => (
                    <ActivityCard key={idx} {...hike} />
                ))}
            </ScrollView>
           
        </Container>
    );
}
