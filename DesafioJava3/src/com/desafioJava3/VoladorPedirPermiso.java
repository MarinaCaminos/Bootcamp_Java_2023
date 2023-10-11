package com.desafioJava3;

public class VoladorPedirPermiso implements Volador{
    private int peso;
    private String nombre;

    public VoladorPedirPermiso(String nombre, int peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    @Override
    public boolean puedeAterrizar() {
        return this.peso <= 250000;
    }
    @Override
    public String toString() {
        return this.nombre + " con " + this.peso + "kg";
    }
}
