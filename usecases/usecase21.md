# USE CASE 21: Produce a Report on the Top 5 (Eg. ) Populated Capital cities in continent

## Goal in Context

As a user, I want to view top N populated capital cities data in a specific continent so that I can see the top N populated capital cities in that continent.

## Scope

Continent

## Level

Primary task

## Preconditions

The system contains population data for all capital cities in the continent.

## Success End Condition

A report listing the top N (Eg. Top 5) populated capital cities in the continent (Eg. Southeast Asia) is generated.

## Failed End Condition

No report is produced.

## Primary Actor

User

## Trigger

A request for a top N (Eg. Top 5) populated capital cities in a continent report is made.

## Main Success Scenario

User provides a value for N (Eg. 5) and region (Eg. Southeast Asia) to requests a population report in a region.

The system retrieves population data for countries in a region.

The system sorts countries by population in descending order and limit the number of rows depending on the N (5 was provided).

The system displays the top N (5) populated countries in a region in a report.

## Extensions

Some exceptions

## Sub-Variations

None

## Schedule

Due Date: Release 1.0