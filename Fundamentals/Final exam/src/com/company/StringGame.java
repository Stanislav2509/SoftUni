package com.company;

import java.util.Scanner;

public class StringGame {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String text= scanner.nextLine();
        String input= scanner.nextLine();
        while (!input.equals("Done")){

            String command=input.split(" ")[0];
            String result="";
            switch (command){
                case "Change":
                    text=changeFunction(input,text);
                    System.out.println(text);
                    break;
                case "Includes":
                    String substring= (input.split(" ")[1]);
                    result= includesFunction(substring,text);
                    System.out.println(result);
                    break;
                case "End":
                    substring= (input.split(" ")[1]);
                    result=endFunction(substring,text);
                    System.out.println(result);
                    break;
                case "Uppercase":
                    text=text.toUpperCase();
                    System.out.println(text );
                    break;
                case "FindIndex":
                    String symbol= (input.split(" ")[1]);
                    result= String.valueOf(text.indexOf(symbol));
                    System.out.println(result);
                    break;
                case "Cut":
                    int startIndex= Integer.parseInt(input.split(" ")[1]);
                    int count= Integer.parseInt(input.split(" ")[2]);
                    text=text.substring(startIndex,startIndex+count);
                    System.out.println(text);
                    break;
            }
            input= scanner.nextLine();
        }
    }

    private static String endFunction(String substring, String text) {
        int substringLength=substring.length();
        if(text.contains(substring)){
            String str=text.substring(text.length()-substringLength);
            if(str.equals(substring)){
                return  "True";
            }else {
                return  "False";
            }
        }else {
            return  "False";
        }
    }

    private static String includesFunction(String substring, String text) {
        if(text.contains(substring)){
            return  "True";
        }else {
            return  "False";
        }
    }


    private static String changeFunction(String input, String text) {
        String symbol= (input.split(" ")[1]);
        String replacement=input.split(" ")[2];
        text=text.replaceAll(symbol,replacement);
        return text;
    }
}
