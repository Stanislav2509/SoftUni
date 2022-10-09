package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Ex02FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= Integer.parseInt(scanner.nextLine());
        String numbers="";
        long [] numbersArray;
        long firstNumber,secondNumber;
        int sum;
        for(int i=0;i<n;i++){
            numbers=scanner.nextLine();
            numbersArray= Arrays.stream(numbers.split(" ")).mapToLong(Long::parseLong).toArray();

            firstNumber=numbersArray[0];
            secondNumber=numbersArray[1];

            if(firstNumber>secondNumber){
                sum=sumOfDigits(firstNumber);
            }else {
                sum=sumOfDigits(secondNumber);
            }
            System.out.println(sum);
        }
    }

    public static int sumOfDigits(long number){
        int lastDigit,sum=0;
        while (number!=0){
            lastDigit= (int) (number%10);
            number/=10;
            sum+=Math.abs(lastDigit);
        }
        return sum;
    }
}
