package com.example.hardsoft;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class IntroActivity extends Activity {
    Button manual_control_button;
    Button auto_control_button;
    Button code_control_button;
    TextView intro_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        manual_control_button = findViewById(R.id.manual_control_button);
        auto_control_button = findViewById(R.id.auto_control_button);
        code_control_button = findViewById(R.id.code_control_button);
        intro_text = findViewById(R.id.intro_text);
        intro_text.setText((getResources().getString(R.string.message) + getResources().getString(R.string.manual_mode_text) + getResources().getString(R.string.auto_mode_text) + getResources().getString(R.string.code_mode_text) + getResources().getString(R.string.lorem_ipsum)));

        manual_control_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main_intent = new Intent(getApplicationContext(), ManualActivity.class);
                startActivity(main_intent);
                finish();
            }
        });
        auto_control_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(IntroActivity.this, "Auto", Toast.LENGTH_SHORT).show();
            }
        });
        code_control_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent code_intent = new Intent(getApplicationContext(), CodeActivity.class);
                startActivity(code_intent);
            }
        });
    }
}
