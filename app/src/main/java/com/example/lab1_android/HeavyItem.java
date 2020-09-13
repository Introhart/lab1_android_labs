package com.example.lab1_android;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class HeavyItem implements Serializable {
    private double op1;
    private double op2;
    private char operation;
    private double result;

    public HeavyItem(double op1, double op2, char operation, double result){
        this.op1 = op1;
        this.op2 = op2;
        this.operation = operation;
        this.result = result;
    }

    public double getOp1(){ return op1; }
    public double getOp2(){ return op2; }
    public char getOperation(){ return operation; }
    public double getResult() { return result; }

}
