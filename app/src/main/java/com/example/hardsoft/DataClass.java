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

    public int getData_int() {
        return data_int;
    }

    public double getData_double() {
        return data_double;
    }
}
