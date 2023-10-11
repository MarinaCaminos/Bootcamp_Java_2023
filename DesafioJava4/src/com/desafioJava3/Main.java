package com.desafioJava3;

public class Main {
    public static void main(String[] args) {

        // CollectionCustom<String> stringCollection = new CollectionCustom<>(3);
        CollectionCustom<Integer> customCollection = new CollectionCustom<>(3);

        customCollection.addFirst(1);
        customCollection.addLast(2);
        customCollection.add(3);
        customCollection.add(4);
        customCollection.addLast(5);

        System.out.println("Tamaño de la Collection: " + customCollection.size());

        System.out.println("Elimina el primer 2 encontrado: " + customCollection.remove(2));
        System.out.println("Elimina todos los 3");
        customCollection.removeAll(3);

        System.out.println("Tamaño de la Collection luego de las eliminaciones: " + customCollection.size());

        System.out.println("La Collection esta vacia? " + customCollection.empty());
    }
}
