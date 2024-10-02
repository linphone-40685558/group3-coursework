# USE CASE 6: Produce a Report on the Top N (Eg. 5) Populated Countries in a Region (Eg. Southeast Asia)

## Goal in Context

As a researcher, I want to produce the top (N) populated countries in a specific region (Southeast Asia) so that I can analyze the top N (5) populated countries in that region.

## Scope

Region (Eg. Southeast Asia)

## Level

Primary task

## Preconditions

The system contains population data for all countries within the regions.

## Success End Condition

A report listing the top N (Eg. Top 5) populated countries in the region (Eg. Southeast Asia) is generated.

## Failed End Condition

No report is produced.

## Primary Actor

Researcher

## Trigger

A request for a top N (Eg. Top 5) populated countries in a region (Southeast Asia) report is made.

## Main Success Scenario

- User provides a value for N (Eg. 5) and region (Eg. Southeast Asia) to requests Top N(5) countries population report in a region.

- The system retrieves population data for countries in a region.

- The system sorts countries by population in descending order and limit the number of rows depending on the N (5).

- The system displays the top N (5) populated countries in a region in a report.

## Extensions

If N exceeds the number of countries in the region, the system returns the maximum number of countries available.

## Sub-Variations

None

## Schedule

Due Date: Release 1.0