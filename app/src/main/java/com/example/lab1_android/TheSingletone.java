package com.example.lab1_android;

import android.graphics.Color;

import java.util.ArrayList;

public class TheSingletone {
    private ArrayList<HeavyItem> items = new ArrayList<HeavyItem>();
    private int colorCount = 0;

    int colorBase, colorChangeFragment1, colorChangeFragment2;

    private static TheSingletone instance;
    private TheSingletone(){
        colorBase = Color.argb(255, 214, 215, 215);
        colorChangeFragment1 = R.color.colorForwardButton;
        colorChangeFragment2 = R.color.colorBackButton;
    };
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

    public void nextColorPack(){
        colorCount++;
        if(colorCount == 4) colorCount = 0;
        switch(colorCount){
            case 0:
                colorBase = Color.argb(255, 214, 215, 215);
                //colorChangeFragment1 = R.color.colorForwardButton;
                colorChangeFragment1 = Color.argb(255, 246, 188, 16);
//                colorChangeFragment2 = R.color.colorBackButton;
                colorChangeFragment2 = Color.argb(255, 6, 193, 175);
                break;
            case 1:
                colorBase = Color.BLUE;
                colorChangeFragment1 = Color.BLUE;
                colorChangeFragment2 = Color.BLUE;
                break;
            case 2:
                colorBase = Color.GREEN;
                colorChangeFragment1 = Color.GREEN;
                colorChangeFragment2 = Color.GREEN;
                break;
            case 3:
                colorBase = Color.RED;
                colorChangeFragment1 = Color.RED;
                colorChangeFragment2 = Color.RED;
                break;
        }
    }


}
