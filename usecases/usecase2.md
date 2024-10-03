# USE CASE 2: Produce a Report on All Countries in a Continent by Largest Population to Smallest

## Goal in Context

As a researcher, I want to view all the countries in a continent organized by population so that I can see the largest
population countries each continent.

## Scope

Continent

## Level

Primary task

## Preconditions

The system contains data for all countries within continents.

## Success End Condition

A report listing countries information ordered by population in the selected continent is generated.

## Failed End Condition

No report is produced.

## Primary Actor

Researcher

## Trigger

A request for countries' information with continent-specific (Eg.Asia) data is made.

## Main Success Scenario

- User provides a continent and requests a country information report organized by population.

- The system retrieves countries' data within the provided continent.

- The system sorts countries by population in descending order.

- The country report is generated for the selected continent.

## Extensions

If the provided continent is not in the database: The system returns an error message - "Continent not found. Please
check the continent name and try again."

## Sub-Variations

None

## Schedule

Due Date: 4-Oct-2024