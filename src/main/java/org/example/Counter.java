package org.example;

import java.util.ArrayList;

public class Counter {
    private boolean isEmpty;
    private ArrayList<String> ingredients;
    private int rollCount;

    public Counter(){
        this.isEmpty = true;
        this.ingredients = new ArrayList<>();
        this.rollCount = 0;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public synchronized void clearIngredients(){
        this.ingredients.clear();
        isEmpty = true;
    }

    public synchronized ArrayList<String> getIngredients() {
        while (ingredients.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        ArrayList<String> gotIngredients = new ArrayList<>(this.ingredients);
        notifyAll();
        return gotIngredients;
    }

    public synchronized void putIngredients(ArrayList<String> addIngredients){
        while (!ingredients.isEmpty() && rollCount < 20) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.ingredients = addIngredients;
        notifyAll();
    }

    public synchronized void incrementRollCounter(){
        rollCount++;
        if (rollCount >= 20){
            notifyAll();
        }
    }

    public synchronized boolean maxRollsReached(int maxValue){
        return rollCount >= maxValue;
    }
}
