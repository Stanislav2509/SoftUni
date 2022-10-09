package com.company;

import java.util.Scanner;

public class Ex04CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input= scanner.nextLine();
        String encrypt="";
        for(int i=0;i<input.length();i++){
            char ch= (char) (input.charAt(i)+3);
            encrypt+=ch;
        }
        System.out.println(encrypt);
    }
}
