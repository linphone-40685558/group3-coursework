# USE CASE 6: Produce a Report on the Top N (Eg. 5) Populated cities in a country (Eg. Myanmar)

## Goal in Context

As a researcher, I want to produce top N populated cities data in a specific country so that I can analyze the top N populated cities in that country.

## Scope

Country (Eg. Myanmar)

## Level

Primary task

## Preconditions

The system contains data for all cities within the country.

## Success End Condition

A report listing the top N (Eg. Top 5) populated cities in the country (Eg. Myanmar) is generated.

## Failed End Condition

No report is produced.

## Primary Actor

Researcher

## Trigger

A request for a top N (Eg. Top 5) populated cities in a country (Myanmar) report is made.

## Main Success Scenario

- User provides a value for N (Eg. 5) and country (Eg. Myanmar) to requests Top N(5) populated cities report in a country.

- The system retrieves data for cities in a country.

- The system sorts cities data by population in descending order and limit the number of rows depending on the N (5).

- The system displays the top N (5) populated cities in a country in a report.

## Extensions

If N exceeds the number of cities in the country, the system returns the maximum number of cities data available.

## Sub-Variations

None

## Schedule

Due Date: 11-Oct-2024