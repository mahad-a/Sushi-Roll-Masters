package org.example;

public class Main {
    /**
     * Main
     * @param args args
     */
    public static void main(String[] args) {
        Counter counter = new Counter(); // create a counter to be shared between chef and agent

        // create the 3 chef threads, each carrying infinite of one ingredient and link them to the counter
        Thread chefThread1 = new Thread(new Chef("Rice", counter), "Chef with infinite rice");
        Thread chefThread2 = new Thread(new Chef("Nori", counter), "Chef with infinite nori");
        Thread chefThread3 = new Thread(new Chef("Filling", counter), "Chef with infinite filling");

        // start the chef threads and have them run concurrently
        chefThread1.start();
        chefThread2.start();
        chefThread3.start();

        // create the agent thread and link it to the same counter
        Thread agentThread = new Thread(new Agent(counter), "Agent");
        // start the agent thread
        agentThread.start();
    }
}