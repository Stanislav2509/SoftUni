package com.company;

import java.util.Scanner;

public class Ex05MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String number= scanner.nextLine();
        byte multiplyBy=Byte.parseByte(scanner.nextLine());
        String result="";
        int remainder=0;
        if(multiplyBy==0){
            System.out.println(0);
        }else {
            for(int i=number.length()-1;i>=0;i--){
                char chatDigit=number.charAt(i);
                int digit=Integer.parseInt(String.valueOf(chatDigit));
                int multiplyDigit=digit*multiplyBy+remainder;

                if(i!=0&&multiplyDigit>9){
                    remainder=multiplyDigit/10;
                    int digit2=multiplyDigit%10;
                    result+=digit2;
                }else if(i==0&&multiplyDigit>9) {
                    remainder=multiplyDigit/10;
                    int digit2=multiplyDigit%10;
                    result+=digit2;
                    result+=remainder;
                }else {
                    result+=multiplyDigit;
                    remainder=0;
                }

            }
            for(int i=result.length()-1;i>=0;i--){
                System.out.print(result.charAt(i));
            }
        }


    }
}
