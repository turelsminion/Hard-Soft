package com.example.hardsoft;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DataClass my_data_object;
    TextView string_view;
    TextView int_view;
    TextView double_view;

    String my_double;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_data_object = new DataClass("This is a test object Lorem Ipsum", 10, 101.5);

        string_view = findViewById(R.id.string_view);
        int_view = findViewById(R.id.int_view);
        double_view = findViewById(R.id.double_view);

        string_view.setText(my_data_object.getData_string());
        int_view.setText(String.valueOf( my_data_object.getData_int() ) );
        double_view.setText(String.valueOf(my_data_object.getData_double()));
    }
}
