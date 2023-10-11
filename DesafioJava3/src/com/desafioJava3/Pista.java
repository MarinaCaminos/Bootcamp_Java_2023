package com.desafioJava3;

public class Pista {

    private String nombre;

    public Pista(String nombre) {
        this.nombre = nombre;
    }

    public void aterrizar(Volador volador) {
        System.out.println(volador.toString() + " aterrizó en " + nombre);
    }
}
