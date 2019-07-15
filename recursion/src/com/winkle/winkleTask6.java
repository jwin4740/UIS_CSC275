/*
I declare that all material in this assessment task is my own work except where there is clear acknowl-
edgement or reference to the work of others. I further declare that I have complied with, and agree to
abide by, the UIS Academic Integrity Policy at the University website. http://www.uis.edu/academicintegrity
Author’s Name: James J Winkle UID: 652613763 Date: 07/14/2019

In the following link:
https://beginnersbook.com/2014/07/java-program-to-convert-decimal-to-hexadecimal/ --> I got the idea of construction an array
of characters 0-9 and a-f so that there indexes matched according to their values. The link also helped me with constructing
logic to kick up the first recursive call and dividing by 16

The following links were helpful for me in solving the permutation method:
https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/ --> gave me some good background on
how a backtracking algorithm works

https://www.techiedelight.com/generate-permutations-string-java-recursive-iterative/ --> introduced me to the idea of using the
substring method to form new strings to pipe into my recursive calls
*/


package com.winkle;

import java.util.HashMap;
import java.util.Scanner;

public class winkleTask6 {
    // char array of hex characters
    static final char hexArray[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    // hashmap used to represent hex characters to numbers
    static final HashMap<Character, Integer> hexMap = new HashMap<Character, Integer>() {
        {
            put('a', 10);
            put('b', 11);
            put('c', 12);
            put('d', 13);
            put('e', 14);
            put('f', 15);
        }
    };


    public static void displayPermutation(String s) {
        displayPermutation("", s);

    }

    public static void displayPermutation(String s1, String s2) {

        //base case
        if (s2.isEmpty()) {
            System.out.println(s1);
        }
        for (int i = 0; i <= s2.length() - 1; i++) {
            String newS1 = s1 + s2.charAt(i);
            String newS2 = s2.substring(0, i) +
                    s2.substring(i + 1);
            displayPermutation(newS1, newS2);

        }

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


    public static int hex2Dec(String hexString) {

        return hex2Dec(hexString, 0);
    }

    public static int hex2Dec(String hexString, int index) {
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


    public static String dec2Hex(int value) {
        int remainder = value % 16;
        value /= 16;
        if (value == 0) {
            return String.valueOf(hexArray[remainder]);
        }
        return dec2Hex(value) + hexArray[remainder];
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean alive = true;
        while (alive) {
            System.out.println("\nChoose from the following methods to test or exit: ");
            System.out.println("a) Convert binary to decimal\nb) Convert decimal to hex\nc) Convert hex to decimal\nd) List string permutations\ne) exit program");
            switch (scanner.nextLine()) {
                case ("a"):
                    System.out.print("Enter a binary number: ");
                    String start = scanner.nextLine();
                    if (!start.matches("[0-1]*")) {
                        System.out.println("ERROR --> must have only 0 or 1");
                        break;
                    }

                    System.out.println("Your converted value is: " + bin2Dec(start));
                    break;
                case ("b"):
                    System.out.print("Enter a decimal number: ");

                    String value = scanner.nextLine();
                    if (!value.matches("[0-9]*")) {
                        System.out.println("ERROR --> must have only numbers");
                        break;
                    }
                    System.out.println("Your converted value is: " + dec2Hex(Integer.parseInt(value)));
                    break;

                case ("c"):
                    System.out.print("Enter a hex number: ");

                    String hexString = scanner.nextLine();
                    if (!hexString.matches("[0-9a-f]*")) {
                        System.out.println("ERROR --> must have only numbers and/or characters \'a\' through \'f\'");
                        break;
                    }
                    System.out.println("Your converted value is: " + hex2Dec(hexString));

                    break;
                case ("d"):
                    System.out.print("Enter a string (please no longer than 8 letters long because it may take too much time and use too much cpu): ");
                    String userString = scanner.nextLine();
                    if (!userString.matches("[a-zA-Z]*") || userString.length() > 8) {
                        System.out.println("ERROR --> your string must contain only letters and/or less than 9 characters");
                        break;
                    }
                    System.out.println("The following are the permutations of your string given:");
                    displayPermutation(userString);
                    break;
                case ("e"):
                    System.out.print("...exiting program, goodbye!");
                    break;
                default:
                    System.out.println("...exiting, please enter valid letter choice");
            }

            System.out.println("\n\nWould you like to exit the program (y/n): ");
            if (scanner.nextLine().equals("y")) {
                System.out.print("...exiting program, goodbye!");
                alive = false;
            }
        }
        scanner.close();

    }
}
