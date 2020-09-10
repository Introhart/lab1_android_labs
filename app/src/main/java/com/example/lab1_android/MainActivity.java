package com.example.lab1_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}