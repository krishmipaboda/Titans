package com.example.e_channelling;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelpClass extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "echannelingInfo_database";
    //Database Table name
    private static final String TABLE_NAME = "PATIENT";
    //Table columns
    public static final String NIC = "nic";
    public static final String FIRSTNAME = "firstname";
    public static final String LASTNAME = "lastname";
    public static final String EMAIL = "email";
    public static final String CONTACT = "contact";
    public static final String AGE = "age";



    private SQLiteDatabase sqLiteDatabase;


    //creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"("+NIC+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + FIRSTNAME + " TEXT NOT NULL,"+LASTNAME+" TEXT NOT NULL,"+EMAIL+" TEXT NOT NULL,"+CONTACT+" TEXT NOT NULL,"+AGE+" TEXT NOT NULL);";
    //Constructor
    public DatabaseHelpClass(Context context){
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

    //Add Employee Data
    public void addPatient(PatientModelClass patientModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelpClass.FIRSTNAME, patientModelClass.getFirstname());
        contentValues.put(DatabaseHelpClass.LASTNAME, patientModelClass.getLastname());
        contentValues.put(DatabaseHelpClass.EMAIL, patientModelClass.getEmail());
        contentValues.put(DatabaseHelpClass.CONTACT, patientModelClass.getContact());
        contentValues.put(DatabaseHelpClass.AGE, patientModelClass.getAge());




        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelpClass.TABLE_NAME, null,contentValues);
    }

    public List<PatientModelClass> getPatientList(){
        String sql = "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<PatientModelClass> storePatient = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                int nic = Integer.parseInt(cursor.getString(0));
                String firstname = cursor.getString(1);
                String lastname = cursor.getString(2);
                String  email = cursor.getString(3);
                String  contact = cursor.getString(4);
                String  age = cursor.getString(5);




                storePatient.add(new PatientModelClass(nic,firstname,lastname,email,contact,age));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storePatient;
    }

    public void updatePatient(PatientModelClass patientModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelpClass.FIRSTNAME,patientModelClass.getFirstname());
        contentValues.put(DatabaseHelpClass.LASTNAME,patientModelClass.getLastname());
        contentValues.put(DatabaseHelpClass.EMAIL,patientModelClass.getEmail());
        contentValues.put(DatabaseHelpClass.CONTACT,patientModelClass.getContact());
        contentValues.put(DatabaseHelpClass.AGE,patientModelClass.getAge());




        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME,contentValues,NIC + " = ?" , new String[]
                {String.valueOf(patientModelClass.getNic())});
    }

    public void deletePatient(int id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, NIC+ " = ? ", new String[]
                {String.valueOf(NIC)});
    }

}
