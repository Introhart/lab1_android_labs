package com.example.lab1_android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
public class frag_2 extends Fragment{
    Button button_submit;
    TheSingletone singleList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        ///
        singleList = TheSingletone.getInstance();
        final EditText input_num1 = view.findViewById(R.id.input_1);
        final EditText input_num2 = view.findViewById(R.id.input_2);
        final TextView tv_result = view.findViewById(R.id.Result_frag2);
        final RadioButton radio_substraction= view.findViewById(R.id.radio_substraction_frag2);
        final RadioButton radio_division = view.findViewById(R.id.radio_division_frag2);
        final TextView tv3;
        final TextView tv4;

        int screenSizeMask = (getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK);
        LinearLayout layout = view.findViewById(R.id.frag2_layout);
        if(screenSizeMask == Configuration.SCREENLAYOUT_SIZE_NORMAL &&
                view.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            layout.setOrientation(LinearLayout.HORIZONTAL);
        }
        else
            layout.setOrientation(LinearLayout.VERTICAL);


        if(screenSizeMask == Configuration.SCREENLAYOUT_SIZE_NORMAL){
            tv3 = view.findViewById(R.id.textView3);
            tv4 = view.findViewById(R.id.textView4);
            tv3.setTextSize(16);
            tv4.setTextSize(16);
            tv_result.setTextSize(16);
        }


        button_submit = view.findViewById(R.id.calculate_frag2);

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s_op1 = input_num1.getText().toString();
                String s_op2 = input_num2.getText().toString();
                float op1, op2;
                if(!(s_op1.matches("")) && !(s_op1.matches("")) &&
                        (radio_substraction.isChecked() || radio_division.isChecked())) {
                    op1 = Float.parseFloat(s_op1);
                    op2 = Float.parseFloat(s_op2);

                    if(radio_substraction.isChecked()){
                        double res = op1 - op2;
                        tv_result.setText(String.valueOf(op1-op2));
                        Toast.makeText(view.getContext(),String.valueOf(op1-op2), Toast.LENGTH_SHORT).show();
                        singleList.addListItem(op1, op2,  '-', res);
                    }
                    else{
                        double res = op1 / op2;
                        tv_result.setText(String.valueOf(op1/op2));
                        Toast.makeText(view.getContext(),String.valueOf(op1/op2), Toast.LENGTH_SHORT).show();
                        singleList.addListItem(op1, op2,  '/', res);
                    }
                }
                else{
                    Toast.makeText(view.getContext(),"Fill in all the fields", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return view;
    }

    public void chv()
    {
        //Toast.makeText(this.getContext(),"ChangeButtonColor()_2", Toast.LENGTH_SHORT).show();
        button_submit.setBackgroundColor(singleList.colorChangeFragment2);
    }
}
