import { styled } from "@gluestack-style/react";
import { View, Text } from "react-native";
import { TrailCard } from "./TrailCard";

const Section = styled(View, {
  marginVertical: "$4",
  px: "$4",
});

const SectionTitle = styled(Text, {
  fontWeight: "700",
  marginBottom: "$2",
  fontSize: "$lg",
});

const Grid = styled(View, {
  flexDirection: "row",
  flexWrap: "wrap",
  justifyContent: "space-between",
});

type TrailSectionProps = {
  title: string;
  trails: { name: string; distance: string; elevation: string; friend?: string }[];
};

export const TrailSection = ({ title, trails }: TrailSectionProps) => (
  <Section>
    <SectionTitle>{title}</SectionTitle>
    <Grid>
      {trails.map((t, idx) => (
        <TrailCard key={idx} {...t} />
      ))}
    </Grid>
  </Section>
);
