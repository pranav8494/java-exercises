package com.pp.hackerRank.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class FindDay {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);

//        bufferedWriter.write(res);
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }    
}

class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {

        Date inputDate = new Date(year-1900, month-1, day);
        int weekDay = inputDate.getDay();
        
        System.out.println(inputDate);
        //0 = Sunday, 1 = Monday, 2 = Tuesday, 3 = Wednesday, 4 = Thursday, 5 = Friday, 6 = Saturday
        switch (weekDay) {
        case 0:
            return "Sunday".toUpperCase(); 
        case 1:
            return "Monday".toUpperCase(); 
        case 2:
            return "Tuesday".toUpperCase(); 
        case 3:
            return "Wednesday".toUpperCase(); 
        case 4:
            return "Thursday".toUpperCase(); 
        case 5:
            return "Friday".toUpperCase(); 
        case 6:
            return "Saturday".toUpperCase(); 
        default:
            return "";
        }
    }

}
