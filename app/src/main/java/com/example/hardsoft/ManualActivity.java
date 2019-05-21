package com.example.hardsoft;

import android.content.Intent;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ManualActivity extends AppCompatActivity {
    private Vibrator myVib;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference my_data_ref = database.getReference();
    final DatabaseReference weather_temperature = my_data_ref.child("weather").child("temperature");
    final DatabaseReference weather_pressure = my_data_ref.child("weather").child("pressure");
    final DatabaseReference weather_humidity = my_data_ref.child("weather").child("humidity");
    final DatabaseReference direction = my_data_ref.child("direction");

    Switch vibration_switch;

    TextView temperature_view;
    TextView pressure_view;
    TextView humidity_view;
    TextView direction_view;
    TextView action_view;

    ImageButton up;
    ImageButton down;
    ImageButton left;
    ImageButton right;
    ImageButton action1;
    ImageButton action2;
    ImageButton action3;
    ImageButton back_to_menu_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        direction.setValue(0);
        setContentView(R.layout.activity_manual);

        //Vibration switch
        myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
        vibration_switch = findViewById(R.id.vibration_switch);
        vibration_switch.setChecked(false);

        //View binding
        temperature_view = findViewById(R.id.temperature_view);
        pressure_view = findViewById(R.id.pressure_view);
        humidity_view = findViewById(R.id.humidity_view);
        direction_view = findViewById(R.id.direction_view);

        //Button binding
        up = findViewById(R.id.up);
        down = findViewById(R.id.down);
        left = findViewById(R.id.left);
        right = findViewById(R.id.right);
        action1 = findViewById(R.id.action1);
        action2 = findViewById(R.id.action2);
        action3 = findViewById(R.id.action3);
        back_to_menu_button = findViewById(R.id.back_to_menu_button);

        //Set view text
        weather_temperature.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Double value = dataSnapshot.getValue(Double.class);
                temperature_view.setText("temperature : " + value.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                databaseError.getCode();
            }
        });
        weather_pressure.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Double value = dataSnapshot.getValue(Double.class);
                pressure_view.setText("pressure : " + value.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                databaseError.getCode();
            }
        });
        weather_humidity.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Double value = dataSnapshot.getValue(Double.class);
                humidity_view.setText("humidity : " + value.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                databaseError.getCode();
            }
        });
        direction.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Integer value = dataSnapshot.getValue(Integer.class);
                if (value == 0){
                    direction_view.setText("direction : " + "none");
                }
                if (value == 1){
                    direction_view.setText("direction : " + "up");
                }
                if (value == 2){
                    direction_view.setText("direction : " + "right");
                }
                if (value == 3){
                    direction_view.setText("direction : " + "down");
                }
                if (value == 4){
                    direction_view.setText("direction : " + "left");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                databaseError.getCode();
            }
        });

        //Setting button events
        back_to_menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vibration_switch.isChecked()){
                    myVib.vibrate(50);
                }
                Intent intro_intent = new Intent(getApplicationContext(), IntroActivity.class);
                startActivity(intro_intent);
                finish();
            }
        });

        up.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    if (vibration_switch.isChecked()){
                        myVib.vibrate(50);
                    }
                    direction.setValue(1);
                    return true;
                }
                else if (event.getAction() == MotionEvent.ACTION_UP) {
                    direction.setValue(0);
                    return true;
                }
                return false;
            }
        });

        down.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    if (vibration_switch.isChecked()){
                        myVib.vibrate(50);
                    }
                    direction.setValue(3);
                    return true;
                }
                else if (event.getAction() == MotionEvent.ACTION_UP) {
                    direction.setValue(0);
                    return true;
                }
                return false;
            }
        });

        left.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    if (vibration_switch.isChecked()){
                        myVib.vibrate(50);
                    }
                    direction.setValue(4);
                    return true;
                }
                else if (event.getAction() == MotionEvent.ACTION_UP) {
                    direction.setValue(0);
                    return true;
                }
                return false;
            }
        });

        right.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    if (vibration_switch.isChecked()){
                        myVib.vibrate(50);
                    }
                    direction.setValue(2);
                    return true;
                }
                else if (event.getAction() == MotionEvent.ACTION_UP) {
                    direction.setValue(0);
                    return true;
                }
                return false;
            }
        });

        action1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    if (vibration_switch.isChecked()){
                        myVib.vibrate(50);
                    }
                    direction.setValue(5);
                    return true;
                }
                else if (event.getAction() == MotionEvent.ACTION_UP) {
                    direction.setValue(0);
                    return true;
                }
                return false;
            }
        });

        action2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    if (vibration_switch.isChecked()){
                        myVib.vibrate(50);
                    }
                    direction.setValue(6);
                    return true;
                }
                else if (event.getAction() == MotionEvent.ACTION_UP) {
                    direction.setValue(0);
                    return true;
                }
                return false;
            }
        });

        action3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    if (vibration_switch.isChecked()){
                        myVib.vibrate(50);
                    }
                    direction.setValue(7);
                    return true;
                }
                else if (event.getAction() == MotionEvent.ACTION_UP) {
                    direction.setValue(0);
                    return true;
                }
                return false;
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        direction.setValue(0);
    }

    @Override
    protected void onStop() {
        super.onStop();
        direction.setValue(0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        direction.setValue(0);
    }
}
