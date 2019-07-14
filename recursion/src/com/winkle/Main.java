/*
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

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter a binary number:");
        String start = s.nextLine();
        int finalVal = bin2Dec(start);
        System.out.println(finalVal);
    }

//        bin2Dec("10");

    //    Write a recursive method that parses a hex number as a string into a decimal integer
    public static int bin2Dec(String binaryString) {
        return bin2Dec(binaryString, 0);
    }

    // test case "1111
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


}
