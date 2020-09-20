package com.example.lab1_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.zip.Inflater;

    public class MainActivity extends AppCompatActivity{

    protected ArrayList<HeavyItem> items = new ArrayList<HeavyItem>();
    static boolean musicFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SQLiteDatabase db = getBaseContext().openOrCreateDatabase("strong.db",MODE_PRIVATE, null);

        TheSingletone singleList = TheSingletone.getInstance();
        singleList.setBaseAppContext(this);
        singleList.openOrCreateDB();

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
                Intent additional_task = new Intent(this, additional.class);
                startActivity(additional_task);
                return true;
            case R.id.save_settings:

                    Intent playerIntent = new Intent(this, MusicPlayer.class);
                    if(!musicFlag) {
                        startService(playerIntent);
                        musicFlag = true;
                    }
                    else{
                        stopService(playerIntent);
                        musicFlag = false;
                    }
                return true;
            case R.id.settings:
                Intent settings = new Intent(this, Settings.class);
                startActivity(settings);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}