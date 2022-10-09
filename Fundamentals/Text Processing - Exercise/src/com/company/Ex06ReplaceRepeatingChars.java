package com.company;

import java.util.Scanner;

public class Ex06ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input= scanner.nextLine();
        System.out.print(input.charAt(0));
        for(int i=1;i<input.length()-1;i++){
            if(i==input.length()-2&&input.charAt(i-1)!= input.charAt(i)&&input.charAt(i)!=input.charAt(i+1)){
                System.out.print(input.charAt(i));
                System.out.print(input.charAt(i+1));
            }else if(i==input.length()-2&&input.charAt(i-1)== input.charAt(i)&&input.charAt(i)!=input.charAt(i+1)){
                System.out.print(input.charAt(i+1));
            }
            else if(input.charAt(i)!=input.charAt(i-1)){
                System.out.print(input.charAt(i));
            }
        }
    }
}
