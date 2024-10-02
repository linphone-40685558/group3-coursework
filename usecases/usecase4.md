# USE CASE 4: Produce a Report on the Top N (Eg. 5) Populated Countries in the World

## Goal in Context

As a researcher, I want to view Top N (Eg. 5) countries in a specific region organized by population so that I can see largest population countries by the region.

## Scope

Global

## Level

Primary task

## Preconditions

- The system contains countries' data in the world.
- The user provides a valid value for N (e.g., 5).

## Success End Condition

A country report listing the top N (Eg. Top 5) populated countries in the world is generated.

## Failed End Condition

No report is produced.

## Primary Actor

Researcher

## Trigger

A request for a top N (Eg. Top 5) populated countries report is made.

## Main Success Scenario

- User provides a value for Top N (Eg. 5) and requests a country report organized by population.

- The system retrieves countries' data for Top N (5) populated countries.

- The system sorts countries by population in descending order.

- The system displays the top N (5) populated countries in a report.

## Extensions

If N exceeds the total number of countries, the system returns a report containing all available countries with a message indicating that fewer countries exist than requested.

## Sub-Variations

None

## Schedule

Due Date: 4-Oct-2024