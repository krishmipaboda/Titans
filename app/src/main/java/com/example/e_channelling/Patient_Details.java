package com.example.e_channelling;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Patient_Details extends AppCompatActivity {

    EditText editText_firstname,editText_lastname,editText_email,editText_contact,editText_age;
    Button button_add,button_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patientdetails);

        editText_firstname = findViewById(R.id.edittext_firstname);
        editText_lastname = findViewById(R.id.edittext_lastname);
        editText_email = findViewById(R.id.edittext_email);
        editText_contact = findViewById(R.id.edittext_contact);
        editText_age = findViewById(R.id.edittext_age);


        button_add = findViewById(R.id.button_add);
        button_view = findViewById(R.id.button_view);


        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringFirstname = editText_firstname.getText().toString();
                String stringLastname = editText_lastname.getText().toString();
                String stringEmail = editText_email.getText().toString();
                String stringContact = editText_contact.getText().toString();
                String stringAge = editText_age.getText().toString();



                if (stringFirstname.length() <=0 || stringLastname.length() <=0 ||stringEmail.length() <=0||stringContact.length() <=0||stringAge.length() <=0  ){
                    Toast.makeText(Patient_Details.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }else {
                    DatabaseHelpClass databaseHelpClass = new DatabaseHelpClass(Patient_Details.this);
                    PatientModelClass patientModelClass = new PatientModelClass(stringFirstname,stringLastname,stringEmail,stringContact,stringAge);
                    databaseHelpClass.addPatient(patientModelClass);
                    Toast.makeText(Patient_Details.this, "Add Patient Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });


        button_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Patient_Details.this,ViewPatientActivity.class);
                startActivity(intent);
            }
        });


    }
}
