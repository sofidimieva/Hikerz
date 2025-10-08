import { ReactNode } from "react";
import { styled } from "@gluestack-style/react";
import { View, Text, Pressable } from "react-native";
import { Card } from "./Card";

interface ActivityOptionProps {
    icon: ReactNode;
    title: string;
    subtitle: string;
    onPress?: () => void;
}

const Row = styled(View, {
    flexDirection: "row",
    alignItems: "center",
});

const IconWrapper = styled(View, {
    mr: "$3",
});

const Title = styled(Text, {
    fontSize: "$md",
    fontWeight: "$medium",
    color: "$gray900",
});

const Subtitle = styled(Text, {
    fontSize: "$sm",
    color: "$gray500",
});

export function ActivityOption({ icon, title, subtitle, onPress }: ActivityOptionProps) {
    return (
        <Card>
            <Pressable onPress={onPress} style={{ flex: 1 }} accessibilityRole={onPress ? "button" : undefined}>
                <Row>
                    <IconWrapper>{icon}</IconWrapper>
                    <View>
                        <Title>{title}</Title>
                        <Subtitle>{subtitle}</Subtitle>
                    </View>
                </Row>
            </Pressable>
        </Card>
    );
}
