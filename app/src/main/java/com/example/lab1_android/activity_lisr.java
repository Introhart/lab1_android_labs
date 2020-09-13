package com.example.lab1_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.LauncherActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class activity_lisr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lisr);

        TheSingletone singleList = TheSingletone.getInstance();

        ListView listView = (ListView)findViewById(R.id.list_of_the_cruel);

        CustomStrongAdapter CSA = new CustomStrongAdapter(this, singleList.getList());
        listView.setAdapter(CSA);

    }


}