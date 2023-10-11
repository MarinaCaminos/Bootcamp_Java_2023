package com.desafioJava3;

import java.util.ArrayList;
import java.util.List;

public class TorreDeControl {
    private List<Volador> voladoresEnElAire;
    private Pista pista1;
    private Pista pista2;
    private Operario operario;

    public TorreDeControl() {
        voladoresEnElAire = new ArrayList<>();
        pista1 = new Pista("Pista 1");
        pista2 = new Pista("Pista 2");
        operario = new Operario();
    }

    public void agregarVolador(Volador volador) {
        voladoresEnElAire.add(volador);
    }

    public void gestionarAterrizaje() {
        for (Volador volador : voladoresEnElAire) {
            if (volador instanceof VoladorConPermiso) {
                pista1.aterrizar(volador);
            } else {
                if (operario.autorizarAterrizaje(volador)) {
                    pista2.aterrizar(volador);
                } else {
                    System.out.println("No es posible aterrizar " + volador.toString());
                }
            }
        }
    }
}

