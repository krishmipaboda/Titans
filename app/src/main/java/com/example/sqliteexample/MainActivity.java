package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText_p_Name,editText_p_Address,editText_p_Mobile,editText_p_PharmacyName,editText_p_PrescriptionName;
    Button button_add,button_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_p_Name = findViewById(R.id.edittext_Name);
        editText_p_Address = findViewById(R.id.edittext_Address);
        editText_p_Mobile = findViewById(R.id.edittext_Mobile);
        editText_p_PharmacyName = findViewById(R.id.edittext_PharmacyName);
        editText_p_PrescriptionName = findViewById(R.id.edittext_PrescriptionName);

        button_add = findViewById(R.id.button_add);
        button_view = findViewById(R.id.button_view);


        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringpName = editText_p_Name.getText().toString();
                String stringpAddress = editText_p_Address.getText().toString();
                String stringpMobile = editText_p_Mobile.getText().toString();
                String stringpPharmacyName = editText_p_PharmacyName.getText().toString();
                String stringpPrescriptionName = editText_p_PrescriptionName.getText().toString();


                if (stringpName.length() <=0 || stringpAddress.length() <=0|| stringpMobile.length() <=0|| stringpPharmacyName.length() <=0|| stringpPrescriptionName.length() <=0){
                    Toast.makeText(MainActivity.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }else {
                    database1 database12 = new database1(MainActivity.this);
                    PharmacyModelClass pharmacyModelClass = new PharmacyModelClass(stringpName, stringpAddress, stringpMobile, stringpPharmacyName, stringpPrescriptionName);
                    database12.addPharmacy(pharmacyModelClass);
                    Toast.makeText(MainActivity.this, "Add  Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });


        button_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ViewPharmacyActivity.class);
                startActivity(intent);
            }
        });


    }
}
