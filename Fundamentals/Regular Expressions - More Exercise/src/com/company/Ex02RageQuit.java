package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex02RageQuit {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();
        StringBuilder result=new StringBuilder();
        String symbolsToRepeat="";
        int countRepeat=0;

        String regex="(?<symbol>\\D+)(?<countRepeat>\\d+)";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher= pattern.matcher(input);
        while (matcher.find()){
            symbolsToRepeat=matcher.group("symbol").toUpperCase();
            countRepeat=(Integer.parseInt(matcher.group("countRepeat")));
            for(int i=0;i<countRepeat;i++){
                result.append(symbolsToRepeat);
            }
        }
//        StringBuilder uniqueSymbols=new StringBuilder();
//        for(int i=0;i< result.length();i++){
//            if(uniqueSymbols.indexOf(String.valueOf(result.charAt(i)))==-1){
//                uniqueSymbols.append(result.charAt(i));
//            }
//        }
//
//        System.out.println("Unique symbols used: "+uniqueSymbols.length());
        System.out.println("Unique symbols used: "+result.chars().distinct().count());
        System.out.println(result);
    }
}
