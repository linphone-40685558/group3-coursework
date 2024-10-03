# USE CASE 18: Produce a Report on All Capital cities in the region organized by Largest Population to Smallest

## Goal in Context

As a researcher, I want to view all capital cities in a specific region organized by largest to smallest population so that I
can analyze capital cities data in that region.

## Scope

Region (Eg. Southeast Asia)

## Level

Primary task

## Preconditions

- The system contains data for all capital cities in the region.
- The user has to provide a valid region name (Eg. Southeast Asia).

## Success End Condition

A report listing capital cities' information organized by population in the selected region is generated.

## Failed End Condition

No report is produced

## Primary Actor

Researcher

## Trigger

A request for capital cities' information with region-specific (Eg.Southeast Asia) data is made.

## Main Success Scenario

- User provides a region (Eg. Southeast Asia) and requests a capital cities information report organized by population.

- The system retrieves population data for all capital cities.

- The system sorts capital cities by population in descending order.

- A capital city report is generated and made available for analysis.

## Extensions

If the provided region is not in the database, the system will print an error message - "Region not found. Please check the region name and try again."

## Sub-Variations

None

## Schedule

Due Date: 18-Oct-2024