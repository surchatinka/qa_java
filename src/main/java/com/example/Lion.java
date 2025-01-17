package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    private final Predator predator;

    public Lion(Predator predator,String sex) throws Exception {
        this.predator = predator;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - Самец или Самка");
        }
    }

    //Feline feline = new Feline();

    public int getKittens() {
        return predator.getKittens();
        //return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
        //return feline.getFood("Хищник");
    }
}
