package com.company;

import java.util.Scanner;

public class Ex05Messages {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int number,digitLength,mainDigit,offset,letterIndex;
        char letter;
        String message="";

        for(int i=0;i<n;i++){
             number=Integer.parseInt(scanner.nextLine());
             digitLength=findNumberOfDigits(number);
             mainDigit=number%10;

             offset=findOffset(mainDigit);

             letterIndex=offset+digitLength-1;

            if(mainDigit==0){
                letter=32;
            }else {
                letter= (char)(97+ letterIndex);
            }

            message+=letter;
        }

        System.out.println(message);
    }
    public static int findNumberOfDigits(int number){
        int digits=0;
        do{
            number/=10;
            digits++;
        }while (number!=0);

        return digits;
    }

    public static int findOffset(int mainDigit){
        int offset;
        if(mainDigit==8 || mainDigit==9){
            offset=((mainDigit-2)*3)+1;
        }else {
            offset=(mainDigit-2)*3;
        }
        return offset;
    }

}
