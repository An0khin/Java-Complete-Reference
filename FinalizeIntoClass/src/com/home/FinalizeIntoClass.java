package com.home;

public class FinalizeIntoClass {
    public static void main(String[] args) {
        RandomClass rc1 = new RandomClass();
        rc1.init();
        RandomClass rc2 = new RandomClass();
        rc2.init();
        rc2 = null;
        System.gc(); //Invoking Garbage Collector
    }
}
