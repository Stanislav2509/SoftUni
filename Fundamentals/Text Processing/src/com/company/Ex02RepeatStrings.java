package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Ex02RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] input=scanner.nextLine().split(" ");
        StringBuilder result=new StringBuilder();
        for(int i=0;i<input.length;i++){
            for(int k=0;k<input[i].length();k++){
                result.append(input[i]);
            }
        }
        System.out.println(result);
    }
}
