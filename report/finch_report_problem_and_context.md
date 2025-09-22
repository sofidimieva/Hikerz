## Finch Report – Hikerz: A Privacy-Aware Hiking Network

### Problem Statement and Motivation
We propose a new outdoor hiking app named Hikerz which will record hiking routes on mobile applications. While currenttly similar platforms exist (like Strava or Komot), they only provide a series of festures for activity tracking, mainly focused on running, cycling and swimming. Therefore, these platforms present the following three shortcomings:
- insufficient privacy controls around sensitive location data
- limited peak-focused progression and gamification for mountaineers
- lack of strong community features centered around trusted social graphs

Hikerz aspires to serve both casual hikers seeking motivation and dedicated mountaineers striving toward regional peak goals. By addressing these shortcomings, Hikerz could attract a significant number of users from existing platforms like Strava, Komoot, and others.

### Stakeholders and Context (Interest Map)
- Keep Satisfied: 
   - Community Organizers: Clubs or informal groups managing private or public hiking challenges.
   - Local Authorities: Municipal or regional entities interested in promoting local hiking trails and ensuring safety and environmental protection.
- Managed Closely
   - Primary Users: Hikers, mountaineers, and outdoor enthusiasts seeking to record, share, and explore hiking routes.
   - Friends and Family: Benefiting from trusted sharing, ensuring privacy rather than fully public exposure.
- Monitor (Minimum effort)
   - Amateur Sports People: Casual hikers or fitness enthusiasts exploring trails occasionally.
   - Fitness App Users: Individuals using other fitness tracking platforms who might expand their activities to include hiking.
- Keep Informed
   - Students: Individuals using the platform for educational purposes, such as geography or outdoor clubs.
   - Local Business Owners: Small businesses near popular trails that might benefit from exposure through the app.

### Context analysis

- Context problems
    - Connectivity in the outdoors is intermittent; offline-first design is required.
    - Privacy risks are high: publishing exact home/work locations may endanger users.
    - Competitive pressure: existing platforms are feature-rich, so differentiation must be clear.


- External Risks and Dependencies
    - Environmental Risks: 
        - As Hikerz operates in the outdoor space, it is dependent on weather and climate.
    - Economic Risks:
        - In times of economic downturns, spending on outdoor activities may decrease.
    - Partnership Dependencies
        - Hikerz's ability to generate revenue from partnerships with commercial entities such as gear shops, local tourism boards, or map providers is crucial.
    - Regulatory and Privacy Risks
        - The outdoor activity tracking space is sensitive to privacy risks, as users may expose their home or work locations, creating potential security threats
    - Data Protection Regulations
        - The app must comply with data protection laws like GDPR
    - Market Competition and Adoption
        - User adoption is crucial for Hikerz's success. If only a few users decide to switch to the platform, it risks lacking the necessary user engagement and content generation that would make the app valuable.

### Vision articulation and identification of key functionality
- Identification of Key Functionality
    - Log Hikes (Route, Distance, Time, Difficulty)
        - Functionality: Users can log their hiking activities.
        - Scenario: A user completes a hike and wants to track the details—route, distance, time, and how challenging the trail was. This data is logged into their personal account.
    - Explore Friends’ Maps and Discover Popular Trails
        - Functionality: Users can explore their friends' maps, see their completed routes, and discover popular or highly-rated trails shared by others.
        - Scenario: A user looks at their friends' profiles to discover new trails they may want to explore.
    - View Statistics Per Route (e.g., Average Duration/Difficulty for Peaks)
        - Functionality: For each logged hike, users can view detailed statistics like average duration, difficulty, and other relevant metrics.
        - Scenario: A user wants to check how long it typically takes to hike a specific peak in their area.
    - Create/Join Challenges for Motivation
        - Functionality: Users can create or join hiking challenges to stay motivated.
        - Scenario: A user sets up a challenge to climb a specific mountain peak within a month, inviting their friends to join.

- Quality Attributes
    - Performance: The app will be quick.
    - Usability: The app will be easy to use and intuitive.
    - Privacy and Security: Ensuring compliance with privacy regulations.

- Trade-offs
    - Privacy vs. Social Sharing: Offering privacy controls (e.g., private vs. public sharing of routes, photos, and stats) can limit the potential for broader social interaction or exposure.
    - Feature Richness vs. Simplicity: Too many features could risks overwhelming casual users who just want a simple tracking app.
    - Data Storage vs. Performance: Storing photos, route details, and trail statistics requires significant storage space, which may impact device performance

