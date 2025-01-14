package org.example;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Chef implements Runnable {
    private String ingredient;
    private Counter counter;

    public Chef(String ingredient, Counter counter){
        this.ingredient = ingredient;
        this.counter = counter;
    }

    public boolean hasIngredient(List<String> ingredient){
        return ingredient.contains(this.ingredient);
    }

    public void run() {
        String chef = Thread.currentThread().getName();
        System.out.println(chef + " checking counter");
        ArrayList<String> ingredientsOnCounter = counter.getIngredients();
//        System.out.println("Found " + ingredientsOnCounter);

        if (!hasIngredient(ingredientsOnCounter)){
            System.out.println("Chef [" + chef + "] is getting ingredients and forming sushi roll");
            try {
                Thread.sleep(1000);  // Simulate time to make a roll
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Chef [" + chef + "] has formed a sushi roll");
        } else {
            System.out.println("Chef [" + chef + "] is waiting for missing ingredients");
        }
    }
}
