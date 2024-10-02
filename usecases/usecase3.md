# USE CASE 3: Produce a Report on All Countries in a Region by Largest Population to Smallest

## Goal in Context

As a researcher, I want to view all countries in a specific region organized by population so that I can see largest population countries by the region.

## Scope

Region

## Level

Primary task.

## Preconditions

The system contains population data for all countries within the regions.

## Success End Condition

A report listing countries by population in the selected region is generated.

## Failed End Condition

No report is produced.

## Primary Actor

Researcher

## Trigger

A request for region-specific (Eg.Southeast Asia) population data is made.

## Main Success Scenario

- User selects a region and requests a population report.

- The system retrieves population data for countries within the region.

- The system sorts countries by population in descending order.

- The report is generated for the selected region.

## Extensions

If the provided region is not in the database, the system returns all available countries.

## Sub-Variations

None.

## Schedule

Due Date: Release 1.0