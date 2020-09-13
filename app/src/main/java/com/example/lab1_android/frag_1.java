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

public class frag_1 extends Fragment implements DataInterface {
    Activity activity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        /////



        final TheSingletone singleList = TheSingletone.getInstance();
        final EditText input_num1 = view.findViewById(R.id.input_num1);
        final EditText input_num2 = view.findViewById(R.id.input_num2);
        final TextView tv_result = view.findViewById(R.id.textView_result);
        final RadioButton radio_addition = view.findViewById(R.id.radio_addition);
        final RadioButton radio_multiplying = view.findViewById(R.id.radio_multiplying);
        final TextView tv1;
        final TextView tv2;

        int screenSizeMask = (getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK);
        LinearLayout layout = view.findViewById(R.id.frag1_layout);
        if(screenSizeMask == Configuration.SCREENLAYOUT_SIZE_NORMAL &&
        view.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            layout.setOrientation(LinearLayout.HORIZONTAL);
        }
        else
            layout.setOrientation(LinearLayout.VERTICAL);

        if(screenSizeMask == Configuration.SCREENLAYOUT_SIZE_NORMAL){
            tv1 = view.findViewById(R.id.textView);
             tv2 = view.findViewById(R.id.textView2);
             tv1.setTextSize(16);
             tv2.setTextSize(16);
             tv_result.setTextSize(16);
        }

        Button button_submit = view.findViewById(R.id.button_calculate);

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s_op1 = input_num1.getText().toString();
                String s_op2 = input_num2.getText().toString();
                double op1, op2;
                if(!(s_op1.matches("")) && !(s_op1.matches("")) &&
                        (radio_addition.isChecked() || radio_multiplying.isChecked())) {
                    op1 = Float.parseFloat(s_op1);
                    op2 = Float.parseFloat(s_op2);
                    double res;
                    if(radio_addition.isChecked()){
                        res = op1+op2;
                        tv_result.setText( String.valueOf(op1+op2));
                        Toast.makeText(view.getContext(), String.valueOf(op1+op2), Toast.LENGTH_SHORT).show();
                        singleList.addListItem(op1, op2,  '+', res);
                    }
                    else{
                        res = op1*op2;
                        tv_result.setText(String.valueOf(op1*op2));
                        Toast.makeText(view.getContext(), String.valueOf(op1*op2), Toast.LENGTH_SHORT).show();
                        singleList.addListItem(op1, op2,  '*', res);
                    }
                }
                else{
                    Toast.makeText(view.getContext(),"Fill in all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof Activity){
            activity = (Activity) context;
        }
    }

    @Override
    public void sendData(HeavyItem item) {}

    private void addListItem(double op1, double op2, double res, char operation){
        HeavyItem item = new HeavyItem(op1, op2, operation, res);
        try{
            ((DataInterface)activity).sendData(item);
        }
        catch(ClassCastException ignored){}
    }
}
