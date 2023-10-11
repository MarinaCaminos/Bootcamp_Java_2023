package com.desafioJava3;

public class Main {
    public static void main(String[] args) {
        TorreDeControl torre = new TorreDeControl();

        Volador objeto1 = new VoladorConPermiso("Helicoptero");
        Volador objeto2 = new VoladorPedirPermiso("Avion 01", 150000);
        Volador objeto3 = new VoladorPedirPermiso("Avion 02", 340000);

        torre.agregarVolador(objeto1);
        torre.agregarVolador(objeto2);
        torre.agregarVolador(objeto3);

        torre.gestionarAterrizaje();
    }
}
