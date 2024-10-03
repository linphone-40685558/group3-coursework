# USE CASE 20: Produce a Report on the Top 5 (Eg. ) Populated Capital cities in a world

## Goal in Context

As a user, I want to view top N populated capital cities globally so that I can analyze populations of capital cities.

## Scope

Global

## Level

Primary task

## Preconditions

The system contains population data for all capital cities in the world.

## Success End Condition

A report listing the top N (Eg. Top 5) populated capital cities in the world (Eg. Southeast Asia) is generated.

## Failed End Condition

No report is produced.

## Primary Actor

User

## Trigger

A request for a top N (Eg. Top 5) populated capital cities in a world report is made.

## Main Success Scenario

User provides a value for N (Eg. 5) and region (Eg. Southeast Asia) to requests a population report in a region.

The system retrieves population data for countries in a region.

The system sorts countries by population in descending order and limit the number of rows depending on the N (5 was
provided).

The system displays the top N (5) populated countries in a region in a report.

## Extensions

Some exceptions

## Sub-Variations

None

## Schedule

Due Date: 18-Oct-2024