# Sushi Roll Masters

## Table of Contents
1. [Overivew](#overview)
2. [Structure](#structure)
3. [Documentation](#documentation)
4. [Contact Information](#contact-information)

## Overview
Consider a system with three sushi chef threads and one resource agent (supplier) thread.
Each chef wants to roll sushi and then serve it. However, to roll a sushi and serve it, the chef needs
three ingredients: Rice, Nori (seaweed), Filling (e.g., fish or veggies). One of the chef threads has an
infinite supply of rice, another has nori, and the third has the filling.

The agent (supplier) thread has infinite supply of all three ingredients. The agent randomly selects two
of the ingredients and places them on a counter.

The chef who has the third ingredient completes the sushi roll and serves a plate of sushi, signalling
the agent (supplier) upon completion. The agent (supplier) then puts out another two of the three
ingredients, and the cycle repeats.
## Structure
### Agent.java
- Represents the Agent(supplier), responsible for selecting ingredients at random and placing on the counter
- Implements the Runnable interface
### Chef.java
- Represents the Chef, responsible for creating sushi rolls using the ingredients on the counter and their own personal ingredient
- Implements the Runnable interface
### Counter.java
- Represents the counter, a shared space between agent and chef which stores the ingredients provided by agent and sends to all chefs
### Main.java
- Handles the creation and running of all threads

## Setup Guide


## Documentation
Below you can find a UML sequence diagram and a UML class diagram of the system

FIGURE 1 
FIGURE 2 

## Contact Information
Mahad Ahmed
101220427