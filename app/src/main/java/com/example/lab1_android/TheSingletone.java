package com.example.lab1_android;

import java.util.ArrayList;

public class TheSingletone {
    private ArrayList<HeavyItem> items = new ArrayList<HeavyItem>();

    private static TheSingletone instance;
    private TheSingletone(){};
    public static  TheSingletone getInstance(){
        if(instance == null){
            instance = new TheSingletone();
        }
        return instance;
    }
    public void addListItem(HeavyItem item){
        items.add(item);
    }
    public void addListItem(double op1, double op2, char operation, double result){
        items.add(new HeavyItem(op1, op2, operation, result));
    }
    public ArrayList<HeavyItem> getList(){
        return items;
    }


}
