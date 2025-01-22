package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Agent class, representing an agent, agent randomly generates 2 ingredients
 * from a list of 3 then places them on the counter
 */
public class Agent implements Runnable{
    private static final List<String> ingredients = List.of("Rice", "Nori", "Filling");
    private Random random = new Random();
    private Counter counter;

    /**
     * Agent constructor
     * @param counter the counter where agent places list of the ingredients available for creation of sushi roll
     */
    public Agent(Counter counter){
        this.counter = counter;
    }

    /**
     * Randomly select 2 ingredients from a list of 3 ingredients to be placed on the counter for the sushi chefs
     * @return the 2 ingredients chosen
     */
    public ArrayList<String> selectIngredients(){
        ArrayList<String> tempIngredients = new ArrayList<>(ingredients);
        // easier to remove one element at random from list of ingredients
        // than generate 2 random indexes and make them different from each other
        tempIngredients.remove(random.nextInt(tempIngredients.size()));
        return tempIngredients;
    }

    /**
     * Runs the agent thread, stops when 20 sushi rolls are made
     */
    public void run() {
        while (!counter.maxRollsReached(20)) {
            ArrayList<String> list = selectIngredients();

            if (counter.isEmpty()) { // check if the counter is empty before placing ingredients
                System.out.println("Agent placing on counter: " + list);
                counter.putIngredients(list);
            } // counter has something on it, so sleep and check again

            try { // sleep while counter is occupied
                Thread.sleep(3000); // check counter again after time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
