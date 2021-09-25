package com.example.e_channelling;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Feedback extends AppCompatActivity {
    public Button button;
    public Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);

        button = (Button) findViewById(R.id.button13);
        button1 = (Button) findViewById(R.id.button12);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Feedback.this,Patient_Dashboard.class);
                startActivity(intent);
            }

        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Feedback.this,Patient_Dashboard.class);
                startActivity(intent);
            }

        });
    }
}
