package com.example.ejemplolista;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class DetalleContactoActivity extends AppCompatActivity {

    TextView tvNombre, tvApellido_p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        setTitle("Detalle");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvNombre = findViewById(R.id.tvNombre);
        tvApellido_p = findViewById(R.id.tvApellido_p);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String paterno = intent.getStringExtra("paterno");

        tvNombre.setText(nombre);
        tvApellido_p.setText(paterno);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}