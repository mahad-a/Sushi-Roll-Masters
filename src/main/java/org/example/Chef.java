package org.example;

public class Chef implements Runnable {
    enum Ingredient {
        Rice, Nori, Filling
    }



    public void run() {
        System.out.println("This code is running in a thread");
    }
}
