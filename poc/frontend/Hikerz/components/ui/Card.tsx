import { styled } from "@gluestack-style/react";
import { View } from "react-native";

export const Card = styled(View, {
    bg: "$white",
    borderRadius: "$lg",
    shadowColor: "$sm",
    p: "$3",


    _hover: {
        shadow: "$md",
        bg: "$gray100",
    },
});
