package com.example.ejemplolista.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class ContactoDBOpenHelper extends SQLiteOpenHelper {

    public static final String DATA_BASE_NAME = "agenda.db";
    public static final int VERSION = 1;
    private static final String TAG = "OpenHelper";

    String CREATE_TABLE_CONTACTO = "CREATE TABLE contacto (" +
            "id INTEGER PRIMARY KEY autoincrement," +
            "nombre TEXT," +
            "apellido_p TEXT," +
            "apellido_m TEXT," +
            "telefono TEXT)";

        String INSERT_CONTACTO_1 = "INSERT INTO contacto (nombre, apellido_p, apellido_m, telefono)" +
                "VALUES ('Alan', 'Slazak', 'Castro', '+569552255')";

    public ContactoDBOpenHelper(@Nullable Context context) {
        super(context, DATA_BASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_CONTACTO);
        Log.i(TAG, "Se creó tabla contacto");

        sqLiteDatabase.execSQL(INSERT_CONTACTO_1);
        Log.i(TAG, "Se insertó contacto 1");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
