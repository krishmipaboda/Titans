package com.example.e_channelling;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Patient_SIGN_IN extends AppCompatActivity {

    public Button button;
    public Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_signin);

        button = (Button) findViewById(R.id.button15);
        button1 = (Button) findViewById(R.id.button14);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Patient_SIGN_IN.this,Member_Card.class);
                startActivity(intent);
            }

        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Patient_SIGN_IN.this,Patient_Dashboard.class);
                startActivity(intent);
            }

        });
    }
}