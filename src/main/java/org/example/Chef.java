package org.example;

import java.util.List;

public class Chef implements Runnable {
    private String ingredient;

    public Chef(String ingredient){
        this.ingredient = ingredient;
    }

    public boolean hasIngredient(List<String> ingredient){
        return ingredient.contains(this.ingredient);
    }

    public void run() {
        System.out.println("This code is running in a thread");
        System.out.println(this.ingredient);
    }
}
