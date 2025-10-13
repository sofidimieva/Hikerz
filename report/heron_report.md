## Hikerz: A Social Hiking Network

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

## Architecture Development and Design Decisions


### 1. C4 Model
To effectively communicate and document the system’s architecture, the C4 model was adopted. The C4 model provides a structured and hierarchical way to visualize software architecture at different levels of detail, ensuring clarity and alignment across technical and non-technical stakeholders. It breaks down the system into four key diagram types:
- Context Diagram (C1): Offers a high-level overview of the system and its interactions with external users and systems.
- Container Diagram (C2): Illustrates the main containers (such as web applications, databases, APIs, etc.) that make up the system and how they communicate.
- Component Diagram (C3): Provides a deeper look into each container, detailing the major components, their responsibilities, and interactions.
- Code Diagram (C4): Focuses on the internal structure of specific components, showing classes, modules, and relationships at the code level.
By using C4 diagrams, the architecture of the POC is presented in a way that supports progressive detail, starting from a broad system overview and drilling down into implementation specifics. This approach improves traceability, team communication, and maintainability, aligning with modern software engineering practices.


#### **Context Diagram (C1)**

![C1.jpg](./img/C1.jpg)
The Context diagram shows the Hikers Mobile App and its relationship with the end-users and key external systems, establishing the system's purpose and scope.

The Hikers Mobile App is a system designed to connect individuals (End Users) looking to explore new hiking routes, meet other enthusiasts, and build hiking communities. The application acts as a central hub, interacting with various users and external services to deliver its core features.
- Users and Stakeholders  
  - End Users (People): The primary users who explore routes, view friends' activities, and build communities.
  - Tourist Groups (People/Organization): Groups or individuals who organize hiking trips and provide trip-related data (e.g., transport, accommodation) to the app.
  - Advertisers (Organization): Businesses that pay to promote their locations within the app, providing sponsored location data.

- External Systems
  - Location Service (Software System): Provides essential geographical capabilities, including geolocation, maps, and navigation information to support location-based features.
  - Third Party Map API (Software System): An external API dedicated to providing visual maps for the routes and logged activities.
  - Notification Service (Software System): Handles the delivery of real-time push notifications to user devices.
  - Recommendation Engine (Software System): A collaborative filtering system that provides personalized route suggestions to users.
  - Authentication Service (Software System): Manages user login and identity, supporting secure login methods like third-party sign-in (e.g., Google, Facebook).


---

#### **Container Diagram (C2)**

![C2.jpg](./img/C2.jpg)
  - Core Components
    - Mobile Client (container: iOS/Android app): The user-facing application for exploring routes, viewing friends' activities, and posting new activities. It communicates with the Backend API via RESTful calls.
    - Backend API (container: Java + Spring Boot): The central application handling business logic, user management, events, and recommendations. It orchestrates requests between the Mobile Client, databases, and external services.

  - Data Stores
    - User DB (container: PostgreSQL): Stores user profiles, challenges joined, follower lists, and privacy settings.
    - Activity DB (container: PostgreSQL + PostGIS Extension): Dedicated to storing hiking activities and the required geospatial data (route, media) for each.
    - Challenges DB (container: PostgreSQL): Stores challenge descriptions, deadlines, and completion criteria.


  - External Services (Microservices / Third-Party APIs)
    - Notification Service (container: Firebase/AWS SNS): Sends push notifications to user devices, receiving requests from the Backend API and returning coordinates for map visualizations.
    - Location Service (container: Mapbox API): Provides geolocation, maps, and navigation, used for map visualization and routing by the Mobile Client and Backend API.
    - Recommendation Engine (3rd party / Microservice): Provides personalized route suggestions using collaborative filtering, relying on user data and preferences.
    - Authentication Service (3rd party / Microservice): Manages secure login and identity, requested by the Mobile Client.

#### **Components Diagram (C3)**
The Component diagram details the internal structure of the Backend API, demonstrating a clear Layered Architecture (Controllers, Services, Repositories) and the decomposition into functional components (e.g., User, Activity, Challenge).

