package com.kimizhang;


public class Main {

    public static void main(String[] args) {
        Array array = new Array(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        array.add(4,55);
        array.add(5,55);
        System.out.println(array.toString());
        array.removeAllElement(55);
        System.out.println(array.toString());
    }
}
