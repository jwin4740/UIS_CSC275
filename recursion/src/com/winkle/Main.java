/*
https://beginnersbook.com/2014/07/java-program-to-convert-decimal-to-hexadecimal/
Module - Code design and Implementation Assignment
        Once more only 1 choice to implement this module. Naming convention: Project name “surnameTask6,
        note only "T" in capital all else lowercase. This task must be implemented within a single file.
        Conversions:
        Decimal to hex, Binary to Decimal, Hex to Decimal, and String permutation:
        Write a recursive method that converts a decimal number into a hex number as a string. The method
        header is:
        . public static String dec2Hex(int value)
        Write a recursive method that parses a binary number as a string into a decimal integer. The method
        header is:

        . public static int hex2Dec(String hexString)
        Write a recursive method to print all the permutations of a string. For example, for the string abc,
        the permutation is:
        . abc
        . acb
        . bac
        . bca
        . cab
        . cba
        Define the following two methods. The second is a helper method.
        . public static void displayPermutation(String s)
        . public static void displayPermutation(String s1, String s2)
        The first method simply invokes displayPermutation(“ ”, s). The second method uses a loop to move a
        character from s2 to s1 and recursively invokes it with a new s1 and s2. The base case is that s2 is empty
        and prints s1 to the console.
        1
        Write a menu driven test program that prompts the user to choose which of your methods to test
        out or to exit. The user is then to enter his/her choice:
        1. In the case of string permutation they enter a string and the program displays all its permutations,
        then returns to the menu.
        2. In the case of the hex the user enters a hex string and the program displays its decimal equivalent,
        then returns to the menu.
        3. In the case of the binary the user to enters a binary string and the program displays its decimal
        equivalent, then returns to the menu.
        4. In the case of the decimal the user to enters a decimal number and the program displays its hex
        equivalent, then returns to the menu.
        5. Boundary, recursive programs can quickly get out of hand complexity wise, Prompt the user at
        the start of your program to set an upper bound on input size, warm them of time delay in case
        of large inputs (say greater than 6 digits or chars).
        6. In the case of exit, display how much time elapsed and the number of recursive calls per function requested
        (bonus 1 point), then the program is to exit without leaking any resources...
        */


package com.winkle;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static final int A = 10;
    static final int B = 11;
    static final int C = 12;
    static final int D = 13;
    static final int E = 14;
    static final int F = 15;
    static final char hexArray[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    static final HashMap<Character, Integer> hexMap = new HashMap<>() {
        {
            put('A', 10);
            put('B', 11);
            put('C', 12);
            put('D', 13);
            put('E', 14);
            put('F', 15);
        }
    };
    static int hexLength = 0;


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

//        System.out.println("Enter a binary number:");
//        String start = s.nextLine();
//        int finalVal = bin2Dec(start);
//        System.out.println(finalVal);
//        System.out.println("Enter a hex number:");
//        String start = s.nextLine();
//        int finalVal = hex2Dec(start);


        System.out.println("Enter a decimal number:");
        int start = s.nextInt();
        String finalVal = dec2Hex(start);
        System.out.println(finalVal);
    }


    public static int bin2Dec(String binaryString) {
        return bin2Dec(binaryString, 0);
    }

    public static int bin2Dec(String binaryString, int index) {
        // length of binary string
        int leng = binaryString.length();
        int value;
        char character = binaryString.charAt(index);

        if (index == leng - 1) {
            return (character == '1') ? 1 : 0;
        }


        int adder = character == '0' ? 0 : (int) Math.pow(2, leng - index - 1);
        int newIndex = index + 1;
        value = +adder + bin2Dec(binaryString, newIndex);


        return value;

    }

    //    Write a recursive method that parses a hex number as a string into a decimal integer
    public static int hex2Dec(String hexString) {

        return hex2Dec(hexString, 0);
    }

    public static int hex2Dec(String hexString, int index) {
//        StringBuilder sb = new StringBuilder(hexString);
//        String myChar = hexString.substring(0, index + 1);
        int leng = hexString.length();
        int value;
        int val;
        char currentCharacter = hexString.charAt(index);
        if (Character.isLetter(currentCharacter)) {
            val = hexMap.get(currentCharacter);
        } else {
            val = Character.getNumericValue(hexString.charAt(index));
        }


        if (index == leng - 1) {
            return (val > 0) ? val : 0;
        }


        int adder = val > 0 ? val * ((int) Math.pow(16, leng - index - 1)) : 0;
        int newIndex = index + 1;
        value = +adder + hex2Dec(hexString, newIndex);


        return value;
    }

//    public static int dec2Hex(int value) {
////
////        return dec2Hex(value, 0);
////    }

    public static String dec2Hex(int value) {
//        StringBuilder sb = new StringBuilder(decString);
//        String myChar = decString.substring(0, index + 1);



        int remainder = value % 16;
        value /= 16;
        if (value == 0) {
            return String.valueOf(hexArray[remainder]);
        }


        return dec2Hex(value) + hexArray[remainder];
    }
}