![C3.jpg](./img/C3.jpg)

  - Layered Architecture  
    - Controllers Layer (Top): Exposes the API endpoints. Components include UserController, ActivityController, ChallengeController, NotificationController, and RecommendationController.

    - Services Layer (Middle): Contains the core business logic. Components include UserService, ActivityService, ChallengeService, NotificationService, and RecommendationService. These services use Repositories for data access and clients for external communication.

    - Repositories Layer (Bottom Left): Handles persistence logic and database interaction. Components like UserRepository, ActivityRepository, and ChallengeRepository abstract the database technology (PostgreSQL).

    - Utilities Layer (Bottom Right): Contains cross-cutting concerns like DTOs & Mappers (data transformation), ExceptionHandler (error handling), and Logging & Monitoring.

  - External Service Clients (Bottom Center): The Services layer interacts with dedicated clients to access external systems, promoting separation of concerns:
    - AuthClient (Authentication Service - Google/Auth)
    - MapClient (Location Service - Mapbox API)
    - NotificationClient (Notification Service - Firebase/AWS SNS)
    - RecommendationClient (Recommendation Engine API)

#### **Code Diagram (C4 – Activity Service Example)**

The Code diagram provides a detailed view of a specific component, the Activity Service, showing its classes and implementation details. This demonstrates the adopted Domain-Driven Design (DDD) principles and persistence framework (Spring/JPA).

![C4.png](./img/C4.png)


  - Key Classes and Artifacts
    - ActivityController (Methods): Shows the public API methods (e.g., @GetMapping and @PostMapping annotations) like getActivityById, submitActivity, and getAllActivities, which are the entry points for client requests.
    - ActivityService Class (Methods): Implements the business logic (e.g., getActivities, submitActivity, deleteActivity). This layer orchestrates the operation, using the repository and mapping data.
    - ActivityRepository Interface (Methods): A Spring Data JPA repository providing CRUD and query methods (e.g., findByUserId, save), abstracting the database interaction.
    - Entity Fields: Shows the ActivityEntity class, which represents the persistent data model (e.g., private String title, private Point geojson). It uses JPA annotations (e.g., @Entity, @Id) for object-relational mapping.
    - DTOs (Data Transfer Objects): Shows the data structures used for data transfer between the service/controller layer and the client (e.g., ActivityDTO, ActivitySummaryDTO), promoting encapsulation and decoupled data contracts.

  - Technical Dependencies: The diagram also highlights key technical dependencies used for the implementation, such as:
    - JPA Library (Hibernate): For Object-Relational Mapping (ORM).
    - Spring-Boot: The framework provides dependency injection, transaction management, and simplified setup.
    - JTS Geometry Processing: Libraries used for handling and processing geospatial data (the PostGIS Extension support).

---

### 2. Sequence Diagrams

#### 2.1 Scenario A — Create Hike  
#### 2.2 Scenario B — View “My Hikes”  
#### 2.3 Scenario C — View “Friends’ Hikes”  
#### 2.4 Scenario D — Join Challenge  
#### 2.5 Scenario E — Create Challenge  
#### 2.6 Scenario F — View Statistics  

---

### 3. Elaboration of Specific Architectural Decisions and Alternatives

#### 3.1 Tech Stack

#### 3.2 Architecture Styles
- Monolith vs Microservice vs Modular Monolith  
- Separation of Concerns (SoC) Principle
  - Separation of Concerns (SoC) is a software design and engineering discipline aimed at breaking down complex systems into more manageable and understandable components. The core idea is to organize the system in such a way that each part is responsible for a single concern, or a well-defined aspect of functionality, without overlapping concerns.  By implementing SoC, a system’s **modularity**, **maintainability**, and **scalability** are significantly increased.
  - In the **Hikerz** codebase, we adhere to this principle by ensuring clear separation between various parts of the application:
    - **Service**: Houses the functional logic of the system.
    - **Controller**: Serves as the point of entry for incoming requests.
    - To ensure clean architecture and decouple the internal model from the external API representation, the results from retrieving entities from the repository are mapped to a **Data Transfer Object (DTO)**.
    - Example of SoC in the Hikerz codebase.![SOC Example](report/img/SOC.jpg)

#### 3.3 Quality Assurance
-  Unit Tests (Backend Java Unit Tests) - Unit tests verify that individual components of the backend (e.g., services, controllers) work as expected.
   - **Tools**:
     - JUnit
     - Mockito
     - Spring Boot Test

-  CI/CD Pipeline - CI/CD automates the process of integrating code changes, building the app, running tests, and deploying to environments.
   - **Tools**:
     - GitLab CI
     - EAS (Expo Application Services): Used to build the React Native app efficiently.

