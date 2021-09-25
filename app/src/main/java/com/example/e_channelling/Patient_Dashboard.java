package com.example.e_channelling;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Patient_Dashboard extends AppCompatActivity {
    public Button button;
    public Button button1;
    public Button button2;
    public Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patientdashboard);

        button = (Button) findViewById(R.id.button5);
        button1 = (Button) findViewById(R.id.button6);
        button2 = (Button) findViewById(R.id.button7);
        button3 = (Button) findViewById(R.id.button8);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Patient_Dashboard.this,Patient_Details.class);
                startActivity(intent);
            }

        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Patient_Dashboard.this,Select_Doctor.class);
                startActivity(intent);
            }

        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Patient_Dashboard.this,Feedback.class);
                startActivity(intent);
            }

        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Patient_Dashboard.this,ViewPatientActivity.class);
                startActivity(intent);
            }

        });
    }
}