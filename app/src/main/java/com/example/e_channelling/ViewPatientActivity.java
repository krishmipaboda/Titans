package com.example.e_channelling;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewPatientActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_patient);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelpClass databaseHelpClass = new DatabaseHelpClass(this);
        List<PatientModelClass> patientModelClasses = databaseHelpClass.getPatientList();

        if (patientModelClasses.size() > 0){
            PatientAdapterClass patientadapterclass = new PatientAdapterClass(patientModelClasses,ViewPatientActivity.this);
            recyclerView.setAdapter(patientadapterclass);
        }else {
            Toast.makeText(this, "There is no patient in the database", Toast.LENGTH_SHORT).show();
        }




    }
}
