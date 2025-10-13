## Finch Report – Hikerz: A Social Hiking Network

### Problem Statement and Motivation
We propose a new outdoor hiking app named Hikerz which will record hiking routes on mobile applications. While currenttly similar platforms exist (like Strava or Komot), they only provide a series of features for activity tracking, mainly focused on running, cycling and swimming. Therefore, these platforms present the following three shortcomings:
- limited peak-focused progression and gamification for mountaineers
- lack of strong community features centered around trusted social graphs

Hikerz aspires to serve both casual hikers seeking motivation and dedicated mountaineers striving toward regional peak goals. By addressing these shortcomings, Hikerz could attract a significant number of users from existing platforms like Strava, Komoot, and others.

### Stakeholders and Context (Interest Map)
- Keep Satisfied: 
   - Community Organizers: Clubs or informal groups managing private or public hiking challenges.
   - Local Authorities: Municipal or regional entities interested in promoting local hiking trails and ensuring safety and environmental protection.
- Managed Closely
   - Primary Users: Hikers, mountaineers, and outdoor enthusiasts seeking to record, share, and explore hiking routes.
- Monitor (Minimum effort)
   - Amateur Sports People: Casual hikers or fitness enthusiasts exploring trails occasionally.
   - Fitness App Users: Individuals using other fitness tracking platforms who might expand their activities to include hiking.
- Keep Informed
   - Students: Individuals using the platform for educational purposes, such as geography or outdoor clubs.
   - Local Business Owners: Small businesses near popular trails that might benefit from exposure through the app.

### Context analysis

- Context problems
    - Connectivity in the outdoors is intermittent; offline-first design is required.
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
    - Feature Richness vs. Simplicity: Too many features could risk overwhelming casual users who just want a simple tracking app.
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



## Event Storming Process

Event Storming was used to discover domain events, commands, aggregates, policies, and interactions. It provided a shared understanding of system behavior and guided the identification of bounded contexts.


### Participants

- 2 domain experts (hikers)
- 2 developers
- 1 product owner


### Duration

- 1 hour 30 min


### Materials

Large wall or virtual board with **color-coded sticky notes**:

- Orange: Domain Events (`HikeLogged`, `PhotoUploaded`)
- Blue: Commands (`StartHike`, `JoinChallenge`)
- Green: Aggregates/Actors (`HikeAggregate`, `UserAggregate`)
- Purple: Policies/Rules (`PrivateHikeCannotBeShared`)
- Yellow: External Systems (cloud storage, social media APIs)


### Steps

1. Big Picture Timeline
    - Map all domain events chronologically to visualize the flow from hike start to challenge completion.

2. Identify Commands, Aggregates, and Policies
    - Link commands to the events they trigger.
    - Identify responsible aggregates for each event.
    - Clarify business rules and invariants.

3. Mark Hot Spots
    - Highlight ambiguous or high-risk areas, such as privacy rules, cross-context workflows, or scaling challenges.

4. Define Candidate Bounded Contexts
    - Propose initial boundaries based on clusters of related events and aggregates.

5. Validate Domain Events and Relationships
    - Domain experts review events, commands, aggregates, and policies to ensure completeness and correctness.


### Event-to-Aggregate Mapping

| Domain Event               | Triggering Command      | Responsible Aggregate | Notes / Policies                   |
|-----------------------------|------------------------|--------------------|-----------------------------------|
| `HikeStarted`               | `StartHike`            | HikeAggregate      | Start time recorded                |
| `HikePaused`                | `PauseHike`            | HikeAggregate      | Intermediate pause state           |
| `HikeFinished`              | `FinishHike`           | HikeAggregate      | End time recorded                  |
| `HikeLogged`                | `LogHike`              | HikeAggregate      | Visibility depends on privacy      |
| `PhotoUploaded`             | `UploadPhoto`          | PhotoAggregate     | Links to hike and user             |
| `FriendAdded`               | `AddFriend`            | UserAggregate      | Updates friendship invariants      |
| `FriendRemoved`             | `RemoveFriend`         | UserAggregate      | Updates friendship invariants      |
| `FriendMapViewed`           | `ViewFriendMap`        | UserAggregate      | Privacy rules enforced             |
| `ChallengeCreated`          | `CreateChallenge`      | ChallengeAggregate | Rules for scoring established      |
| `ChallengeJoined`           | `JoinChallenge`        | ChallengeAggregate | Participant added                  |
| `ChallengeProgressUpdated`  | `UpdateChallenge`      | ChallengeAggregate | Updates leaderboards               |
| `BadgeAwarded`              | `AwardBadge`           | UserAggregate      | Achievement recognition            |


