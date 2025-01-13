package org.example;

public class Main {
    public static void main(String[] args) {
        Thread chefThread1 = new Thread(new Chef("Rice"), "Chef with infinite rice");
        Thread chefThread2 = new Thread(new Chef("Nori"), "Chef with infinite nori");
        Thread chefThread3 = new Thread(new Chef("Filling"), "Chef with infinite filling");
        chefThread1.start();
        chefThread2.start();
        chefThread3.start();

        Thread supplierThread = new Thread(new Supplier(), "Supplier");
        supplierThread.start();
    }
}