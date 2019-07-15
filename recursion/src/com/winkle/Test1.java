package com.winkle;

public class Test1 {
    public static void main(String[] args) {
        xfunction(1234);
    }

    public static void xfunction(int n) {
        if (n > 0) {
            System.out.print(n % 10 + " ");
            xfunction(n / 10);
        }
    }
}

