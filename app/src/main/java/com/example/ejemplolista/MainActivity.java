package com.example.ejemplolista;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ejemplolista.database.ContactoDataSource;
import com.example.ejemplolista.modelos.Contacto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener{

    ListView lvContactos;
    List<Contacto> contactos;
    ContactoDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Agenda");

        dataSource = new ContactoDataSource(this);

        lvContactos = findViewById(R.id.lvContactos);

        contactos = new ArrayList<>();

        dataSource.openDb();
        contactos = dataSource.obtenerContactos();
        dataSource.closeDB();
        //Contacto contacto = new Contacto();


        /*contacto.setNombre("Javier");
        contacto.setApellido_p("Garrido");
        contacto.setMaterno_m("Ruiz");
        contacto.setTelefono("+45678887");

        Contacto contacto2 = new Contacto();
        contacto2.setNombre("Javiera");
        contacto2.setApellido_p("Orellana");
        contacto2.setMaterno_m("Chaparro");
        contacto2.setTelefono("+885544744");

        contactos.add(contacto);
        contactos.add(contacto2);*/

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_agregar_contacto:
                Intent intent = new Intent(this, NuevoContactoActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}