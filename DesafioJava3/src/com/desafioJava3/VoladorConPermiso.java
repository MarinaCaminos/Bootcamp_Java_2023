package com.desafioJava3;

public class VoladorConPermiso implements Volador{
    private String nombre;

    public VoladorConPermiso(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean puedeAterrizar() {
        return true;
    }
    @Override
    public String toString() {
        return this.nombre;
    }
}
