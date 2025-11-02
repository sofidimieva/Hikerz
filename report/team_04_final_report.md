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

##### 7.2.2 Table for Comparison

##### 7.2.3 Motivation:

##### 7.2.4 Cloud vs On Premises:

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
## References
