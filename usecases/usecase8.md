# USE CASE 8: Produce a Report on All Cities in the Continent (Eg. Asia) by Largest Population to Smallest

## Goal in Context

As a researcher, I want to view all the cities in a continent organized by largest population to smallest so that I can see largest populated cities in that continent.

## Scope

Continent (Eg. Asia)

## Level

Primary task

## Preconditions

The system contains data for all cities in the continent (Eg. Asia).

## Success End Condition

A report listing all cities information ordered by population in a provided continent (Eg. Asia) is generated.

## Failed End Condition

No report is produced

## Primary Actor

Researcher

## Trigger

A request for a countries' information with continent-specific (Eg. Asia) data is made.

## Main Success Scenario

- User provides a continent and requests a cities information report organized by population.

- The system retrieves cities' data within the provided continent.

- The system sorts cities by population in descending order.

- The city report is generated for the selected continent.

## Extensions

If the provided continent is not in the database, the system will print an error.

## Sub-Variations

None

## Schedule

Due Date: Release 1.0
