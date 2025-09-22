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