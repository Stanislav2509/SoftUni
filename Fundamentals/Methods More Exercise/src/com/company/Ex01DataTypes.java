package com.company;

import java.util.Scanner;

public class Ex01DataTypes {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String dataType= scanner.nextLine();
        String input= scanner.nextLine();
        searchForDataTypes(dataType,input);
    }

    public static void searchForDataTypes(String dataType, String input){
        switch (dataType){
            case "int":
                int intNumber=Integer.parseInt(input);
                System.out.println(multiplyIntNumberBy2(intNumber));
                break;
            case "real":
                double doubleNumber=Double.parseDouble(input);
                System.out.printf("%.2f",multiplyRealNumberBy2(doubleNumber));
                break;
            case "string":
                System.out.println(surroundString(input));
                break;
        }
    }

    public static int multiplyIntNumberBy2(int number){
        return number*2;
    }

    public static double multiplyRealNumberBy2(double number){
        return number*1.5;
    }

    public static String surroundString(String input){
        return "$"+input+"$";
    }
}
