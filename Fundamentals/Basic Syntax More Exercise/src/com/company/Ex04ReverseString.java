package com.company;

import java.util.Scanner;

public class Ex04ReverseString {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String currentWord= scanner.nextLine();
        StringBuilder reverseWord= new StringBuilder();
        char letter;

        for(int i=1;i<=currentWord.length();i++){
            letter=currentWord.charAt(currentWord.length()-i);
            reverseWord.append(letter);
        }
        System.out.println(reverseWord);
    }


}
