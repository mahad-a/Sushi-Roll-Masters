package org.example;

import java.util.ArrayList;

public class Counter {
    private boolean isEmpty;
    private ArrayList<String> ingredients;

    public Counter(){
        this.isEmpty = true;
        this.ingredients = new ArrayList<>();
    }

    public boolean isEmpty() {
        return isEmpty;
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
        this.ingredients.clear();
//        isEmpty = true;
        notifyAll();
        return gotIngredients;
    }

    public synchronized void putIngredients(ArrayList<String> addIngredients){
        while (!ingredients.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.ingredients = addIngredients;
//        isEmpty = false;
        notifyAll();
    }
}
