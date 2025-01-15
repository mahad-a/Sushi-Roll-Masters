package org.example;

import java.util.ArrayList;

/**
 * Counter class, representing the counter in which the agent places
 * the ingredients and chef gets them
 */
public class Counter {
    private boolean isEmpty;
    private ArrayList<String> ingredients;
    private int rollCount;

    /**
     * Counter constructor
     */
    public Counter(){
        this.isEmpty = true;
        this.ingredients = new ArrayList<>();
        this.rollCount = 0; // no sushi rolls are made yet
    }

    /**
     * Checks if the counter is empty (no ingredients)
     * @return status of the counter
     */
    public boolean isEmpty() {
        return isEmpty;
    }

    public int getRollCount() {
        return rollCount;
    }

    /**
     * Clears the counter of all ingredients
     */
    public synchronized void clearIngredients(){
        this.ingredients.clear();
        isEmpty = true; // re-set the empty flag
    }

    /**
     * Gets the ingredients currently on the counter
     * @return the ingredients found on the counter
     */
    public synchronized ArrayList<String> getIngredients() {
        while (ingredients.isEmpty()) { // can't grab ingredients from an empty counter
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        ArrayList<String> gotIngredients = new ArrayList<>(this.ingredients);
        notifyAll(); // notify all threads that ingredients were grabbed from counter
        return gotIngredients;
    }

    /**
     * Place ingredients on the counter
     * @param addIngredients the ingredients to be put on the counter
     */
    public synchronized void putIngredients(ArrayList<String> addIngredients){
        // ensure that no ingredients are being placed once 20 sushi rolls are reached
        while (!ingredients.isEmpty() && rollCount < 20) { // prevent overwriting to the counter
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.ingredients = addIngredients; // new ingredients list added to the counter
        notifyAll(); // notify all threads that new ingredients were placed on the counter
    }

    /**
     * Increment the roll counter whenever a sushi roll is made
     */
    public synchronized void incrementRollCounter(){
        rollCount++;
        if (rollCount >= 20){
            notifyAll(); // notify all threads that 20 rolls has been reached
        }
    }

    /**
     * Checks if the maximum sushi rolls have been reached
     * @param maxValue the maximum amount of sushi rolls to create
     * @return whether the maximum has been reached or not
     */
    public synchronized boolean maxRollsReached(int maxValue){
        return rollCount >= maxValue;
    }
}
