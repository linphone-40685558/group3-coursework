# USE CASE 20: Produce a Report on the Top N (Eg. 5) Populated Capital Cities in a world

## Goal in Context

As a researcher, I want to view top N (Eg. 5) populated capital cities globally so that I can analyze populations of capital cities.

## Scope

Global

## Level

Primary task

## Preconditions

- The system contains capital cities' data in the world.
- The user provides a valid value for N (e.g., 5).

## Success End Condition

A capital cities report listing the top N (Eg. Top 5) populated capital cities in the world is generated.

## Failed End Condition

No report is produced.

## Primary Actor

Researcher

## Trigger

A request for a top N (Eg. Top 5) populated capital cities in a world report is made.

## Main Success Scenario

- User provides a value for Top N (Eg. 5) and requests a capital city report organized by population.

- The system retrieves capital cities' data for Top N (5) populated capital cities.

- The system sorts capital cities by population in descending order.

- The system displays the top N (5) populated capital cities in a report.

## Extensions

If N exceeds the total number of capital cities in a world, the system returns a report containing all available capital cities in the world with a message indicating that fewer capital cities exist than requested.

## Sub-Variations

None

## Schedule

Due Date: 18-Oct-2024