### Outputs from Event Storming 

Domain modeling structured the results from Event Storming into entities, value objects, aggregates, and repositories, clarifying transactional boundaries, data ownership, and relationships.

#### Aggregates

- **HikeAggregate**: Represents a hike, including route, duration, difficulty, and privacy. Ensures private hikes do not affect public projections.  
  **Operations**: start, pause, finish, log.

- **UserAggregate**: Represents a user profile, friends list, personal hikes, and statistics. Maintains privacy and friendship invariants.

- **ChallengeAggregate**: Manages challenge rules, participants, and progress tracking. Coordinates challenge updates while enforcing scoring rules.

- **PhotoAggregate**: Handles photos uploaded during hikes, including metadata (timestamp, caption, storage URI) and links to hikes and users.


#### Entities

- **Hike** (`id`, `owner`, `start_time`, `end_time`, `route`, `duration`, `difficulty`, `privacy`)  
  Represents a hike. Belongs to `HikeAggregate`.

- **User** (`id`, `username`, `email`, `friends`, `personal_hikes`, `statistics`)  
  Represents a user profile. Belongs to `UserAggregate`.

- **Challenge** (`id`, `title`, `description`, `rules`, `participants`, `progress`)  
  Represents a challenge. Belongs to `ChallengeAggregate`.

- **Photo** (`id`, `hike_id`, `user_id`, `timestamp`, `caption`, `storage_uri`)  
  Represents a photo uploaded during a hike. Belongs to `PhotoAggregate`.

- **Badge** (`id`, `name`, `criteria`, `awarded_to`)  
  Represents an achievement awarded to users.

#### Value Objects

- **GPXTrack** (`coordinates`, `elevation_profile`)  
  Represents the GPS track of a hike.

- **Coordinate** (`latitude`, `longitude`)  
  Represents a geographic point.

- **ElevationProfile** (`points`)  
  Represents elevation data along a hike.

- **PhotoMetadata** (`timestamp`, `caption`, `storage_uri`)  
  Metadata associated with a photo.

- **ChallengeProgress** (`user_id`, `progress_value`)  
  Tracks a user’s progress in a challenge.

### Candidate Bounded Contexts

Bounded contexts group related domain logic, defining **data ownership, invariants, and communication with other contexts**.

#### Contexts

- **Hike Context**  
  Core domain for logging and tracking hikes. Owns `HikeAggregate`.  
  **Events**: `HikeStarted`, `HikePaused`, `HikeFinished`, `HikeLogged`.

- **User Context**  
  Manages user profiles, friendships, and privacy. Owns `UserAggregate`.  
  Reacts to events like `FriendAdded`, `FriendMapViewed`, `HikeLogged`.

- **Challenge Context**  
  Handles creation, participation, and progress of challenges. Owns `ChallengeAggregate`.  
  Updates leaderboards based on `HikeLogged` and `FriendAdded` events.

- **Photo Context**  
  Manages photo storage, retrieval, and metadata. Owns `PhotoAggregate`.  
  Publishes `PhotoUploaded` events to Hike and User contexts.

#### Relationships Between Contexts

- **Event-Driven Integration**: Contexts communicate asynchronously via domain events.
- **Consistency Boundaries**: Aggregates enforce local invariants; cross-context updates rely on eventual consistency.

### Context Relationships Diagram

![relationships.png](./img/relationships.png)

Summary:
- The diagram represents event-driven, cross-context communication.
- Hike and Photo events update User and Hike data.
- User actions update internal aggregates and the Challenge Context.
- All relationships follow event publishing and consuming, ensuring eventual consistency while keeping contexts decoupled.

### Cross-Context Dependencies

#### 1. Hike Context → User Context (`HikeLogged`)
- Description: When a hike is logged in the Hike Context, the User Context needs to be updated.  
- Purpose:
  - Updates the user's statistics (total distance, duration, completed hikes).  
  - Ensures that user profiles reflect the latest activities.  
- Mechanism: Event-driven; `HikeLogged` is published by `HikeAggregate` and consumed by `UserAggregate`.

#### 2. Hike Context → Photo Context (`PhotoUploaded`)
- Description: Hike-related photos are uploaded and handled by the Photo Context.  
- Purpose:
  - Centralizes photo storage and metadata.  
  - Links photos to the appropriate hikes.  
