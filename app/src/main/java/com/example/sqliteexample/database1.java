package com.example.sqliteexample;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class database1 extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 5;
    //Database Name
    private static final String DATABASE_NAME = "pharmacy_database";
    //Database Table name
    private static final String TABLE_NAME = "pharmacy";
    //Table columns
    public static final String ID = "id";
    public static final String Name = "p_Name";
    public static final String Address = "p_Address";
    public static final String Mobile = "p_Mobile";
    public static final String PharmacyName = "p_PharmacyName";
    public static final String PrescriptionName = "p_PrescriptionName";
    private SQLiteDatabase sqLiteDatabase;

    //PharmacyModelClass
    //creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"("+ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + Name + " TEXT NOT NULL,"+Address+" TEXT NOT NULL,"+Mobile+" TEXT NOT NULL,"+PharmacyName+" TEXT NOT NULL,"+PrescriptionName+" TEXT NOT NULL);";
    //Constructor
    public database1 (Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //Add  Data
    public void addPharmacy(PharmacyModelClass pharmacyModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(database1.Name, pharmacyModelClass.getpName());
        contentValues.put(database1.Address, pharmacyModelClass.getpAddress());
        contentValues.put(database1.Mobile, pharmacyModelClass.getpMobile());
        contentValues.put(database1.PharmacyName, pharmacyModelClass.getpPharmacyName());
        contentValues.put(database1.PrescriptionName, pharmacyModelClass.getpPrescriptionName());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(database1.TABLE_NAME, null,contentValues);
    }

    public List<PharmacyModelClass> getPharmacyList(){
        String sql = "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<PharmacyModelClass> storePharmacy = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String p_Name = cursor.getString(1);
                String p_Address = cursor.getString(2);
                String p_Mobile = cursor.getString(3);
                String p_PharmacyName = cursor.getString(4);
                String p_PrescriptionName = cursor.getString(5);
                storePharmacy.add(new PharmacyModelClass(id,p_Name,p_Address,p_Mobile,p_PharmacyName,p_PrescriptionName));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storePharmacy;
    }

    public void updatePharmacy(PharmacyModelClass pharmacyModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(database1.Name,pharmacyModelClass.getpName());
        contentValues.put(database1.Address,pharmacyModelClass.getpAddress());
        contentValues.put(database1.Mobile,pharmacyModelClass.getpMobile());
        contentValues.put(database1.PharmacyName,pharmacyModelClass.getpPharmacyName());
        contentValues.put(database1.PrescriptionName,pharmacyModelClass.getpPrescriptionName());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME,contentValues,ID + " = ?" , new String[]
                {String.valueOf(pharmacyModelClass.getId())});
    }

    public void deletePharmacy(int id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, ID + " = ? ", new String[]
                {String.valueOf(id)});
    }

}
