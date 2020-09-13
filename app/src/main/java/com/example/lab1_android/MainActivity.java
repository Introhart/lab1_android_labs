package com.example.lab1_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

    public class MainActivity extends AppCompatActivity{

    protected ArrayList<HeavyItem> items = new ArrayList<HeavyItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TheSingletone singleList = TheSingletone.getInstance();


        Button button;

        int screenSizeMask = (getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK);
        if( screenSizeMask == Configuration.SCREENLAYOUT_SIZE_LARGE ||
                screenSizeMask == Configuration.SCREENLAYOUT_SIZE_NORMAL
        ){
            button = (Button)findViewById(R.id.button_goForward);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getBaseContext(), SecondActivity.class);
                    startActivity(intent);
                }
            });

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.action_settings:
                Intent intent = new Intent(this, activity_lisr.class);

                startActivity(intent);
                return true;
            case R.id.open_settings:
                Toast.makeText(getApplicationContext(),"second", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.save_settings:
                Toast.makeText(getApplicationContext(),"third", Toast.LENGTH_SHORT).show();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

}