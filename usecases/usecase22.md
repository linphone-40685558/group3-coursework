# USE CASE 22: Produce a Report on the Top N (Eg. 5) Populated Capital cities in A Region

## Goal in Context

As a researcher, I want to view top N populated capital cities data in a specific region so that I can analyze the top N (5)
populated capital cities in that region

## Scope

Region (Southeast Asia)

## Level

Primary task

## Preconditions

- The system contains capital cities data within the regions.
- The user provides a valid value for N (e.g., 5) and specifies the region (e.g., Southeast Asia).

## Success End Condition

A capital cities report listing the top N (Eg. Top 5) populated capital cities in the region (Eg. Southeast Asia) is generated.

## Failed End Condition

No report is produced.

## Primary Actor

Researcher

## Trigger

A request for a top N (Eg. Top 5) populated capital cities in a region (Southeast Asia) report is made.

## Main Success Scenario

- User provides a value for N (Eg. 5) and region (Eg. Southeast Asia) to requests Top N(5) capital cities population report
  in a region.

- The system retrieves capital cities' data in a region.

- The system sorts capital cities by population in descending order and limit the number of rows depending on the N (5).

- The system displays the top N (5) populated capital cities in a region in a report.

## Extensions

If N exceeds the total number of capital cities in the region the system returns a report containing all available capital cities in the region with a message indicating that fewer capital cities exist than requested.

## Sub-Variations

None

## Schedule

Due Date: 18-Oct-2024