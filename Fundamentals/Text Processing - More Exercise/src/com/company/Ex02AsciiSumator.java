package com.company;

import java.util.Scanner;

public class Ex02AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String firstChar= scanner.nextLine();
        String lastChar=scanner.nextLine();
        String word=scanner.nextLine();
        int sum=0;
        for(int i=0;i<word.length();i++){
            if(firstChar.charAt(0)<word.charAt(i)&&word.charAt(i)<lastChar.charAt(0)){
                sum+=word.charAt(i);
            }
        }
        System.out.println(sum);
    }
}
