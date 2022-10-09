package com.company;

import java.util.Scanner;

public class Ex01DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
       String example=scanner.nextLine();

       while (!example.equals("END")){
           boolean isInt=isInt(example);
           boolean isFloat=isFloat(example);

           if(isInt){
               System.out.printf("%s is integer type%n", example);
           }else if(isFloat){
               System.out.printf("%s is floating point type%n", example);
           }else if(example.equalsIgnoreCase("true")||example.equalsIgnoreCase("false")){
               System.out.printf("%s is boolean type%n",example);
           }else if(example.length()>1){
               System.out.printf("%s is string type%n",example);
           }else {
               System.out.printf("%s is character type%n",example);
           }

           example= scanner.nextLine();
       }

    }

    public static boolean isInt(String example){
        boolean isInt=true;
        try {
            int exampleIsInt=Integer.parseInt(example);
        }
        catch (NumberFormatException exception){
            isInt=false;
        }
        return isInt;
    }

    public static boolean isFloat(String example){
        boolean isFloat=true;
        try {
            float exampleIsFloat=Float.parseFloat(example);
        }catch (NumberFormatException exception){
            isFloat=false;
        }
        return isFloat;
    }
}
