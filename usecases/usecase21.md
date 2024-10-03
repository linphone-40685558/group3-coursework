# USE CASE 21: Produce a Report on the Top N (Eg. 5) Populated Capital cities in continent

## Goal in Context

As a researcher, I want to view top N (5) populated capital cities data in a specific continent so that I can see the top N (5)
populated capital cities in that continent.

## Scope

Continent (Eg. Asia)

## Level

Primary task

## Preconditions

- The system contains all capital cities data in the world within the continents.
- The user provides a valid value for N (e.g., 5) and specifies the continent (Eg. Asia).

## Success End Condition

A capital city report listing the top N (Eg. Top 5) populated capital cities in the continent (Eg. Asia) is generated.

## Failed End Condition

No report is produced.

## Primary Actor

Researcher

## Trigger

A request for a top N (Eg. Top 5) populated capital cities in a continent (Eg. Asia) report is made.

## Main Success Scenario

- User provides a value for N (Eg. 5) and continent (Eg. Asia) to requests Top N(5) capital cities population report in a continent.

- The system retrieves capital cities' data in a continent.

- The system sorts capital cities by population in descending order and limit the number of rows depending on the N (5).

- The system displays the top N (5) populated capital cities in a continent in a report.

## Extensions

If N exceeds the total number of capital cities in the continent, the system returns a report containing all available capital cities in the continent with a message indicating that fewer capital cities exist than requested.

## Sub-Variations

None

## Schedule

Due Date: 18-Oct-2024