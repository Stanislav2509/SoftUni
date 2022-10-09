package com.company;

import java.util.Scanner;

public class Ex07StringExplosion {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        StringBuilder input=new StringBuilder(scanner.nextLine());
        int remainder=0;
        for(int i=0;i<input.length();i++){
             if(input.charAt(i)=='>'){
               int strength=Integer.parseInt(String.valueOf(input.charAt(i+1)));
               remainder+=strength;

            }else if(!(input.charAt(i) =='>')&&remainder>0){
                 input.deleteCharAt(i);
                 remainder--;
                 i--;
            }
        }
        System.out.println(input);
    }
}
