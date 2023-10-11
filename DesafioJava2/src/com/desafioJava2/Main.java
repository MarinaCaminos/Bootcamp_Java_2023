package com.desafioJava2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de alumnos a procesar: ");
        int cantidadAlumnos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea

        Alumno[] alumnos = new Alumno[cantidadAlumnos];

        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.println("Ingrese datos del alumno " + (i + 1));
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
            System.out.print("Nota del examen 1: ");
            int nota1 = scanner.nextInt();
            System.out.print("Nota del examen 2: ");
            int nota2 = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            alumnos[i] = new Alumno(nombre, apellido, nota1, nota2);
        }

        // Calcular y mostrar información
        System.out.println("Información de los alumnos:");
        for (int i = 0; i < cantidadAlumnos; i++) {
            Alumno alumno = alumnos[i];
            System.out.println("Alumno " + (i + 1) + ": " + alumno.getNombreCompleto());
            System.out.println("Promedio: " + alumno.calcularPromedio());
            System.out.println("Nota Máxima: " + alumno.getNotaMaxima());
            System.out.println("Nota Mínima: " + alumno.getNotaMinima());
            System.out.println();
        }

        // Buscar alumnos con calificación más alta y más baja
        int maxNota = -1;
        int minNota = 11;
        for (Alumno alumno : alumnos) {
            maxNota = Math.max(maxNota, alumno.getNotaMaxima());
            minNota = Math.min(minNota, alumno.getNotaMinima());
        }

        System.out.println("Alumno/s con la calificación más alta:");
        for (Alumno alumno : alumnos) {
            if (alumno.getNotaMaxima() == maxNota) {
                System.out.println(alumno.getNombreCompleto());
            }
        }

        System.out.println("Alumno/s con la calificación más baja:");
        for (Alumno alumno : alumnos) {
            if (alumno.getNotaMinima() == minNota) {
                System.out.println(alumno.getNombreCompleto());
            }
        }

        // Buscar alumnos que promocionan y que deben recursar
        System.out.println("Alumnos que promocionan:");
        for (Alumno alumno : alumnos) {
            if (alumno.calcularPromedio() >= 7) {
                System.out.println(alumno.getNombreCompleto());
            }
        }

        System.out.println("Alumnos que deben recursar:");
        for (Alumno alumno : alumnos) {
            if (alumno.calcularPromedio() < 7) {
                System.out.println(alumno.getNombreCompleto());
            }
        }
    }
}
