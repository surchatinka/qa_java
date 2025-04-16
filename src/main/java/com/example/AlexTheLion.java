package com.example;
import java.util.List;

public class AlexTheLion extends Lion{

    public AlexTheLion(Feline feline) throws Exception {
        super(feline,"Самец");
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
