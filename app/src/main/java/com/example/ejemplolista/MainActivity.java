package com.example.ejemplolista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ejemplolista.modelos.Contacto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener{

    ListView lvContactos;
    List<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContactos = findViewById(R.id.lvContactos);

        contactos = new ArrayList<>();

        Contacto contacto = new Contacto();
        contacto.setNombre("Javier");
        contacto.setApellido_p("Garrido");
        contacto.setMaterno_m("Ruiz");
        contacto.setTelefono("+45678887");

        Contacto contacto2 = new Contacto();
        contacto2.setNombre("Javiera");
        contacto2.setApellido_p("Orellana");
        contacto2.setMaterno_m("Chaparro");
        contacto2.setTelefono("+885544744");

        contactos.add(contacto);
        contactos.add(contacto2);

        ArrayAdapter<Contacto> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactos);
        lvContactos.setAdapter(adapter);

        lvContactos.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Contacto contacto = contactos.get(position);
        String nombre = contacto.getNombre();
        String apellido_p = contacto.getApellido_p();

        Toast.makeText(this,"Clikeaste" + nombre, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, DetalleContactoActivity.class);
        intent.putExtra("nombre",nombre);
        intent.putExtra("paterno",apellido_p);
        startActivity(intent);

    }
}