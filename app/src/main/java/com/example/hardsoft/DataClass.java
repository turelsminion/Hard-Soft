package com.example.hardsoft;

public class DataClass {
    private String data_string;
    private int data_int;
    private double data_double;

    public DataClass(String data_string, int data_int, double data_double) {
        this.data_string = data_string;
        this.data_int = data_int;
        this.data_double = data_double;
    }

    public String getData_string() {
        return data_string;
    }

    public void setData_string(String data_string) {
        this.data_string = data_string;
    }

    public int getData_int() {
        return data_int;
    }

    public void setData_int(int data_int) {
        this.data_int = data_int;
    }

    public double getData_float() {
        return data_double;
    }

    public void setData_float(float data_float) {
        this.data_double = data_float;
    }
}
