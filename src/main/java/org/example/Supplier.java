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
        while (!counter.maxRollsReached(20)) {
            ArrayList<String> list = selectIngredients();

            if (counter.isEmpty()) {
                counter.putIngredients(list);
                System.out.println("Supplier placing on counter: " + list);
            }

            try {
                Thread.sleep(5000);  // Simulate time to make a roll
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
