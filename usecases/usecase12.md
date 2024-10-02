# USE CASE 6: Produce a Report on the Top N (Eg. 5) Populated Cities around the world

## Goal in Context

As a researcher, I want to produce top N populated cities data around the world so that I can analyze the top N populated cities around the world.

## Scope

Around the world

## Level

Primary task

## Preconditions

The system contains data for all cities around the world.

## Success End Condition

A report listing the top N (Eg. Top 5) populated cities around the world is generated.

## Failed End Condition

No report is produced.

## Primary Actor

Researcher

## Trigger

A request for a top N (Eg. Top 5) populated cities around the world report is made.

## Main Success Scenario

- User provides a value for N (Eg. 5) to requests Top N(5) cities population report around the world.

- The system retrieves data for cities around the world.

- The system sorts cities by population in descending order and limit the number of rows depending on the N (5).

- The system displays the top N (5) populated cities around the world.

## Extensions

If N exceeds the number of cities around the world, the system returns the maximum number of cities data available.

## Sub-Variations

None

## Schedule

Due Date: Release 1.0