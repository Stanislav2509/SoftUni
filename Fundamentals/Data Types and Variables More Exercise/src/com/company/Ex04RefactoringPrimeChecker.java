package com.company;

import java.util.Scanner;

public class Ex04RefactoringPrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lastNumber=Integer.parseInt(scanner.nextLine());
        boolean isPrime;

        for(int number=2;number<=lastNumber;number++){
            isPrime=true;
            for(int divisor=2;divisor<number;divisor++){
                if(number%divisor==0){
                    isPrime=false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", number,isPrime);
        }
    }
}
