# Week 1

- Research and brainstorm on potential projects we could pick. (3 hours)
- Pick a single concept which stands out for the POC and think of its requirements, stakeholders and use cases. (1 hour)
- Formulate our problem statement and write description for the POC proposal (1 hour)
- Prepare and refine the presentation for our formulated concept which is the Hikerz app (1 hour 30 min)

# Week 2

- Research similar existing apps and their architecture, develop a high level idea of the architecture for Hikerz (5 hours)
- Research backend frameworks and external apis for maps visualization (2 hours)
- Prepared wireframes for screens in our future app (4 hours)

# Week 3

- Organize the Event storming session (4 hours)
- Gather results from the Event storming session and use them to derive domain-driven design bound contexts, entities, relationships between them (3 hours)
- Decide on how to handle these relationships within our app by creating diagrams (2 hours)
- Get a lower level idea of the architecture and compare options (either monolith with separate contexts or microservices) (3 hours)
- Add corresponding sections to the finch report (2 hours)


# Week 4

- Work on the presentation for the meeting with the other team (2 hours)
- Research database storage for storing geo-spatial data and ways of converting geo formats for easier integration with external APIs and DB storage
- research how the PostGIS database stores geo-spatoal data => 
    - how GPX files can be reformatted to PostGIS' Linestring type
    - how they can be further reformatted to GeoJSONs which are used by the Mapbox API used for map visualization of each route 
    - formulate the exact flow of the Maps creation since it is a central concept in our app
(4 hours)    
- Go through PostGIS' and Mapbox's documentation to ensure integration is possible before starting developing the POC (2 hours)
- Document findings (1 hour)

# Week 5
- set up frontend, explore libraries for pre-maid components
- go through gluestack documentation 
- Worked on UI screens for the minimal working product following the previously developed wireframes (5 hours)
    - used sample images and mocked data for now


# Week 6
- created a POST request on /activity/upload-gpx endpoint which takes a GPX file as body (2 hours)
- integrated this with the GET request on endpoint /activity to test saving to DB (1 hour)
- integrated this with the GET request on endpoint /activity/mapbox-static to test mapbox visualization  (1 hour)
- followed the C4 Model by creating 4 diagrams for visual abstraction (6 hours)
- researched on event communication patterns and did a comparative study (2 h)
- add corresponding sections to the Heron report (2 hours)

