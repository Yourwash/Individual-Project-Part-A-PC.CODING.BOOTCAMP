/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Dante_Fiero
 */
public class Input {

    Scanner sc = new Scanner(System.in);

    public static String inputText() {
        Scanner sc = new Scanner(System.in);
        String tempString = "";
        try {
            tempString = sc.nextLine();
            return (tempString);

        } catch (Exception e) {
            System.out.println("input text please");
        }
        return (tempString);
    }

    public static String inputDate() throws ParseException {
        Scanner sc = new Scanner(System.in);
        Date tempDate;
        String tempStrDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        boolean goNext = false;
        while (goNext == false) {
            try {               
               tempDate = sdf.parse(sc.nextLine()); 
               tempStrDate = sdf.format(tempDate);
                goNext = true;
                return (tempStrDate);

            } catch (ParseException e) {
                System.out.println("Input a date in this format (Day-Month-Year) please. ");
            }
        }
        return (tempStrDate);
    }

    public static int inputInt() {
        Scanner sc = new Scanner(System.in);
        int tempInt = 0;
        boolean goNext = false;
        while (goNext == false) {
            try {
                tempInt = sc.nextInt();
                goNext = true;
                return (tempInt);

            } catch (Exception e) {
                System.out.println("Input an integer please. ");
            }
        }
        return (tempInt);
    }

    public static double inputDouble() {
        Scanner sc = new Scanner(System.in);
        double tempDouble = 0;
        boolean goNext = false;
        while (goNext == false) {
            try {
                tempDouble = sc.nextDouble();
                goNext = true;
                return (tempDouble);

            } catch (Exception e) {
                System.out.println("Input a number please. ");
            }
        }
        return (tempDouble);
    }
}
