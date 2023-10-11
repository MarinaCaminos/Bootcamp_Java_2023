package com.desafioJava3;

public class CollectionCustom<T> {
    private T[] array;
    private int size;

    // suprimo las advertencias relacionadas con la verificación de tipos ya que trabajo con tipos genericos
    @SuppressWarnings("unchecked")
    public CollectionCustom(int capacity) {
        array = (T[]) new Object[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(T element) {
        if (size == array.length) {
            resizeArray();
        }
        for (int i = size; i > 0; i--) {
            array[i] = array[i-1];
        }
        array[0] = element;
        size++;
    }

    public void addLast(T element) {
        if (size == array.length) {
            resizeArray();
        }
        array[size] = element;
        size++;
    }

    public void add(T element) {
        addLast(element);
    }

    public T remove(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                T removedElement = array[i];
                for (int j = i; j < size-1; j++) {
                    array[j] = array[j+1];
                }
                array[size-1] = null;
                size--;
                return removedElement;
            }
        }
        return null;
    }

    public void removeAll(T element) {
        int newSize = 0;
        for (int i = 0; i < size; i++) {
            if (!array[i].equals(element)) {
                array[newSize] = array[i];
                newSize++;
            }
        }
        for (int i = newSize; i < size; i++) {
            array[i] = null;
        }
        size = newSize;
    }

    public boolean empty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    private void resizeArray() {
        int newCapacity = array.length * 2; // Lo agrando el doble
        T[] newArray = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray; // Reemplazo el array anterior por el nuevo
    }
}