- Manual Testing  - Manual testing involves human interaction with the application to identify issues that automated tests may miss. This includes usability and edge-case testing.
- Postman API Testing - Postman is used for testing and validating RESTful APIs. It helps ensure the backend API endpoints are functioning correctly, with the right responses and status codes.
- Stress/Load Testing
    - **Tools**: k6
    - **Purpose**: Ensure the system remains stable under high usage and can scale when necessary.

#### 3.4 Paginated vs. Bulk HTTP API Responses
In designing the HTTP API for our microservices, a critical architectural decision was made regarding how to retrieve collections of data: **Paginated Responses** versus **Bulk Fetching** (non-paginated). For the Proof of Concept (POC), we will use the user retrieval endpoint, `/all/{username}`, to assess the performance implications of each approach.

- Comparison of API Design Approaches
  - Paginated Responses (Chosen for Scale) - The paginated approach retrieves data in smaller, manageable chunks called pages, which drastically improves performance and resource management when dealing with large datasets. Our standard configuration fetches 10 objects per page.
    - **Endpoint (POC)**: 
      - `@GetMapping("/all/{username}")` - Fetches users page by page.  
      - **Request Params**:
        - `page` (default 0)
        - `size` (default 10)
        - `q` (optional search query for filtering)  
      - **Response Format**: `PaginatedResponse<UserResponse>`
    - **Key Benefits**:
      - **Improved Performance**: Smaller data payloads lead to significantly faster response times and lower latency.
      - **Resource Efficiency**: Reduced server memory usage, lower database load, and less network bandwidth consumption.
      - **Scalability**: Allows the service to handle large datasets efficiently under load.

  - Bulk Fetching (Non-Paginated) Responses - The bulk fetching approach retrieves the entire collection of data in a single HTTP response.
      - **Endpoint (POC)**:  
        - `@GetMapping("/all/notPaginated/{username}")` - Fetches all users matching the criteria in a single response.  
        - **Request Params**:
          - `q` (optional search query for filtering)  
        - **Response Format**: `List<UserResponse>`
      - **Key Risks**:
        - **Performance Bottleneck**: A single request for a large dataset (1000 users in our test) can monopolize server resources and take a very long time, leading to user-facing timeouts.
        - **Resource Exhaustion**: Increases the risk of high memory and CPU utilization on both the server and the client.

  - **Note on the `q` parameter**: This optional query parameter is intended for user-driven search from the UI. When `q` is null, the endpoint attempts to fetch all users, which is the scenario where the difference between pagination and bulk fetch will be most stark.


