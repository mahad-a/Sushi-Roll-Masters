package org.example;

import java.util.*;

public class Supplier implements Runnable{
    private static final List<String> ingredients = List.of("Rice", "Nori", "Filling");
    private Random random = new Random();
    public Supplier(){

    }

    public List<String> selectIngredients(){
        List<String> tempIngredients = new ArrayList<>(ingredients);
        tempIngredients.remove(random.nextInt(tempIngredients.size()));
        return tempIngredients;
    }

    public void run() {

    }
}
