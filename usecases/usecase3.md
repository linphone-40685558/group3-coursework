# USE CASE 3: Produce a Report on All Countries in a Region by Largest Population to Smallest

## Goal in Context

As a researcher, I want to view all countries in a specific region organized by population so that I can see largest
population countries by the region.

## Scope

Region

## Level

Primary task.

## Preconditions

- The system contains data for all countries within the specified regions.
- The user provides a valid region name (e.g., Southeast Asia, Western Europe).

## Success End Condition

A report listing countries' information organized by population in the selected region is generated.

## Failed End Condition

No report is produced.

## Primary Actor

Researcher

## Trigger

A request for country report with region-specific information (Eg.Southeast Asia) is made.

## Main Success Scenario

- User selects a region and requests a country report.

- The system retrieves countries' data within the region.

- The system sorts countries by population in descending order.

- The report is generated for the selected region.

## Extensions

If the provided region is not in the database: The system returns an error message "Region not found. Please check the
region name and try again."

## Sub-Variations

None

## Schedule

Due Date: 4-Oct-2024