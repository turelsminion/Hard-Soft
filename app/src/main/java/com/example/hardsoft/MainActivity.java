package com.example.hardsoft;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DataClass my_data_object;
    TextView string_view;
    TextView int_view;
    TextView double_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        my_data_object = new DataClass("hello", 10, 101.5);
        string_view = findViewById(R.id.string_view);
        int_view = findViewById(R.id.int_view);
        double_view = findViewById(R.id.float_view);
    }
}
