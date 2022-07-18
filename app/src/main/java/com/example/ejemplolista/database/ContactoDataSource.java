package com.example.ejemplolista.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.ejemplolista.modelos.Contacto;

import java.util.ArrayList;
import java.util.List;

public class ContactoDataSource {
    private static final String TAG = "DataSource";
    SQLiteOpenHelper dbHelper;
    SQLiteDatabase database;

    public ContactoDataSource(Context context) {
        dbHelper = new ContactoDBOpenHelper(context);
    }

    public void openDb(){
        database = dbHelper.getReadableDatabase();
        Log.i(TAG, "openDB");
    }

    public void closeDB(){
        dbHelper.close();
        Log.i(TAG, "closeDB");
    }
    public List<Contacto> obtenerContactos(){
        List<Contacto> contactos;
        contactos = new ArrayList<>();
        return contactos;
    }
}
