package com.implemica.radzievskiy.task1;

import java.util.ArrayList;

public class Task1 {

    public static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index) { // add parens to the list
        if (leftRem < 0 || rightRem < leftRem) return; // incorrect condition

        if (leftRem == 0 && rightRem == 0) { // bracket not needed
            list.add(String.copyValueOf(str));
        } else {
            str[index] = '('; // add left bracket
            addParen(list, leftRem - 1, rightRem, str, index + 1);

            str[index] = ')'; // add right bracket
            addParen(list, leftRem, rightRem - 1, str, index + 1);
        }
    }

    public static ArrayList<String> generateParens(int count) { // generate all possible parens
        char[] str = new char[count * 2]; // create char array with 2 * count length
        ArrayList<String> list = new ArrayList<>(); //  create list to store all possible parens
        addParen(list, count, count, str, 0);   //  add parens to the list
        return list;
    }

    public static void main(String[] args) {
        ArrayList<String> list = generateParens(2);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.size());
    }
}
