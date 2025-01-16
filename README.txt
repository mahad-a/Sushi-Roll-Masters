# Sushi Roll Masters

## Table of Contents
1. [Overview](#overview)
2. [Structure](#structure)
3. [Setup Guide](#setup-guide)
4. [Documentation](#documentation)
   1. [UML class diagram](#uml-class-diagram)
   2. [UML sequence diagram](#uml-sequence-diagram)
5. [Contact Information](#contact-information)

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
1. Clone or download the project to your computer
2. Open the project in your preferred IDE (Intellij preferred)
3. Ensure the `Main.java` file is located in the package `org.example`
4. Compile the project using your IDE, build the project
5. Execute the program by running the `Main.java` in your IDE

## Expected Output
The program will:
- Start three chef threads, each continuously providing one type of ingredient (`Rice`, `Nori`, or `Filling`).
- Start one agent thread that selects two ingredients from the counter to make sushi rolls.

The threads will run concurrently, demonstrating multithreaded behavior.

## Documentation
Below you can find a UML sequence diagram and a UML class diagram of the system
### UML class diagram
![UML class diagram](docs/UML_class_diagram.png)
### UML sequence diagram
![UML sequence diagram](docs/UML_sequence_diagram.png) 

## Contact Information
Mahad Ahmed
101220427