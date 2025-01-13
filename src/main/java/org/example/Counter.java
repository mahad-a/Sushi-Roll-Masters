package org.example;

import java.util.ArrayList;

public class Counter {
    private boolean isEmpty;
    private ArrayList<String> ingredients;
    public Counter(){
        this.isEmpty = true;
        this.ingredients = new ArrayList<>();
    }

    public ArrayList<String> getIngredients() {
        while (isEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        ArrayList<String> gotIngredients = this.ingredients;
        this.ingredients.clear();
        notifyAll();
        return gotIngredients;
    }

    public void putIngredients(ArrayList<String> addIngredients){
        while (!isEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.ingredients = addIngredients;
        isEmpty = false;
        notifyAll();
    }
}
