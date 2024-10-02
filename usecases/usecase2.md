# USE CASE 2: Produce a Report on All Countries in a Continent by Largest Population to Smallest

## Goal in Context

As a researcher, I want to view all the countries in a continent organized by population so that I can see the largest population countries each continent.

## Scope

Continent

## Level

Primary task

## Preconditions

The system contains population data for all countries within continents.

## Success End Condition

A report listing countries by population in the selected continent is generated.

## Failed End Condition

No report is produced.

## Primary Actor

Researcher

## Trigger

A request for continent-specific (Eg.Asia) population data is made.

## Main Success Scenario

- User provides a continent and requests a population report.

- The system retrieves population data for countries within the provided continent.

- The system sorts countries by population in descending order.

- The report is generated for the selected continent.

## Extensions

If the provided continent is not in the database, the system returns all available countries.

## Sub-Variations

None.

## Schedule

Due Date: Release 1.0