# USE CASE 18: Produce a Report on All Capital cities in the continent organized by Largest Population to Smallest

## Goal in Context

As a researcher, I want to view all the capital cities in a specific continent organized by largest to smallest population so
that I can analyze capital cities data in that continent.

## Scope

Continent (Eg. Asia)

## Level

Primary task

## Preconditions

- The system contains population data for all capital cities in the continent.
- The user has to provide a valid continent name(Eg. Asia).

## Success End Condition

A report listing all capital cities information ordered by population in a selected continent (Eg. Asia) is generated.

## Failed End Condition

No report is produced

## Primary Actor

Researcher

## Trigger

A request for a capital cities' information with continent-specific (Eg. Asia) data is made.

## Main Success Scenario

- User provides a continent and requests a capital cities information report organized by population.

- The system retrieves capital cities' data within the provided continent.

- The system sorts capital cities by population in descending order.

- A capital city report is generated for selected continent and made available for analysis.

## Extensions

If the provided continent is not in the database, the system will print an error message "Continent not found. Please check the continent name and try again."

## Sub-Variations

None

## Schedule

Due Date: 18-Oct-2024