- Mechanism: Hike operations trigger `PhotoUploaded` events, sent to the Photo Context.

#### 3. Photo Context → Hike Context (`PhotoUploaded`)
- Description: After a photo is uploaded, the Hike Context may need to update hike metadata or maps.  
- Purpose:
  - Updates hike timelines or maps with new photos.  
  - Links photo references back to the correct hike.  
- Mechanism: Photo Context publishes `PhotoUploaded` events, consumed by HikeContext aggregates.

#### 4. Photo Context → User Context (`PhotoUploaded`)
- Description: Photo uploads also affect user data.  
- Purpose:
  - Tracks user contributions, galleries, or photo history.  
  - May trigger achievements or badges related to photo sharing.  
- Mechanism: Event-driven; User Context consumes `PhotoUploaded` events.

#### 5. User Context → User Context (`FriendAdded`, `FriendRemoved`, `FriendMapViewed`)
- Description: User-to-user interactions primarily affect the same context.  
- Purpose: 
  - Maintains friendship relationships, privacy rules, and view permissions.  
  - Ensures user activity updates the appropriate aggregates internally.  
- Mechanism: Internal events/commands update `UserAggregate`.

#### 6. User Context → Challenge Context (`ChallengeJoined`, `ChallengeCompleted`)
- Description: User actions related to challenges are communicated to the Challenge Context.  
- Purpose: 
  - Tracks challenge participants (`ChallengeJoined`).  
  - Updates progress, leaderboards, and awards on completion (`ChallengeCompleted`).  
- Mechanism: User Context publishes events consumed by `ChallengeAggregate` to update challenge data.

## Pricing Models and Architectural Implications

In today’s competitive marketplace, the choice of a pricing model significantly impacts not only the revenue strategy but also the underlying architecture of the systems that support it. A pricing model dictates how companies charge for their products or services, and the architecture must align with these strategies to ensure seamless operations and scalability. This section explores the relationship between pricing models and architectural decisions, highlighting the importance of aligning both for robust business solutions.

### Types of Pricing Models

#### 1. Subscription-Based Pricing
Subscription-based pricing, often used in SaaS (Software as a Service), charges customers a recurring fee (monthly or annually) for access to a product or service. It’s a popular choice for services that offer continuous value, as it provides predictable revenue streams.

**Architectural Implications:**
- **Scalability:** The system must handle varying levels of usage as customers are onboarded and retained.
- **Payment Integration:** Seamless integration with recurring payment systems is essential.
- **User Management:** The architecture must support complex subscription tiers, renewals, and cancellations.

#### 2. Pay-Per-Use Pricing
Pay-per-use models charge customers based on their actual usage, common in cloud services and utilities. This model allows businesses to charge according to consumption, making it a flexible option for both customers and providers.

**Architectural Implications:**
- **Real-Time Monitoring:** The system needs to track usage metrics in real-time to ensure accurate billing.
- **Elastic Infrastructure:** The architecture should support scalable resources to meet fluctuating demands.
- **Data Storage:** Efficient storage and retrieval of usage data are critical for accurate billing and reporting.

#### 3. Freemium Pricing
The freemium model offers basic features for free and charges for advanced functionalities. It’s used to attract a large user base with the intent to convert free users into paying customers.

**Architectural Implications:**
- **Feature Segmentation:** The system must have clear feature segmentation to separate free from premium offerings.
- **Analytics:** Collect user behavior data to optimize the freemium-to-paid conversion flow.
- **Payment Systems:** A smooth transition from free to paid accounts is necessary, requiring integration with payment systems.

#### 4. Tiered Pricing
Tiered pricing allows customers to choose from different pricing packages based on the level of service or functionality they need. Each tier provides more advanced features, catering to different customer segments.

**Architectural Implications:**
- **Modular Design:** The system must be modular to easily enable or disable features based on the customer’s tier.
- **Customer Segmentation:** Customer profiles must differentiate based on their selected pricing tier.
- **Complex Pricing Logic:** The system must be capable of calculating different pricing based on the user’s selected tier.

---

### Architectural Considerations Based on Pricing Models

#### 1. Flexibility and Adaptability
The architecture must support flexibility to adapt to changing pricing models. Businesses may need to pivot to a new pricing strategy as they grow, so the system should be modular and easy to adjust without a complete overhaul.

