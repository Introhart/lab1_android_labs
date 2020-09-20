package com.example.lab1_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class additional extends AppCompatActivity {
    final TheSingletone singleList = TheSingletone.getInstance();
    frag_1 fr1;
    frag_2 fr2;
    Button btnChange, btnChangeColor;
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional);

        fr1 = new frag_1();
        fr2 = new frag_2();
        btnChange = (Button)findViewById(R.id.button_change);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.FrameAddit, fr1);
        transaction.commit();

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft = fm.beginTransaction();
                if(flag)
                {
                    ft.replace(R.id.FrameAddit, fr2);
                    flag = false;
                }
                else
                {
                    ft.replace(R.id.FrameAddit, fr1);
                    flag = true;
                }
                ft.commit();
            }
        });

        btnChangeColor = (Button) findViewById(R.id.button_changeColor);
        btnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                singleList.nextColorPack();
                if(flag) fr1.chv();
                else fr2.chv();
                btnChange.setBackgroundColor(singleList.colorBase);
                btnChangeColor.setBackgroundColor(singleList.colorBase);
            }
        });

    }
}