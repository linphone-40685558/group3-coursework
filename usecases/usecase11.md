# USE CASE 11: Produce a Report on All Cities in the District (Eg. England) by Largest Population to Smallest

## Goal in Context

As a researcher, I want to view all the cities in a specific district (Eg. England) organized by largest population to smallest so that I can analyze all cities in that district.

## Scope

District (Eg. England)

## Level

Primary task

## Preconditions

The system contains population data for all cities in the district (Eg. England).

## Success End Condition

A report listing all cities in the district (Eg. England) from largest to smallest population is generated.

## Failed End Condition

No report is produced

## Primary Actor

Researcher

## Trigger

A request for a district population report is made.

## Main Success Scenario

- Researcher requests a report on the population of cities in the district (Eg. England).

- The system retrieves population data for all cities.

- The system sorts cities by population in descending order.

- A report is generated and made available for analysis.

## Extensions

If the provided district is not in the database, the system will print an error.

## Sub-Variations

None

## Schedule

Due Date: Release 1.0
