package com.example.lab1_android;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class TheSingletone {
    private ArrayList<HeavyItem> items = new ArrayList<HeavyItem>();
    private int colorCount = 0;
    public PreferenceHandler preferences;
    Activity context;

    int colorBase, colorChangeFragment1, colorChangeFragment2;

    private static TheSingletone instance;
    private TheSingletone(){
        colorBase = Color.argb(255, 214, 215, 215);
        colorChangeFragment1 = R.color.colorForwardButton;
        colorChangeFragment2 = R.color.colorBackButton;
        preferences = new PreferenceHandler();

    };
    public static  TheSingletone getInstance(){
        if(instance == null){
            instance = new TheSingletone();

        }
        return instance;
    }
    public void addListItem(HeavyItem item){
        items.add(item);
        //addItemToDB(item);
    }
    public void addListItem(double op1, double op2, char operation, double result){
        items.add(new HeavyItem(op1, op2, operation, result));
        addItemToDB(new HeavyItem(op1,op2,operation, result));
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


    public void openOrCreateDB(){
        SQLiteDatabase db = context.openOrCreateDatabase("strong.db",MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS items (op1 REAL, op2 REAL, operation TEXT, result REAL)");
        Cursor query = db.rawQuery("SELECT * FROM items", null);
        if(query.moveToFirst()){
            do{
                double _op1 = query.getDouble(0);
                double _op2 = query.getDouble(1);
                String _operation = query.getString(2);
                double _result = query.getDouble(3);

                HeavyItem db_item = new HeavyItem(_op1, _op2, _operation.charAt(0), _result);
                items.add(db_item);

            }while(query.moveToNext());
        }
        query.close();
        db.close();
    }


    public void addItemToDB(HeavyItem item){
        SQLiteDatabase db = context.openOrCreateDatabase("strong.db",MODE_PRIVATE, null);

        ContentValues insertValues = new ContentValues();
        insertValues.put("op1", item.getOp1());
        insertValues.put("op2", item.getOp2());
        insertValues.put("operation", Character.toString(item.getOperation()));
        insertValues.put("result", item.getResult());

        db.insert("items", null, insertValues);
        db.close();
    }

    public void setBaseAppContext(Activity context) {
        this.context = context;
    }



    public class PreferenceHandler{
        private SharedPreferences sPref;
        private int colorTheme;
        private String song;

        PreferenceHandler(){}

        public void setSong(String songName){
            sPref = context.getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor ed = sPref.edit();
            ed.putString("song_name", songName);
            ed.commit();
            Toast.makeText(context, songName, Toast.LENGTH_SHORT).show();
        }


        public String getSong(){
                sPref = context.getPreferences(MODE_PRIVATE);
                String song = sPref.getString("song_name","hof");
            return song;
        }

    }
}
