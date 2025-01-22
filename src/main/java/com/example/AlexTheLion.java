package com.example;
import java.util.List;

public class AlexTheLion extends Lion{

    public AlexTheLion(Predator predator) throws Exception {
        super(predator,"Самец");
    }

    public List<String> getFriends(){
        return List.of("Марти","Глория","Мелман","Джулиан Тринадцатый");
    }

    public String getPlaceOfLiving(){
        return "Нью-Йоркский зоопарк";
    }
    @Override
    public int getKittens() {
        return 0;
    }

}