- Performance Setup and Load Test Scenarios  
  - Setup
    - To objectively measure the performance difference, we will execute a load test against both endpoints.
    - **Microservice**: Spring Boot user microservice is running.
    - **Dataset**: The service is populated with 1000 users.
    - **Load Tester**: **k6** is an open-source, developer-centric load testing tool for engineering teams. It's written in Go and allows us to script complex performance scenarios using JavaScript. It measures critical metrics like throughput, response time, and error rate under high concurrency.
    - **Visualization**: We will use **Grafana** for real-time visualization, allowing for a direct, graphical comparison of the performance characteristics (latency, throughput, resource usage) of the two endpoints.
  - Load Test Scenario
    - We will use a gradual ramp-up scenario to observe the microservice's behavior as the load intensifies, pushing both endpoints to their limits.
    - The scenario defines the number of concurrent Virtual Users (target) over a specified duration:
    
    | Stage | Duration | Target (Virtual Users) | Cumulative Time | Notes |
    |-------|----------|------------------------|-----------------|-------|
    | 0     | 15s      | 50                     | 0:15            | Initial ramp-up |
    | 1     | 30s      | 50                     | 0:45            | Steady load |
    | 2     | 15s      | 100                    | 1:00            | Increase load |
    | 3     | 30s      | 100                    | 1:30            | Steady load |
    | 4     | 15s      | 200                    | 1:45            | Significant increase |
    | 5     | 30s      | 200                    | 2:15            | Steady load |
    | 6     | 15s      | 400                    | 2:30            | Stress begins |
    | 7     | 30s      | 400                    | 3:00            | Steady stress |
    | 8     | 15s      | 800                    | 3:15            | High stress |
    | 9     | 30s      | 800                    | 3:45            | Steady high stress |
    | 10    | 15s      | 1000                   | 4:00            | Maximum stress |
    | 11    | 30s      | 1000                   | 4:30            | Final maximum load |

  - Anticipated vs Actual Results  
      - Anticipated results - The visualization in Grafana is expected to demonstrate the superior performance of the paginated approach.
    
      | Metric                | Paginated Endpoint   | Bulk Fetch Endpoint   |
      |-----------------------|----------------------|-----------------------|
      | **Latency (p95 Response Time)** | Low and stable across all load stages. | Will spike sharply under medium-to-high load (Stage 4+), leading to potential timeouts. |
      | **Throughput (Requests/s)** | High and sustained, processing many requests per second. | Will drop significantly, limited by the long processing time of each large request. |
      | **Error Rate** | Near 0%. | Will likely show a high percentage of timeouts or server errors at higher loads. |

      - Actual Test Results 
        - As described in [this article](https://odown.com/blog/what-is-a-good-api-response-time/) and shown in the figures below the paginated API response time with concurrent users is still within the expected parameters.
        - In contrast, as illustrated in the figures, the bulk API begins to time out with 1000 concurrent API calls, highlighting the performance drawbacks of the non-paginated approach. Meanwhile, the paginated API continues to process requests efficiently, with its latency response to each request at most 2 seconds, 95% lower than the 60-second timeout the bulk API experiences.
        - The results validate the architectural decision to implement pagination as the standard for data retrieval endpoints that handle potentially large collections, ensuring the microservice remains performant and resilient under high concurrency.
            
          - | Metric                | Paginated                                                                 | Non Paginated                                                               |
            |-----------------------|---------------------------------------------------------------------------|-----------------------------------------------------------------------------|
            | Http Performance      | ![Http Performance Pag](report/img/pag-experiment/pag-http-performance.png)| ![Http Performance Non Pag](report/img/pag-experiment/non-pag-http-performance.png)                      |
            | Http Request Duration | ![Http Request Duration Pag](report/img/pag-experiment/http-req-dur-pag.png)   | ![Http Request Duration Non Pag](report/img/pag-experiment/http-req-dur-non-pag.png) |
            | VU Number             | ![VU Number Pag](report/img/pag-experiment/vu-pag.png)                     | ![VU Number Non Pag](report/img/pag-experiment/vu-non-pag.png)               |


---

### 4. Assessment of impact of Cloud vs On-Premises Deployment

#### 4.1 PostgreSQL Deployment Evaluation

#### 4.2 Mapbox Deployment Evaluation

---

### 5. Critical Selection of Open Source Components
- Spring Boot
  - Spring Boot is an open-source Java web framework that makes creating web apps and microservices easier. It enables programmers to create production-quality, standalone apps with little setup. Spring Boot simplifies setup by embracing an opinionated approach to the Spring platform and incorporating third-party libraries, freeing developers to concentrate on creating application logic rather than configuration. The majority of Spring Boot applications are ready to use right out of the box and require little setup.
- Lombok
  - Project Lombok is a robust Java library that reduces boilerplate code to increase productivity. Because of its smooth integration with your editor and build tools, developers can avoid writing repetitive code like equals, setters, and getters. Lombok can streamline development and improve code maintainability by managing logging variables, automatically generating a fully functional builder, and more with just a few simple annotations.
- PostgreSQL
  - PostgreSQL is a powerful open-source relational database system that is well-known for its extensibility, high standards compliance, and sophisticated features—all without the cost of licensing. Developers looking for a dependable and scalable database solution choose it because of its broad support for data types and strong querying features.  The PostGIS extension is one of PostgreSQL's most notable features for the Hikerz project. The app's map-based features and geospatial analysis depend on the efficient storage, querying, and manipulation of geographic data made possible by this extension's spatial database capabilities.
- k6 
  - k6 is an open-source load testing tool designed for testing the performance of APIs, websites, and microservices under heavy load. It provides detailed insights into performance bottlenecks and system limits.

---

### 6. Event Communication Pattern Decision

For the Hikerz hiking activity tracking application, we evaluated 5 event communication patterns to enable decoupled interaction between our bounded contexts (Hike, User, Challenge, and Photo): 

#### 6.1 Alternatives Considered

- Publish–Subscribe (Redis Pub/Sub)  
- Producer–Consumer (Redis Streams)  
- Event Bus within Modular Monolith  
- Direct HTTP/REST API Calls  
- Shared Database with Polling  

#### 6.2 Comparative Analysis

- Option 1: Publish-Subscribe with Redis Pub/Sub provides true decoupling where publishers emit events (e.g., HikeLogged, PhotoUploaded) to Redis channels without the knowledge of subscribers. This pattern excels at low-latency message delivery and enables asynchronous processing, which is critical when a single hike completion triggers updates across User statistics, Challenge leaderboards, and Photo galleries. Redis's in-memory architecture ensures minimal latency for event propagation - ideal for real-time leaderboard updates during peak hiking hours. However, Redis Pub/Sub operates on a "fire-and-forget" model without message persistence; if a subscriber is temporarily down when HikeLogged is published, that event is lost. This requires implementing event sourcing or storing events in the database before publishing to ensure critical user statistics aren't missed. Additionally, Redis lacks advanced features like message routing, topic patterns require careful channel naming conventions, and debugging event flows requires Redis monitoring tools.

- Option 2: Producer-Consumer Queue (Redis Streams or RabbitMQ) uses a work queue where the Hike context produces events that are consumed by competing workers. Unlike pub/sub's broadcast model, each HikeLogged event is delivered to exactly one consumer from a pool, enabling horizontal scaling of event processing. This pattern excels when we need guaranteed delivery with acknowledgment—if Challenge context fails to update a leaderboard, the message remains in the queue for retry. Redis Streams offers consumer groups, message persistence with configurable retention, and processing acknowledgments while maintaining Redis's operational simplicity. However, the producer-consumer model is fundamentally mismatched to Hikerz's needs: we require multiple independent contexts to react to the same hike event simultaneously (User needs to update statistics, Challenge needs to recalculate rankings, and Photo context needs to process attached images). With a queue, we would need complex message fanout logic or duplicate events to multiple queues—negating the pattern's simplicity advantage. Additionally, competitive consumers create ordering issues when processing related events (e.g., HikeStarted, HikePaused, HikeFinished for the same hike).

- Option 3: Event Bus within Modular Monolith (using Spring's ApplicationEventPublisher) offers similar decoupling benefits within a single deployment unit. When a hiker logs a route, the Hike context publishes a HikeLogged event that User context (for statistics updates) and Challenge context (for leaderboard calculations) consume in-process. This maintains clean boundaries between contexts while avoiding external infrastructure dependencies. Trade-offs include limited scalability - all contexts share compute resources, so high photo upload volumes could impact hike logging performance. Additionally, this pattern locks us into a monolithic deployment model initially, though contexts can be extracted to microservices later if needed. Unlike Redis, this guarantees event delivery within the process but cannot distribute load across multiple service instances.

- Option 4: Direct HTTP/REST API Calls creates tight coupling where the Hike context directly invokes User and Challenge APIs after logging activities. This provides immediate consistency and simplifies debugging through synchronous call traces. However, it violates our domain-driven design principles by creating compile-time and runtime dependencies between contexts. A failure in the Challenge service could prevent hike logging entirely, and adding new event consumers (e.g., a future Analytics context) requires modifying the Hike context's code - contradicting the Open-Closed Principle and making our system brittle as it grows.

- Option 5: Shared Database with Polling involves contexts periodically querying a shared events table for new entries. While simple to implement initially, this pattern introduces several critical problems for Hikerz: polling intervals create unacceptable latency (users expect near-instant profile updates after hike completion), the shared database violates bounded context autonomy and creates coupling through schema dependencies, and high-frequency polling under load (hundreds of concurrent hikers) causes database contention that degrades overall system performance - particularly problematic during peak weekend hiking hours.

| **Criteria**               | **Pub/Sub (Redis)**             | **Producer-Consumer (Redis Streams)** | **Event Bus (Monolith)**       | **Direct HTTP/REST**            | **Shared DB Polling**          |
|-----------------------------|----------------------------------|--------------------------------------|--------------------------------|----------------------------------|--------------------------------|
| **Communication Model**     | One-to-many broadcast           | One-to-one (competing consumers)     | One-to-many in-process          | Synchronous point-to-point       | Pull-based polling             |
| **Decoupling**              | True decoupling                 | True decoupling                      | In-process only                 | Tight coupling                   | Schema coupling                |
| **Message Persistence**     | Fire-and-forget                 | Configurable retention               | Guaranteed in JVM               | No persistence                   | Database stored                |
| **Delivery Guarantee**      | At-most-once                    | At-least-once with ACK               | Within process                  | Depends on retry logic           | Eventually consistent          |
| **Latency**                 | Sub-millisecond                 | Low (ms range)                       | Lowest (in-memory)              | Synchronous blocking             | High (polling intervals)       |
| **Scalability**             | Horizontal subscribers          | Horizontal consumers                 | Monolith constraints            | Limited by sync chains           | Database contention            |
| **Infrastructure Complexity** | Requires Redis               | Requires Redis/RabbitMQ              | None (in-process)               | None (HTTP only)                 | Database only                  |
| **Operational Overhead**    | Medium (Redis cluster)          | Medium-High (broker mgmt)            | Low                             | Low                              | Low                            |
| **Debugging Complexity**    | Requires monitoring tools       | Message tracing needed               | Standard IDE tools              | HTTP tracing                     | Query logs                     |
| **Message Ordering**        | No guarantees                   | Per consumer group                   | In-process order                | Sequential calls                 | Polling order                  |
| **Failure Handling**        | Lost if subscriber down         | Retry with DLQ                       | In-process exception             | Manual retry logic               | Duplicate processing risk      |
| **One-to-Many Support**     | Native broadcast                | Requires fanout/duplication          | Native @EventListener            | Multiple API calls               | Multiple pollers               |
| **Privacy Control**         | Channel-based filtering         | Consumer-side filtering              | Listener filtering               | Caller must know rules           | Query-based filtering          |
| **Offline Burst Handling**  | Async fire-and-forget           | Queue buffering                      | Shared resources                 | Blocking responses               | Polling lag                    |
| **Future Microservices**    | Already distributed             | Already distributed                  | Requires migration               | Service mesh needed              | Requires redesign              |
| **Best Fit for Hikerz**     | **HIGH – Real-time updates**    | **LOW – One-to-one mismatch**        | **MEDIUM – POC only**           | **LOW – Blocks users**           | **LOW – Poor performance**     |



#### 6.3 Selected Pattern: Redis Publish–Subscribe
We selected the Publish-Subscribe pattern with Redis Pub/Sub as our preferred solution for three problem-specific reasons tied to Hikerz's domain:
- Low-latency real-time updates: Hikers expect immediate feedback when logging activities—seeing their statistics update and challenge progress increment within seconds. Redis's in-memory pub/sub delivers sub-millisecond message propagation, ensuring User and Challenge contexts process HikeLogged events nearly instantaneously. This responsiveness is critical for our gamification strategy where users compete on leaderboards during group hikes.
- Simple operational model for POC validation: Unlike RabbitMQ or Kafka which require separate cluster management, Redis is already part of our technology stack for caching user sessions and activity feeds. Leveraging Redis Pub/Sub eliminates additional infrastructure complexity during our proof-of-concept phase, allowing our small team to validate the event-driven architecture without dedicating resources to message broker administration.
- Privacy-driven selective event propagation: Hikers can mark activities as private, requiring complex filtering logic (PrivateHikeCannotBeShared policy). With Redis Pub/Sub, we implement privacy checks once in the Hike context publisher before emitting events to specific channels (e.g., hike.logged.public vs hike.logged.private), whereas polling or direct calls would require duplicate privacy validation in every consumer context, creating security vulnerabilities.

To address Redis Pub/Sub's lack of message persistence, we implement a dual-write pattern: the Hike context persists HikeLogged events to PostgreSQL in an event sourcing table within the same transaction as the activity record, then publishes to Redis. Consumer contexts (User, Challenge, Photo) process events from Redis in real-time but can rebuild their state by replaying events from PostgreSQL on startup or after failures. This hybrid approach provides Redis's sub-millisecond delivery for the 99% case (active subscribers) while ensuring critical achievements and statistics aren't lost if a service restarts during event processing.
While the Event Bus within Modular Monolith (Option 3) offers the simplest starting point with guaranteed delivery and no external dependencies, Redis Pub/Sub positions Hikerz to scale horizontally by running multiple instances of Challenge context subscribers during peak hiking periods, distributing leaderboard calculation load without full service extraction - essential for handling our target scenario of hundreds of mountaineers completing summit challenges simultaneously on popular weekend mornings. The operational overhead of managing Redis is acceptable given we already use it for caching user sessions and activity feed data, making pub/sub a natural extension of existing infrastructure rather than an additional moving part.


---

### 7. Proof of Concept Discussion
- Demonstration of Feasibility  
- Validation of Critical Design Choices  
- Impact Assessment and Metrics  

---

### 8. Completion of Problem Analysis


---

### References

