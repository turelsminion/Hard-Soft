package com.example.hardsoft;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CodeActivity extends Activity {
    ArrayList<String> commands = new ArrayList<>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference my_data_ref = database.getReference();
    final DatabaseReference weather_temperature = my_data_ref.child("weather").child("temperature");
    final DatabaseReference weather_pressure = my_data_ref.child("weather").child("pressure");
    final DatabaseReference weather_humidity = my_data_ref.child("weather").child("humidity");
    final DatabaseReference direction = my_data_ref.child("direction");

    //move
    Button go_front_button;
    Button go_back_button;
    Button go_left_button;
    Button go_right_button;
    //actions
    Button measure_temp;
    Button measure_pressure;
    Button measure_humidity;
    Button execute;
    Button remove_command;
    Button clear_commands;
    Button stop;
    ImageButton my_back_to_menu_button;
    //text view
    TextView commands_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
        //move
        go_front_button = findViewById(R.id.go_front_button);
        go_back_button = findViewById(R.id.go_back_button);
        go_left_button = findViewById(R.id.go_left_button);
        go_right_button = findViewById(R.id.go_right_button);
        //actions
        measure_temp = findViewById(R.id.measure_temp);
        measure_pressure = findViewById(R.id.measure_pressure);
        measure_humidity = findViewById(R.id.measure_humidity);
        my_back_to_menu_button = findViewById(R.id.my_back_to_menu_button);
        execute = findViewById(R.id.execute);
        remove_command = findViewById(R.id.remove_command);
        clear_commands = findViewById(R.id.clear_commands);
        stop = findViewById(R.id.stop);
        //Text view
        commands_text = findViewById(R.id.commands_text);

        //Setting button events
        go_front_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commands.add("goFront");
            }
        });
        go_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commands.add("goBack");
            }
        });
        go_left_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commands.add("goLeft");
            }
        });
        go_right_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commands.add("goRight");
            }
        });
        measure_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CodeActivity.this, "measure_temp", Toast.LENGTH_SHORT).show();
            }
        });
        measure_pressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CodeActivity.this, "measure_pressure", Toast.LENGTH_SHORT).show();
            }
        });
        measure_humidity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CodeActivity.this, "measure_humidity", Toast.LENGTH_SHORT).show();
            }
        });
        execute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CodeActivity.this, "execute", Toast.LENGTH_SHORT).show();
            }
        });
        remove_command.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CodeActivity.this, "remove_command", Toast.LENGTH_SHORT).show();
            }
        });
        clear_commands.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CodeActivity.this, "clear_commands", Toast.LENGTH_SHORT).show();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CodeActivity.this, "stop", Toast.LENGTH_SHORT).show();
            }
        });

        my_back_to_menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intro_intent = new Intent(getApplicationContext(), IntroActivity.class);
                startActivity(intro_intent);
                finish();
            }
        });

        for (String s : commands){

        }

    }
}
