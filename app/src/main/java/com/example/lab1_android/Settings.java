package com.example.lab1_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class Settings extends AppCompatActivity {

    TheSingletone single;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        single = TheSingletone.getInstance();
    }
    
    //обработать RadioButton
    public void prefSetSong(View view) {

        RadioButton rad1 = (RadioButton)findViewById(R.id.butSong1);
        RadioButton rad2 = (RadioButton)findViewById(R.id.butSong2);
        RadioButton rad3 = (RadioButton)findViewById(R.id.butSong3);

        if(rad1.isChecked()){
            single.preferences.setSong("hof");
        }
        if(rad2.isChecked()){
            single.preferences.setSong("sol_invictus");
        }
        if(rad3.isChecked()){
            single.preferences.setSong("dragonborn");
        }
    }
}