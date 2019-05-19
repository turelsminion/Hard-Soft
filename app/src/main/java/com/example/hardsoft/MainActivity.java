package com.example.hardsoft;

import android.service.notification.StatusBarNotification;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DataClass my_data_object;
    TextView string_view;
    TextView int_view;
    TextView double_view;
    Button but1;
    ProgressBar victor;
    Button daniel_echipa_adversa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        my_data_object = new DataClass("hello", 10, 101.5);
        string_view = findViewById(R.id.string_view);
        int_view = findViewById(R.id.int_view);
        double_view = findViewById(R.id.float_view);
        but1=findViewById(R.id.button);
        victor = findViewById(R.id.progressBar2);
        daniel_echipa_adversa = findViewById(R.id.button2);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                victor.incrementProgressBy(10);
                if(victor.getProgress() > 50)
                {
                    string_view.setText("Victor win");
                }
                else
                {
                    string_view.setText("Daniel win");
                }
            }

        });



        daniel_echipa_adversa.setOnClickListener(new View.OnClickListener() {
                                                     @Override
                                                     public void onClick(View v) {
                                                         victor.incrementProgressBy(-10);
                                                         if(victor.getProgress() > 50)
                                                         {
                                                             string_view.setText("Victor win");
                                                         }
                                                         else
                                                         {
                                                             string_view.setText("Daniel win");
                                                         }
                                                     }
                                                 }


        );
    }
}
