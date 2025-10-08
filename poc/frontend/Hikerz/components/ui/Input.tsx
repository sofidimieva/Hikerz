
import { styled } from "@gluestack-style/react";
import { TextInput } from "react-native";

export const Input = styled(
    TextInput,
    {
        borderWidth: "$1",
        borderColor: "$gray300",
        rounded: "$md",
        px: "$3",
        py: "$2",
        fontSize: "$sm",
        color: "$gray900",
    }
);

