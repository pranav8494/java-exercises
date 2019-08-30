package com.pp.hackerRank.java;

import java.util.Scanner;

public class StringIntro {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        System.out.println(A.length() + B.length());
        System.out.println(A.compareTo(B) < 0 ? "Yes" : "No");
        System.out.println(upperCaseFirst(A) + " " + upperCaseFirst(B));       
    }

    public static String upperCaseFirst(String value) {

        // Convert String to char array.
        char[] array = value.toCharArray();
        // Modify first element in array.
        array[0] = Character.toUpperCase(array[0]);
        // Return string.
        return new String(array);
    }
}
