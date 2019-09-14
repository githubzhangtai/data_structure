package com.kimizhang;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Array array = new Array(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        array.add(1,5);
        System.out.println(array.toString());
        System.out.println(array.get(3));
    }
}
