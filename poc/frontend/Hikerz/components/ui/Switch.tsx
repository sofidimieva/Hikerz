import { styled } from "@gluestack-style/react";
import { Pressable, View } from "react-native";

interface SwitchProps {
    checked: boolean;
    onChange: (checked: boolean) => void;
}

const SwitchContainer = styled(
    Pressable,
    {
        w: "$10",
        h: "$5",
        rounded: "$full",
        p: "$1",
        bg: "$gray300",
        justifyContent: "center",
        variants: {
            checked: {
                true: {
                    bg: "$green500",
                },
            },
        },
    }
);

const Thumb = styled(View, {
    w: "$4",
    h: "$4",
    rounded: "$full",
    bg: "$white",
    shadowColor: "$sm",
});

export function Switch({ checked, onChange }: SwitchProps) {
    return (
        <SwitchContainer
            checked={checked}
            accessibilityRole="switch"
            accessibilityState={{ checked }}
            onPress={() => onChange(!checked)}
        >
            <Thumb style={{ transform: [{ translateX: checked ? 20 : 0 }] }} />
        </SwitchContainer>
    );
}
4