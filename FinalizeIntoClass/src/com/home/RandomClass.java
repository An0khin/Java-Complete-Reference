package com.home;

public class RandomClass {
    public void init() {
        System.out.println("Hi");
    }
    @Override
    protected void finalize() {
        System.out.println("Nooooooo, I am deleting");
    }
}