#### 2. Data Security and Compliance
For pricing models involving recurring payments or personal data, security is crucial. The architecture must integrate robust encryption, secure payment gateways, and comply with regulations like GDPR or PCI-DSS to protect customer data.

#### 3. Performance and Scalability
Different pricing models experience varying traffic demands. A subscription model may face predictable usage spikes, while pay-per-use models might have more irregular traffic patterns. The architecture should scale horizontally, using cloud-based solutions to ensure consistent performance during high demand.

#### 4. Analytics and Reporting
To optimize pricing strategies, businesses need to track metrics like customer lifetime value (CLV), conversion rates, and churn. The system must incorporate robust data analytics and reporting tools to provide insights into user behavior, enabling businesses to fine-tune their pricing models and improve revenue generation.

#### 5. User Experience (UX)
The user experience should align with the chosen pricing model. For instance, a pay-per-use model needs transparent billing and usage tracking, while subscription-based models must provide users with an easy way to manage their subscriptions. A seamless user experience ensures customer retention and reduces friction, particularly when transitioning between different pricing tiers or subscription plans.

---

### Conclusion

The choice of pricing model directly affects the design and scalability of the system architecture. Whether adopting subscription-based, pay-per-use, freemium, or tiered pricing, the system must be designed to accommodate the specific requirements of each model. Scalability, flexibility, security, and user experience are all key architectural considerations that must align with the pricing strategy to ensure a seamless and efficient business solution. By understanding the architectural implications of each pricing model, businesses can create solutions that not only support growth but also enhance user satisfaction and operational efficiency.

## Heron Report – Architecture Development and Design Decisions

### 1. Description of Architecture Addressing Problem Statement

#### 1.1 System Context: Hikers Mobile App
- Overview of the system’s purpose and scope  
- Users and Stakeholders  
- External Systems

---

### 2. Adoption of Selected Architectural Development Techniques

#### 2.1 Proof of Concept (POC) Validation  
#### 2.2 C4 Model for Visual Abstraction  
- **Container Diagram (C2)**
  - Core Components
  - Data Stores
  - External Services (Microservices / Third-Party APIs)
- **Component Diagram (C3 – Backend API Decomposition)**
  - Layered Architecture  
    - Controllers Layer  
    - Services Layer  
    - Repositories Layer  
    - Utilities Layer  
  - External Service Clients
- **Code Diagram (C4 – Activity Service Example)**
  - Key Classes and Artifacts
  - Technical Dependencies

---

### 3. Sequence Diagrams

#### 3.1 Scenario A — Create Hike  
#### 3.2 Scenario B — View “My Hikes”  
#### 3.3 Scenario C — View “Friends’ Hikes”  
#### 3.4 Scenario D — Join Challenge  
#### 3.5 Scenario E — Create Challenge  
#### 3.6 Scenario F — View Statistics  

---

### 4. Elaboration of Specific Architectural Decisions and Alternatives

#### 4.1 Tech Stack

#### 4.2 Architecture Styles
- Monolith vs Microservice vs Modular Monolith  
- Separation of Concerns (SoC) Principle  

#### 4.3 Quality Assurance
- Unit Testing  
- CI/CD Pipeline  
- Manual Testing  
- Postman API Testing  
- Stress and Load Testing  

#### 4.4 Paginated vs. Bulk HTTP API Responses
- Comparison of API Design Approaches  
- Performance Setup and Load Test Scenarios  
- Anticipated vs Actual Results  

---

### 5. Assessment of impact of Cloud vs On-Premises Deployment

#### 5.1 PostgreSQL Deployment Evaluation

#### 5.2 Mapbox Deployment Evaluation

---

### 6. Critical Selection of Open Source Components
- Spring Boot  
- Lombok  
- PostgreSQL + PostGIS  
- k6 (Load Testing Framework)  

---

### 7. Event Communication Pattern Decision

#### 7.1 Alternatives Considered
- Publish–Subscribe (Redis Pub/Sub)  
- Producer–Consumer (Redis Streams)  
- Event Bus within Modular Monolith  
- Direct HTTP/REST API Calls  
- Shared Database with Polling  

#### 7.2 Comparative Analysis  

#### 7.3 Selected Pattern: Redis Publish–Subscribe

---

### 8. Proof of Concept Discussion
- Demonstration of Feasibility  
- Validation of Critical Design Choices  
- Impact Assessment and Metrics  

---

### 9. Completion of Problem Analysis


---

### References

