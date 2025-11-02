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
    - [6.5 RESTful HTTP APIs Response](#65-restful-http-apis-response)
      - [6.5.1. Context](#651-context)
      - [6.5.2. Chosen API Design Approach and Alternatives](#652-chosen-api-design-approach-and-alternatives)
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
  - [10.2. Experiment](#102-experiment)
    - [10.2.1. Performance Setup and Load Test Scenarios](#1021-performance-setup-and-load-test-scenarios)
    - [10.2.2. Metrics Considered](#1022-metrics-considered)
    - [10.2.3. Expected results](#1023-expected-results)
  - [10.3 Results](#103-results)
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
In the following sections, we make some important decisions involving the architectural design of the app. As a result, this choices need to be measured. Therefore, we continue by creating a PoC (Proof of Concept) on which we perform certain experiments. Some evaluations were manual (e.g. verifying that the backend can render a map via a third-party service and display a user’s hike), while others were automated stress tests simulating scalability, latency, and resilience. As detailed in the final section, the experimental results validate the assumptions made in our initial design.

---
## 6. Elaboration of Specific Architectural Decisions and Alternatives

#### 6.1 Tech Stack

#### 6.2 Architecture Styles  

#### 6.3  Separation of Concerns (SoC) Principle
Separation of Concerns (SoC) is a software design and engineering discipline that attempts to break down challenging systems into easier, more comprehensible pieces. The idea is to organize a system's parts in a manner that every piece is responsible for a single concern, or an integrated aspect of functioning, without combining concerns. By doing so, SoC enhances the system’s modularity, maintainability, and scalability. We adhere to this principle in the Hikerz codebase. While the service houses the functional logic, the controller serves as the point of entry for requests. In order to facilitate a clean architecture and decouple the internal model from the external API representation, the result of retrieving entities from the repository is mapped to a Data Transfer Object (DTO).

![SOC Example](./img/SOC.jpg)



#### 6.4 Quality Assurance
Quality assurance in the Hikerz project focuses on ensuring reliability, stability, and correctness across the components which form the system. The project employs 7 different methods to ensure quality assurance: Unit testing, Postman API Testing, Manual Testing, Stress/Load Testing, CI/CD Pipeline integration and Staging Environment. Unit tests, created using JUnit, Mockito, and Spring Boot, confirm that separate backend elements, like controllers and services, operate as intended when used alone. Postman is used for testing and validating RESTful APIs. It helps ensure the backend API endpoints are functioning correctly, with the right responses and status codes. By enabling developers to engage directly with the application, manual testing concentrates on usability, user experience, and edge cases that automated testing might miss. Integration tests ensure backend responses match frontend expectations. The CI/CD pipeline ensures reliable delivery and quick feedback by automated building, testing, and deployment using Gitlab’s release process.The k6 stress and load testing assesses how well the system performs under high usage, confirming that it can continue to be scalable, responsive, and stable even during periods of the peak weekend demand. Lastly, Hikerz implements a staging environment in which new features and updates are deployed before reaching production to ensure a release process.

![Quality Assurance Pipeline](./img/quality_asssurance.png)     

#### 6.5 RESTful HTTP APIs Response 

##### 6.5.1. Context
As Hikerzs’ quality attributes focus on performance and scalability, when designing the RESTful HTTP APIs for the microservices, an important architectural decision was made on how to handle the retrieval of large datasets: Paginated Responses versus Bulk Fetching (non-paginated). As explained in here response pagination should improve performance while supporting better accessibility and facilitating easier navigation and comparison.


##### 6.5.2. Chosen API Design Approach and Alternatives
The paginated approach retrieves data in smaller, manageable chunks called pages, which improves performance and resource management when dealing with large datasets. Our standard configuration fetches 10 users per page. When the user scrolls through the list of registered users to find people to follow, an additional 10 users are automatically fetched once the user reaches the end of the currently loaded list. If the user enters a search query, the same incremental loading process applies, but the results are filtered by the server based on the provided query. The main advantages consist of smaller data payloads and faster response times with lower latency, reduced server memory usage with lower database load and less bandwidth consumption. Paginated responses should allow the server to handle large datasets efficiently even under high load.

The bulk fetching approach retrieves the entire collection of data in a single HTTP response. While this method eliminates the need for multiple round trips to the server and may reduce latency for smaller datasets, it is increasingly inefficient and memory-intensive with high volume, the one the Hikerz app is expected to interact with. Large responses increase both load times and client-side rendering. This degrades user experience and increases the bandwidth usage. When a user enters a search query, the same bulk loading process applies, but the server filters the results based on the provided query. The main drawbacks of this approach consist of the possibility to  monopolize server resources which can lead to user-facing timeouts. Furthermore, this increases the risk of high memory and CPU utilization on both the server and the client.

---
## 7. Assessment of impact of Cloud vs On-Premises Deployment

#### 7.1 PostgreSQL

#### 7.2 Mapbox

##### 7.2.1 Introduction:

##### 7.2.2 Table for Comparison

##### 7.2.3 Motivation:

##### 7.2.4 Cloud vs On Premises:

---
## 8. Critical Selection of Open Source Components

**Spring Boot** is an open-source Java web framework that makes creating web apps and microservices easier. It enables programmers to create production-quality, standalone apps with little setup. Spring Boot simplifies setup by embracing an opinionated approach to the Spring platform and incorporating third-party libraries, freeing developers to concentrate on creating application logic rather than configuration. To cut boilerplate, we use **Project Lombok** (e.g., @Getter, @Setter, @Builder, @RequiredArgsConstructor) to generate builders and routine code at compile time, improving readability and maintainability. Furthermore, **Mockito** pairs with JUnit to mock dependencies and isolate units enabling us to create reliable tests for controllers, services, and repositories.

**PostgreSQL** is a powerful open-source relational database system that is well-known for its extensibility, high standards compliance, and sophisticated features—all without the cost of licensing. The **PostGIS** extension is one of PostgreSQL's most important features for the Hikerz project. The app's map-based features and geospatial analysis depend on the efficient storage, querying, and manipulation of geographic data made possible by this extension's spatial database capabilities.

**K6** is an open-source load testing tool designed for testing the performance of APIs, websites, and microservices under heavy load. It provides detailed insights into performance bottlenecks and system limits. We export K6 metrics and visualize them in real time with **Grafana** dashboards.

---
## 9. Event Communication Pattern

### 9.1 Alternatives Considered

### 9.2 Comparative Analysis

### 9.3 Selected Pattern: Redis Publish–Subscribe

---
## 10. Proof of concept

### 10.1 Structure 
Our design is influenced by two important architectural decisions: (1) paginated API responses for scalability and low latency responses, and (2) utilizing Mapbox to render PostGIS-backed routes acquired from the users. The PoC verifies that backend maps are sucesfully rendered from frontend supplied route and compares paginated and non-paginated endpoints. In order to verify scalability, we will measure end-to-end performance, including p50/p95 latency, throughput, and error rates. 

### 10.2. Experiment 

#### 10.2.1. Performance Setup and Load Test Scenarios
For the Proof of Concept (PoC), we evaluate the performance trade-offs between the two approaches using the user retrieval endpoint /all/{username}, which is invoked when users search for other people in the application. 

For an accurate and objectively comparison , we measure the performance difference by executing the same load test against both endpoints. The tests are performed on the user microservice initialized on a dataset of 1000 users. We use the k6 load tester, an open-source, developer-centric load testing tool. K6 allows us to script complex performance scenarios using JavaScript, measuring critical metrics like throughput, response time, and error rate under high concurrency. Grafana is used for real-time visualization, allowing for a direct, graphical comparison of the performance characteristics (latency, throughput, resource usage) of the two endpoints.

The scenario models a gradual ramp-up scenario to observe the microservice's behavior as the load intensifies, pushing both endpoints to their limits. The scenario defines the number of concurrent Virtual Users (target) over a specified duration.

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

#### 10.2.2. Metrics Considered

| Metric                | Paginated Endpoint   | Bulk Fetch Endpoint   |
|-----------------------|----------------------|-----------------------|
| **Latency (p95 Response Time)** | Low and stable across all load stages. | Will spike sharply under medium-to-high load (Stage 4+), leading to potential timeouts. |
| **Throughput (Requests/s)** | High and sustained, processing many requests per second. | Will drop significantly, limited by the long processing time of each large request. |
| **Error Rate** | Near 0%. | Will likely show a high percentage of timeouts or server errors at higher loads. |
| **System Load (CPU/Memory)** | Moderate and predictable. | High peaks in both CPU and Memory as the service attempts to load and serialize 1000 objects concurrently for many users. |

#### 10.2.3. Expected results
The visualization in Grafana is expected to demonstrate the superior performance of the paginated approach, with the non-paginated option starting to fail with a high number of requests sent per second. 

### 10.3 Results
The actual test experiment results confirm the expectations: as described in this article, the paginated API maintains response times within acceptable parameters even under concurrent load. In contrast, as illustrated in the figures, the bulk API begins to time out with 1000 concurrent API calls, highlighting the performance drawbacks of the non-paginated approach. Meanwhile, the paginated API continues to process requests efficiently, with its latency response to each request at most 2 seconds, 95% lower than the 60-second timeout the bulk API experiences. This results should validate the architectural decision to implement pagination as the standard for data retrieval endpoints that handle potentially large collections, ensuring the microservice remains performant and resilient under high concurrency.                    

| Metric               | Paginated                                                                 | Non Paginated                                                                 |
|----------------------|---------------------------------------------------------------------------|-------------------------------------------------------------------------------|
| Http Performance     | ![Http Performance Pag](./img/pag-experiment/pag-http-performance.png)    | ![Http Performance Non Pag](./img/pag-experiment/non-pag-http-performance.png) |
| Http Request Duration| ![Http Request Duration Pag](./img/pag-experiment/http-req-dur-pag.png)   | ![Http Request Duration Non Pag](./img/pag-experiment/http-req-dur-non-pag.png) |
| VU Number            | ![VU Number Pag](./img/pag-experiment/vu-pag.png)                         | ![VU Number Non Pag](./img/pag-experiment/vu-non-pag.png)                     |



---
## References
