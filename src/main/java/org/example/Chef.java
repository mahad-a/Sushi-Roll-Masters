package org.example;

import java.util.ArrayList;
import java.util.List;


/**
 * Chef class representing a sushi chef, agent places 2 ingredients on the
 * counter, the chef with the third missing ingredient completes the sushi roll
 */
public class Chef implements Runnable {
    private String ingredient;
    private Counter counter;

    /**
     * Chef constructor
     * @param ingredient the ingredient in which the chef has an infinite supply of
     * @param counter the counter where agent places list of the ingredients available for creation of sushi roll
     */
    public Chef(String ingredient, Counter counter){
        this.ingredient = ingredient;
        this.counter = counter;
    }

    /**
     * Checks if the chef has one of the available ingredients on the counter
     * @param ingredient the chef's ingredient
     * @return if the chef's ingredient is on the counter
     */
    public boolean hasIngredient(List<String> ingredient){
        return ingredient.contains(this.ingredient);
    }

    /**
     * Runs the chef thread, stops when 20 sushi rolls are made
     */
    public void run() {
        String chef = Thread.currentThread().getName();
        while (!counter.maxRollsReached(20)) {
            ArrayList<String> ingredientsOnCounter = counter.getIngredients(); // gets the ingredients stored on the counter

            if (!hasIngredient(ingredientsOnCounter)) { // chef has the third missing ingredient for the sushi roll
                System.out.println(chef + " is getting ingredients and forming sushi roll"); // print statement to track it
                try {
                    Thread.sleep(1000); // sleep to simulate to making a sushi roll
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(chef + " has formed a sushi roll");
                counter.incrementRollCounter(); // update the roll counter
                System.out.println("Amount of sushi rolls made: " + counter.getRollCount());
                counter.clearIngredients(); // clear the counter which signals the agent to provide new ingredients
            }
        }
    }
}
