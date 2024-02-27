package com.mycompany.modelo;

public class Carrera {

    public String nombre = "";

    public Carrera() {
    }

    public Carrera(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Carrera{" + "nombre=" + nombre + '}';
    }

}
