package org.example;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread chefThread1 = new Thread(new Chef("Rice", counter), "Chef with infinite rice");
        Thread chefThread2 = new Thread(new Chef("Nori", counter), "Chef with infinite nori");
        Thread chefThread3 = new Thread(new Chef("Filling", counter), "Chef with infinite filling");

        chefThread1.start();
        chefThread2.start();
        chefThread3.start();


        Thread supplierThread = new Thread(new Supplier(counter), "Supplier");
        supplierThread.start();
    }
}