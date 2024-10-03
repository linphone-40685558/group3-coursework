## USE CASE 26: Produce a Report on the Total Population of a Continent

### Goal in Context
As a researcher, I want to view the population of a continent so that I can analyze population distribution in that continent.

### Scope
Continent

### Level
Primary task

### Preconditions
- The system contains population data for one continent.

### Success End Condition
A report is generated showing the population of the continent.

### Failed End Condition
No report is produced

### Primary Actor
Researcher

### Trigger
A request for the population of the continent is made.

### Main Success Scenario
1. User requests a report for the population of a continent.
2. The system retrieves population data for the continent.
3. The system calculates the total population by summing the populations of all countries that are involved in the continent.
4. The report is generated and made available for analysis.

### Extensions
- **If there is a data retrieval error**: The system returns a message prompting the user to retry or contact support.

### Sub-Variations
None

### Schedule
Due Date: 15-Oct-2024
