package org.example;

import java.util.*;

public class Supplier implements Runnable{
    private static final List<String> ingredients = List.of("Rice", "Nori", "Filling");
    private Random random = new Random();
    private Counter counter;
    private int index = 0;

    public Supplier(Counter counter){
        this.counter = counter;
    }

    public ArrayList<String> selectIngredients(){
        ArrayList<String> tempIngredients = new ArrayList<>(ingredients);
        tempIngredients.remove(random.nextInt(tempIngredients.size()));
        return tempIngredients;
    }

    public void run() {

        while (index < 20) {
            if (counter.isEmpty()) {
                ArrayList<String> list = selectIngredients();
                counter.putIngredients(list);
                index++;
            }
        }
    }
}
