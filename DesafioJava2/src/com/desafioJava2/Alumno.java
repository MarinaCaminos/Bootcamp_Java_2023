package com.desafioJava2;

class Alumno {
    private String nombre;
    private String apellido;
    private int[] notas = new int[2];

    public Alumno(String nombre, String apellido, int nota1, int nota2) {
        this.nombre = nombre;
        this.apellido = apellido;
        notas[0] = nota1;
        notas[1] = nota2;
    }

    public double calcularPromedio() {
        int suma = 0;
        for (int nota : notas) {
            suma += nota;
        }
        return (double) suma / notas.length;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public int getNotaMaxima() {
        int maxNota = notas[0];
        for (int nota : notas) {
            if (nota > maxNota) {
                maxNota = nota;
            }
        }
        return maxNota;
    }

    public int getNotaMinima() {
        int minNota = notas[0];
        for (int nota : notas) {
            if (nota < minNota) {
                minNota = nota;
            }
        }
        return minNota;
    }
}
