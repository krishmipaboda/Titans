package com.example.sqliteexample;
//PharmacyAdapterClass
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ViewPharmacyActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pharmacy);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        database1 database12 = new database1(this);
        List<PharmacyModelClass> pharmacyModelClasses = database12.getPharmacyList();

        if (pharmacyModelClasses.size() > 0){
            PharmacyAdapterClass pharmacyadapterclass = new PharmacyAdapterClass(pharmacyModelClasses,ViewPharmacyActivity.this);
            recyclerView.setAdapter(pharmacyadapterclass);
        }else {
            Toast.makeText(this, "There is no Pharmacy in the database", Toast.LENGTH_SHORT).show();
        }




    }
}