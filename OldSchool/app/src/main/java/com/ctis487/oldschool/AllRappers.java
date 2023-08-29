package com.ctis487.oldschool;

import java.util.ArrayList;

public class AllRappers {
    public static ArrayList<Rapper> allRappers = new ArrayList<>();
    public static ArrayList<String> questions = new ArrayList();

    public static void addRapper(Rapper newRapper){
        allRappers.add(newRapper);
    }

    public static Rapper getARapper(int index){
        return allRappers.get(index);
    }

    public static ArrayList getAllRappers(){
        return allRappers;
    }

    public static Rapper randomRapper(){
        int randomIndex = (int)(Math.random() * 7);
        return AllRappers.getARapper(randomIndex);
    }
}
