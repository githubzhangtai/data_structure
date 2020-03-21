package com.kimizhang;

import com.kimizhang.example.Solution1;
import com.kimizhang.example.Solution2;

public class Main {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        Solution2 solution2 = new Solution2();
        System.out.println(solution.isValid("[[[{[]}]]]"));
        System.out.println(solution2.isValid("[]"));
    }
}
