# USE CASE 4: Produce a Report on the Top N (Eg. 5) Populated Countries in the World

## Goal in Context

As a researcher, I want to view Top N (Eg. 5) countries in a specific region organized by population so that I can see largest population countries by the region.

## Scope

Global

## Level

Primary task

## Preconditions

The system contains population data for all countries in the world.

## Success End Condition

A report listing the top N (Eg. Top 5) populated countries in the world is generated.

## Failed End Condition

No report is produced.

## Primary Actor

Researcher

## Trigger

A request for a top N (Eg. Top 5) populated countries report is made.

## Main Success Scenario

- Administrator provides a value for Top N (Eg. 5) and requests a population report.

- The system retrieves population data for N (5) countries.

- The system sorts countries by population in descending order.

- The system displays the top N (5) populated countries in a report.

## Extensions

If N exceeds the number of countries in the continent, the system returns the maximum number of countries available.

## Sub-Variations

None

## Schedule

Due Date: Release 1.0