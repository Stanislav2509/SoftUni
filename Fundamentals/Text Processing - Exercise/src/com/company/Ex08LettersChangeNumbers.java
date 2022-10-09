package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String>data= Arrays.stream(scanner.nextLine().split("\\s+ ")).collect(Collectors.toList());
        double result=0;

        for(String command:data){
            int firstLetter=command.charAt(0);
            int secondLetter=command.charAt(command.length()-1);
            double number=Integer.parseInt(command.substring(1,command.length()-1));
            int position=0;
            if(firstLetter>=65&&firstLetter<=90){
                position=firstLetter-64;
                result+=number/position;
            }else if(firstLetter>=97&&firstLetter<=122){
                position=firstLetter-96;
                result+=number*position;
            }

            if(secondLetter>=65&&secondLetter<=90){
                position=secondLetter-64;
                result-=position;
            }else if(secondLetter>=97&&secondLetter<=122){
                position=secondLetter-96;
                result+=position;
            }
        }
        System.out.printf("%.2f",result);
    }
}
