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
        while (isEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        ArrayList<String> gotIngredients = new ArrayList<>(this.ingredients);
        this.ingredients = new ArrayList<>();
        isEmpty = true;
        notifyAll();
        return gotIngredients;
    }

    public synchronized void putIngredients(ArrayList<String> addIngredients){
        while (!isEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.ingredients = new ArrayList<>(addIngredients);
        isEmpty = false;
//        System.out.println("Supplier added: " + ingredients);
        notifyAll();
    }
}
