package com.example.lab1_android;

import androidx.appcompat.app.AppCompatActivity;

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

        final EditText input_num1 = findViewById(R.id.input_num1);
        final EditText input_num2 = findViewById(R.id.input_num2);
        final TextView tv_result = findViewById(R.id.textView_result);
        final RadioButton radio_addition = findViewById(R.id.radio_addition);
        final RadioButton radio_multiplying = findViewById(R.id.radio_multiplying);
        Button button_submit = findViewById(R.id.button_calculate);

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s_op1 = input_num1.getText().toString();
                String s_op2 = input_num2.getText().toString();
                float op1, op2;

                if(!(s_op1.matches("")) && !(s_op1.matches("")) &&
                        (radio_addition.isChecked() || radio_multiplying.isChecked())) {
                    op1 = Float.parseFloat(s_op1);
                    op2 = Float.parseFloat(s_op2);

                    if(radio_addition.isChecked()){
                        tv_result.setText(String.valueOf(op1+op2));
                        Toast.makeText(getApplicationContext(),String.valueOf(op1+op2), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        tv_result.setText(String.valueOf(op1*op2));
                        Toast.makeText(getApplicationContext(),String.valueOf(op1*op2), Toast.LENGTH_SHORT).show();
                    }


                }
                else{
                    Toast.makeText(getApplicationContext(),"Fill in all the fields", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}