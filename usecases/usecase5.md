# USE CASE 5: Produce a Report on the Top N (Eg. 5) Populated Countries in the Continent

## Goal in Context

As a researcher, I want to produce the top N (5) populated countries in a specific continent so that I can analyze the top N (5) populated countries in that continent.

## Scope

Continent

## Level

Primary task

## Preconditions

The system contains countries' data in the world within the continents.

## Success End Condition

A report listing Top N (5) countries in a continent by population in descending order is generated.

## Failed End Condition

No report is produced.

## Primary Actor

Researcher

## Trigger

A request for a Top N (5) populated countries in a continent report is made.

## Main Success Scenario

- User requests a country report for Top N (5) populated countries in a continent (Eg. Asia).

- The system retrieves countries' data for Top N (5) countries in a continent.

- The system sorts countries by population in descending order.

- The report is generated and made available for review.

## Extensions

If N exceeds the number of countries in the continent, the system returns an error.

## Sub-Variations

None

## Schedule

Due Date: Release 1.0