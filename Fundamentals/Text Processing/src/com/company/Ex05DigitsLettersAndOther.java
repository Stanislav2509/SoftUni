package com.company;

import java.util.Scanner;

public class Ex05DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input= scanner.nextLine();
        String digits="";
        String letters="";
        String other="";
        for(int i=0;i<input.length();i++){
            if(Character.isDigit(input.charAt(i))){
                digits+=input.charAt(i);
            }else if(Character.isLetter(input.charAt(i))){
                letters+=input.charAt(i);
            }else {
                other+=input.charAt(i);
            }
        }
        System.out.printf("%s%n%s%n%s",digits,letters,other);
    }
}
