package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class Main33Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main33);
    }

        public void medicine1(View view){ startActivity(new Intent(this,MainActivity.class  )); }
        public void lab1(View view){ startActivity(new Intent(this,MainActivity22.class  )); }
}