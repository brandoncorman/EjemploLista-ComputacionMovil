package com.example.ejemplolista.modelos;

public class Contacto {

    String nombre;
    String apellido_p;
    String materno_m;
    String telefono;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_p() {
        return apellido_p;
    }

    public void setApellido_p(String apellido_p) {
        this.apellido_p = apellido_p;
    }

    public String getMaterno_m() {
        return materno_m;
    }

    public void setMaterno_m(String materno_m) {
        this.materno_m = materno_m;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return nombre + ' ' + apellido_p + ' ' + materno_m;
    }
}