### Creation of Wardley Maps for Hikerz: From Genesis to Commodity
In the context of Hikerz, an app that seeks to differentiate itself from existing platforms like Strava and Komoot, Wardley maps can be a valuable tool in understanding the evolution of the app and plan the strategic direction. Below is an analysis of how the main elements of Hikerz may evolve over time, mapped from Genesis to Commodity.

- Genesis Stage (Innovation Phase)
    - Custom Hiking Features (Privacy Controls, Peak-Focused Gamification):
        - Description: Hikerz introduces new features that existing platforms lack, such as privacy-first controls (for sensitive location data) and gamification tailored for mountaineers. At this stage, the app's market presence is limited, and the features are experimental.
        - Example Components:
            - Privacy-first location tracking (custom solutions for ensuring the security of user data).
            - Peak-focused gamification (unique progression systems for mountaineers).
        - Challenges: Limited user base, experimental features, potential uncertainty around market fit.
    - Offline-first Design:
        - Description: With outdoor connectivity being unstable, Hikerz introduces an offline-first design that allows users to track their hikes even without a network connection. This approach can solve the common outdoor-specific problem, of losing progress due to signal interuptions.
        - Example Component:
            - Offline data logging and syncing.
        - Challenges: The technology is still in the experimental stage, and there is a need for significant development and validation.

- Custom-Built Stage (Early Adoption and Refinement)
    - Basic Activity Tracking:
        - Description: As the app gains initial traction, basic tracking functionalities (logging routes, distances, and times) are being used by early adopters. At this point, the app provides a customized solution to a specific audience of hikers.
        - Example Component:
            - Log hikes: Tracking of trails, difficulty, and hike statistics (distance, time).
        - Challenges: While the app’s functionalities are established, it should still be further customized and it lacks wider adoption.
    - Social Features and Trusted Social Circle:
        - Description: Features like sharing hikes with friends and joining challenges are being developed. The app pushes the idea of sharing stats with your social circle, allowing users to connect and share their achievements with friends.
        - Example Component:
            - Community creation and interaction: Private or small-group sharing. Users can join peak-climbing challenges and compare performance with peers.
        - Challenges: Still an app revolving around a too specific niche, limited social network, but slowly improving user engagement.

- Product Stage (Mature Offering, Standardized Features)
    - Expanded tracking and discovery features:
        - Description: The app matures, offering a more feature-rich platform with trail recommendations, route suggestions, and detailed statistics (average time for peak climbs, heart rate analytics, comparison to previous similar hikes for improvement analysis etc.). This is now a standardized product for a broader user base, beyond early adopters.
        - Example Component:
            - View more complex components per route: Detailed analytics and insights into hiking performance.
        - Challenges: Competition from other fitness and hiking platforms trying to repeat and disrupt the pattern that our app followed intensifies as Hikerz moves closer to mainstream adoption.
    - Monetization and Partnerships:
        - Description: Hikerz begins monetizing through partnerships with gear shops, tourism agencies, and map providers, while still remaining focused on its primary features, its privacy and specialized features for hikers.
        - Example Component:
            - Revenue generation from local businesses (gear partnerships, travelling agencies, performance beverage/food companies etc.).
        - Challenges: The monetization strategy must balance maintaining privacy and user trust. Thus, credible partners with values that align with our stakeholder's values should be considered, and the contrary should be avoided.

- Commodity Stage (Ubiquitous, Standardized Solution)
    - Basic Activity Tracking and Map Access (Standardized):
        - Description: Over time, the basic hiking tracking features become a standard, and any features that once made a difference, are now easily replicated by competitors or available as generic services. Competitive features like basic leaderboards may become expected utilities but less of a differentiator. However, Hikerz may still differentiate itself through its dense network.
        - Example Component:
            - Standardized hiking tracking: Route logging and statistics are now present in most competitors from the same niche.
        - Challenges: High competition and low differentiation.
    - Competitive Features as Standard Utility:
        - Description: As challenge and game systems mature, they may become standardized in the market, with most hiking apps offering similar basic concepts. Hikerz’s competitive edge would then depend on unique designs or approaches to engage stakeholders.
        - Example Component:
            - Leaderboards, achievements, and badges as basic utilities.
        - Challenges: Need for continuous innovation to maintain competitive advantage.

By doing this analysis, the team can take multiple conclusions:
    - Genesis to Custom-Built: Focus on refining gamification and tracking features to attract early adopters.
    - Custom-Built to Product: Expand competitive and social features to appeal to a wider audience.
    - Product to Commodity: Continuously innovate competitive mechanics or personalized challenges to lead a market where basic tracking and gamification become standard.
