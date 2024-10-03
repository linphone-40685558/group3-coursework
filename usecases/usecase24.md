## USE CASE 24: Produce a Report on the Population of People, People Living in Cities, and People Not Living in Cities in Each Region

### Goal in Context

As a researcher, I want to see the total population of people, those living in cities, and those not living in cities
for each region so that I can analyze urban and rural population distributions by region.

### Scope

Region

### Level

Primary task

### Preconditions

- The system contains population data for each region, including data on people living in cities and those
  living outside cities.

### Success End Condition

A report is generated showing the total population, urban population, and rural population for each region.

### Failed End Condition

No report is produced

### Primary Actor

Researcher

### Trigger

A request for a population report by region is made, covering people living in cities and outside cities.

### Main Success Scenario

1. User requests a report for the population of people, those living in cities, and those not living in cities, for each
   region.
2. The system retrieves population data for all regions, including data for urban and rural areas.
3. The system generates a report that lists:
    - Total population for each region.
    - Population of people living in cities.
    - Population of people not living in cities.
4. The report is made available for analysis.

### Extensions

- **If there is a data retrieval error**: The system will return a message prompting the user to retry or contact
  support.

### Sub-Variations

None

### Schedule

Due Date: 18-Oct-2024
