# USE CASE 6: Produce a Report on the Top N (Eg. 5) Populated cities in a Continent (Eg.Asia)

## Goal in Context

As a researcher, I want to produce top N populated cities data in a specific continent so that I can analyze the top N populated cities in that continent.

## Scope

Continent (Eg. Asia)

## Level

Primary task

## Preconditions

The system contains data for all cities within the continent.

## Success End Condition

A report listing the top N (Eg. Top 5) populated cities in the continent (Eg. Asia) is generated.

## Failed End Condition

No report is produced.

## Primary Actor

Researcher

## Trigger

A request for a top N (Eg. Top 5) populated cities in a continent (Asia) report is made.

## Main Success Scenario

- User provides a value for N (Eg. 5) and continent (Eg. Asia) to requests Top N(5) populated cities report in a continent.

- The system retrieves data for cities in a continent.

- The system sorts cities data by population in descending order and limit the number of rows depending on the N (5).

- The system displays the top N (5) populated cities in a continent in a report.

## Extensions

If N exceeds the number of cities in the continent, the system returns the maximum number of cities data available.

## Sub-Variations

None

## Schedule

Due Date: Release 1.0