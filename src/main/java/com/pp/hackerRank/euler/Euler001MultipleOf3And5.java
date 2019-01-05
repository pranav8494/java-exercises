package com.pp.hackerRank.euler;

import java.util.Scanner;

public class Euler001MultipleOf3And5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            long sum = 0;
            
            // getting multiples of 3 
            long p = (n-1)/3;
            sum = ((3*p*(p+1))/2);
            
            // getting multiples of 5
            p = (n-1)/5;
            sum = sum + ((5*p*(p+1))/2);

            // deducting common multiples with 15 (3*5) as they are duplicated.
            p = (n-1)/15;
            sum = sum - ((15*p*(p+1))/2);
            System.out.println(sum);
        }
    }
}
