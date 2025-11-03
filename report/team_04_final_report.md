Hikerz: A Social Hiking Network

Team 4:
Polly Dimieva
Sofia Dimieva
Filip-Andrei Cirtog
Bogdan-Luca Paramon

### Table of Contents

- [1. Problem Statement and Motivation](#1-problem-statement-and-motivation)
- [2 Problem analysis](#2-problem-analysis)
  - [2.1. Stakeholders and Context (Interest Map)](#21-stakeholders-and-context-interest-map)
  - [2.2. Context analysis](#22-context-analysis)
    - [2.2.1 Context problems](#221-context-problems)
    - [2.2.2 External Risks and Dependencies](#222-external-risks-and-dependencies)
  - [2.3. Vision articulation and identification of key functionality](#23-vision-articulation-and-identification-of-key-functionality)
    - [2.3.1. Identification of Key Functionality](#231-identification-of-key-functionality)
    - [2.3.2. Quality Attributes](#232-quality-attributes)
    - [2.3.3. Trade-offs](#233-trade-offs)
  - [2.4. Creation of Wardley Maps for Hikerz: From Genesis to Commodity](#24-creation-of-wardley-maps-for-hikerz-from-genesis-to-commodity)
    - [2.4.1. Introduction to Wardley Maps](#241-introduction-to-wardley-maps)
    - [2.4.2. Wardley Maps Analysis](#242-wardley-maps-analysis)
- [3. Event Storming Process](#3-event-storming-process)
  - [3.1. Participants](#31-participants)
  - [3.2. Duration](#32-duration)
  - [3.3. Materials](#33-materials)
  - [3.4. Steps](#34-steps)
  - [3.5. Event-to-Aggregate Mapping](#35-event-to-aggregate-mapping)
  - [3.6. Outputs from Event Storming](#36-outputs-from-event-storming)
    - [3.6.1. Aggregates](#361-aggregates)
    - [3.6.2. Entities](#362-entities)
    - [3.6.3. Value Objects](#363-value-objects)
  - [3.7. Candidate Bounded Contexts](#37-candidate-bounded-contexts)
    - [3.7.1. Contexts](#371-contexts)
    - [3.7.2. Relationships Between Contexts](#372-relationships-between-contexts)
  - [3.8. Context Relationships Diagram](#38-context-relationships-diagram)
  - [3.9. Cross-Context Dependencies](#39-cross-context-dependencies)
- [4. Pricing Models and Architectural Implications](#4-pricing-models-and-architectural-implications)
  - [4.1 Types of Pricing Models](#41-types-of-pricing-models)
    - [4.1.1 Subscription-Based Pricing](#411-subscription-based-pricing)
    - [4.1.2. Pay-Per-Use Pricing](#412-pay-per-use-pricing)
    - [4.1.3. Freemium Pricing](#413-freemium-pricing)
    - [4.1.4. Tiered Pricing](#414-tiered-pricing)
  - [4.2. Architectural Considerations Based on Pricing Models](#42-architectural-considerations-based-on-pricing-models)
    - [4.2.1. Flexibility and Adaptability](#421-flexibility-and-adaptability)
    - [4.2.2. Data Security and Compliance](#422-data-security-and-compliance)
    - [4.2.3. Performance and Scalability](#423-performance-and-scalability)
    - [4.2.4. Analytics and Reporting](#424-analytics-and-reporting)
    - [4.2.5. User Experience (UX)](#425-user-experience-ux)
  - [4.3. Conclusion](#43-conclusion)
- [5. Architecture Development and Design Decisions](#5-architecture-development-and-design-decisions)
  - [5.1. C4 Model](#51-c4-model)
    - [5.1.1. Context Diagram (C1)](#511-context-diagram-c1)
    - [5.1.2 Container Diagram (C2)](#512-container-diagram-c2)
    - [5.1.3. Components Diagram (C3)](#513-components-diagram-c3)
    - [5.1.4 Code Diagram (C4 – Activity Service Example)](#514-code-diagram-c4--activity-service-example)
  - [5.2. Sequence Diagrams](#52-sequence-diagrams)
    - [2.1 Scenario A — Create Hike](#21-scenario-a--create-hike)
    - [5.2.2. Scenario C — View “Friends’ Hikes”](#522-scenario-c--view-friends-hikes)
    - [5.2.3. Scenario D — Join Challenge](#523-scenario-d--join-challenge)
    - [5.2.4. Scenario E — Create Challenge](#524-scenario-e--create-challenge)
    - [5.2.5 Scenario F — View Statistics](#525-scenario-f--view-statistics)
  - [5.3 Proof-of-Concept Validation](#53-proof-of-concept-validation)
- [6. Elaboration of Specific Architectural Decisions and Alternatives](#6-elaboration-of-specific-architectural-decisions-and-alternatives)
    - [6.1 Tech Stack](#61-tech-stack)
    - [6.2 Architecture Styles](#62-architecture-styles)
    - [6.3  Separation of Concerns (SoC) Principle](#63--separation-of-concerns-soc-principle)
    - [6.4 Quality Assurance](#64-quality-assurance)
    - [6.5 Paginated vs. Bulk HTTP API Responses](#65-paginated-vs-bulk-http-api-responses)
- [7. Assessment of impact of Cloud vs On-Premises Deployment](#7-assessment-of-impact-of-cloud-vs-on-premises-deployment)
    - [7.1 PostgreSQL](#71-postgresql)
    - [7.2 Mapbox](#72-mapbox)
      - [7.2.1 Introduction:](#721-introduction)
      - [7.2.2 Table for Comparison](#722-table-for-comparison)
      - [7.2.3 Motivation:](#723-motivation)
      - [7.2.4 Cloud vs On Premises:](#724-cloud-vs-on-premises)
- [8. Critical Selection of Open Source Components](#8-critical-selection-of-open-source-components)
- [9. Event Communication Pattern](#9-event-communication-pattern)
  - [9.1 Alternatives Considered](#91-alternatives-considered)
  - [9.2 Comparative Analysis](#92-comparative-analysis)
  - [9.3 Selected Pattern: Redis Publish–Subscribe](#93-selected-pattern-redis-publishsubscribe)
- [10. Proof of concept](#10-proof-of-concept)
  - [10.1 Structure](#101-structure)
  - [10.2. Experiments](#102-experiments)
  - [10.3 Results](#103-results)
- [11. Use of Artificial Intelligence](#11-use-of-artificial-intelligence)
- [References](#references)


## 1. Problem Statement and Motivation

---
## 2 Problem analysis

### 2.1. Stakeholders and Context (Interest Map)


### 2.2. Context analysis

#### 2.2.1 Context problems

#### 2.2.2 External Risks and Dependencies

### 2.3. Vision articulation and identification of key functionality

#### 2.3.1. Identification of Key Functionality


#### 2.3.2. Quality Attributes

#### 2.3.3. Trade-offs

### 2.4. Creation of Wardley Maps for Hikerz: From Genesis to Commodity

#### 2.4.1 Introduction to Wardley Maps

In the context of Hikerz, an app that seeks to differentiate itself from existing platforms like Strava and Komoot, Wardley maps can be a valuable tool in understanding the evolution of the app and plan the strategic direction. Below is an analysis of how the main elements of Hikerz may evolve over time, mapped from Genesis to Commodity.

#### 2.4.2 Wardley Maps Analysis

In the *genesis stage* Hikerz introduces new features that existing platforms lack, such as:

**Privacy-first controls** (for sensitive location data) and gamification tailored for mountaineers. At this stage, the app's market presence is limited, and the features are experimental. Some example components can be: **privacy-first location tracking** (custom solutions for ensuring the security of user data), **peak-focused gamification** (unique progression systems for mountaineers). Challenges of this stage are (having a) limited user base, experimental features, potential uncertainty around market fit.

**Offline-first design** takes in consideration that outdoor connectivity is unstable, Hikerz introduces an offline-first design that allows users to track their hikes even without a network connection. This approach can solve the common outdoor-specific problem, of losing progress due to signal interuptions. An example of a use case is **offline data logging and syncing**. As far as challenges go, the technology is still in the experimental stage, and there is a need for significant development and validation.

In the *custom-built stage* as the app gains some traction new features start appearing:

**Basic activity tracking** functionalities (logging routes, distances, and times) are being used by early adopters. At this point, the app provides a customized solution to a specific audience of hikers. A component can be for example **logging hikes** tracking of trails, difficulty, and hike statistics (distance, time). As a potential challenge while the app’s functionalities are established, it should still be further customized and it lacks wider adoption.

**Social features and a trusted social circle** implies that features like sharing hikes with friends and joining challenges are being developed. The app pushes the idea of sharing stats with your social circle, allowing users to connect and share their achievements with friends. For example a component could be **community creation and interaction** where private or small groups can share activities. Users can join peak-climbing challenges and compare performance with peers. Still an app revolving around a too specific niche, limited social network, but slowly improving user engagement.

In the *product stage* the app starts having standardized features like the following:

**Expanded tracking and discovery features** offering a more feature-rich platform with trail recommendations, route suggestions, and detailed statistics (average time for peak climbs, heart rate analytics, comparison to previous similar hikes for improvement analysis etc.). This is now a standardized product for a broader user base, beyond early adopters. It is to be expected that users **view more complex components per route**, detailed analytics and insights into hiking performance. However, competition from other fitness and hiking platforms trying to repeat and disrupt the pattern that our app followed intensifies as Hikerz moves closer to mainstream adoption.

**Monetization and partnerships** through deals with gear shops, tourism agencies, and map providers, while still remaining focused on its primary features, its privacy and specialized features for hikers. A component like **revenue generation from local businesses** (gear partnerships, travelling agencies, performance beverage/food companies etc.) will appear in this stage. Something that could be challenging is the fact that the monetization strategy must balance maintaining privacy and user trust. Credible partners with values that align with our stakeholder's values should be considered, and the contrary should be avoided.

In the *commodity stage*, the stage where the basic features become a standard and are expected, the app needs to stay competitive while mantaining the essential features:

**Basic activity tracking and map access**, which over time like any features that once made a difference, are now easily replicated by competitors or available as generic services. Competitive features like basic leaderboards may become expected utilities but less of a differentiator. However, Hikerz may still differentiate itself through its dense network. The component in this case would be **standardized hiking tracking** which does route logging and statistics, which are now present in most competitors from the same niche. This implies huge challenges since there is high competition and low differentiation.

By doing this analysis, the team can take multiple conclusions: - Genesis to Custom-Built: Focus on refining gamification and tracking features to attract early adopters. - Custom-Built to Product: Expand competitive and social features to appeal to a wider audience. - Product to Commodity: Continuously innovate competitive mechanics or personalized challenges to lead a market where basic tracking and gamification become standard.

---
## 3. Event Storming Process

### 3.1. Participants

### 3.2. Duration

### 3.3. Materials

### 3.4. Steps

### 3.5. Event-to-Aggregate Mapping

### 3.6. Outputs from Event Storming

#### 3.6.1. Aggregates

#### 3.6.2. Entities

#### 3.6.3. Value Objects

### 3.7. Candidate Bounded Contexts

#### 3.7.1. Contexts

#### 3.7.2. Relationships Between Contexts

### 3.8. Context Relationships Diagram

### 3.9. Cross-Context Dependencies

---
## 4. Pricing Models and Architectural Implications

### 4.1 Types of Pricing Models

#### 4.1.1 Subscription-Based Pricing

#### 4.1.2. Pay-Per-Use Pricing

#### 4.1.3. Freemium Pricing

#### 4.1.4. Tiered Pricing

### 4.2. Architectural Considerations Based on Pricing Models

#### 4.2.1. Flexibility and Adaptability

#### 4.2.2. Data Security and Compliance

#### 4.2.3. Performance and Scalability

#### 4.2.4. Analytics and Reporting

#### 4.2.5. User Experience (UX)

### 4.3. Conclusion

---
## 5. Architecture Development and Design Decisions

### 5.1. C4 Model

#### 5.1.1. Context Diagram (C1)

#### 5.1.2 Container Diagram (C2)

#### 5.1.3. Components Diagram (C3)

#### 5.1.4 Code Diagram (C4 – Activity Service Example)

### 5.2. Sequence Diagrams

#### 2.1 Scenario A — Create Hike  

#### 5.2.2. Scenario C — View “Friends’ Hikes” 

#### 5.2.3. Scenario D — Join Challenge  

#### 5.2.4. Scenario E — Create Challenge

#### 5.2.5 Scenario F — View Statistics  

### 5.3 Proof-of-Concept Validation

---
## 6. Elaboration of Specific Architectural Decisions and Alternatives

#### 6.1 Tech Stack

#### 6.2 Architecture Styles  

#### 6.3  Separation of Concerns (SoC) Principle

#### 6.4 Quality Assurance

#### 6.5 Paginated vs. Bulk HTTP API Responses

---
## 7. Assessment of impact of Cloud vs On-Premises Deployment

#### 7.1 PostgreSQL

#### 7.2 Mapbox

##### 7.2.1 Introduction:

Mapbox is a platform for custom mapping and location-based services. It offers tools for developers to create interactive maps, visualizations, and other geolocation services. It provides APIs and SDKs for mapping, navigation, and location tracking, and enables developers to design custom map styles, generate routes, and analyze geospatial data. In the following section, Mapbox will be compared with other popular mapping providers. This will be done rigorously by considering the following criteria: Data, Trail Visualization, Styling, Ecosystem, Cost, Offline Support, and Popularity. All of these criteria will be evaluated with the needs of our application in mind.

##### 7.2.2 Table for Comparison

| **Criteria**            | **Mapbox**                                 | **Google Maps**                         | **Leaflet**                                   | **ESRI**                             |
| ----------------------- | ------------------------------------------ | --------------------------------------- | --------------------------------------------- | ------------------------------------ |
| **Data**                | OSM-based, customizable                    | Proprietary, huge coverage              | Depends on source (OSM, tileservers)          | Proprietary, extremely detailed      |
| **Trail Visualization** | Customizable lines, heatmaps, 3D terrain   | Limited styling; strong default terrain | Polylines, heatmaps via plugins; no native 3D | Full GIS analysis, terrain, contours |
| **Styling**             | Full vector tile styling, interactive      | Minimal custom styling                  | Custom styling possible but less smooth       | Very advanced but enterprise-focused |
| **Ecosystem**           | SDKs for web, iOS, Android; good docs      | Great mobile SDKs, strong geocoding     | Lightweight JS; plugins vary in quality       | Enterprise SDKs; heavy               |
| **Cost**                | Usage-based pricing; free tier for dev     | Expensive at scale                      | Expensive at scale                            | Expensive licenses                   |
| **Offline Support**     | Yes (with Mapbox SDKs)                     | Limited                                 | Requires custom setup                         | Yes (ArcGIS packages)                |
| **Popularity**          | Used by Strava, Komoot, AllTrails → proven | Less common in sports apps              | Used in smaller projects                      | Used in gov/enterprise apps          |

##### 7.2.3 Motivation:

Analyzing those key aspects clearly outlines the most suitable option for the project as being Mapbox. Every aspect meets the criteria required for the application. In terms of data, Google Maps seemed like the obvious choice due to its extensive coverage; however, after further research, we found that the difference in coverage mainly refers to cities and rural areas. If the matter is isolated to the concerns of our application, trails are finite and somewhat already defined by paths, unlike extensive unexplored surfaces like rural areas or entire cities. This motivated us to opt for an OSM-based solution. It is to our advantage to use the OpenStreetMap service, which is open source and allows hikers to contribute, thus increasing the coverage of trails. Proprietary sources, such as Google Maps, do not allow external users to enrich their dataset.

Trail visualization and styling put Mapbox on top again, as the service offers a wide variety of features (as mentioned in the table), while other services have limited usage, do not offer native solutions, or imply enterprise-focused rather advanced features. In terms of costs, there are several free options to choose from, so it is not considered a category of distinction. However, Mapbox has the advantage of predictable pricing at scale, since it is user-based, which implies that costs would be a concern once the application scales and gains traction. This is a positive since usage and costs will be directly proportional, meaning revenue will also be directly proportional. Some of the other options are pricier or scale in price more aggressively.

Offline support is one feature the final state of the application should support, and since only Mapbox and ESRI provide offline access without limitation or custom setups, Mapbox remains the preferred service in this category as well. Popularity is a less relevant factor in decision making but can still be used as a differentiator and insight into the competitors' approach. Other big names in the industry back up our choice as giants like Strava and Komoot use Mapbox’s services.

##### 7.2.4 Cloud vs On Premises:

Mapbox offers both cloud and on-premises deployment options. Advantages of choosing the cloud option are scalability, ease of use, global reach, automatic updates, security, etc., as most of the processing is handled by Mapbox’s infrastructure. This comes with disadvantages, such as less private data management, dependency on Mapbox’s infrastructure being up and running, and cost implications. The on-premises approach solves some of those issues, such as data privacy (all the data is processed locally) or dependency on Mapbox’s infrastructure. However, it comes with its own disadvantages. Opting for on-premises requires significant initial investments in infrastructure, brings considerable overhead to deployment times and maintenance, and limits scalability (scaling on-premises solutions involves manual intervention and physical infrastructure upgrades, which can be slow and expensive).

For Hikerz, the cloud-based approach minimizes infrastructure maintenance and provides cost-effective scaling, which is crucial for applications with varying traffic demands. That is why we opted for cloud, while still aware of the trade-offs previously mentioned.


---
## 8. Critical Selection of Open Source Components

---
## 9. Event Communication Pattern

### 9.1 Alternatives Considered

### 9.2 Comparative Analysis

### 9.3 Selected Pattern: Redis Publish–Subscribe

---
## 10. Proof of concept

### 10.1 Structure 

### 10.2. Experiments

### 10.3 Results

---
## 11. Use of Artificial Intelligence

The team made use of LLMs (large language models) like ChatGPT mainly for wording, spelling corrections, rephrashing and improving clarity of concepts. Wherever the team considered an idea to be unclearly phrased AI was used to enhance the original thought process. We want to emphasize that AI was not a substitute to our own thought process, research or decision making, but rather used as an enhancer to delve deeper into topics and gain broader knowledge through suggested resources, that were at no point considered without the beforehand analysis of a member, who took responsibility to summarize the content to the rest of the team and filter it accordingly with their own thought process and background knowledge. Furthermore, Copilot was used in code completion at times to facilitate writing tests.

---
## References
