# USE CASE 9: Produce a Report on All Cities in the Region (Eg. Southeast Asia) by Largest Population to Smallest
All the cities in a region organised by largest population to smallest.
## Goal in Context

As a researcher, I want to view all cities in a specific region (Eg. Southeast Asia) organized by largest population to smallest so that I can analyze cities data in that region.

## Scope

Region (Eg. Southeast Asia)

## Level

Primary task.

## Preconditions

The system contains data for all cities in the region (Eg. Southeast Asia).

## Success End Condition

A report listing cities' information organized by population in the selected region is generated.

## Failed End Condition

No report is produced

## Primary Actor

Researcher

## Trigger

A request for cities report with region-specific information (Eg.Southeast Asia) is made.

## Main Success Scenario

- User provides a region (Eg. Southeast Asia) and requests a cities information report organized by population.

- The system retrieves population data for all cities.

- The system sorts cities by population in descending order.

- The report is generated for the selected region.

## Extensions

If the provided region is not in the database, the system will print an error.

## Sub-Variations

None

## Schedule

Due Date: 11-Oct-2024
