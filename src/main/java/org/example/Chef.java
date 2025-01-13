package org.example;

public class Chef implements Runnable {
//    enum Ingredient {
//        Rice, Nori, Filling
//    }

    private String ingredient;

    public Chef(String ingredient){
        this.ingredient = ingredient;
    }

    public void run() {
        System.out.println("This code is running in a thread");
        System.out.println(this.ingredient);
    }

    public static void main(String[] args) {
        Thread chefThread1 = new Thread(new Chef("Rice"), "Chef with infinite rice");
        Thread chefThread2 = new Thread(new Chef("Nori"), "Chef with infinite nori");
        Thread chefThread3 = new Thread(new Chef("Filling"), "Chef with infinite filling");
        chefThread1.start();
        chefThread2.start();
        chefThread3.start();
    }
}
