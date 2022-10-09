package com.company;

import java.util.Scanner;

public class Ex02PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int lines=Integer.parseInt(scanner.nextLine());
        long []arrSum;

        for(int i=0;i<lines;i++){
            arrSum=new long[i+1];
            arrSum[0]=1;
            arrSum[arrSum.length-1]=1;
            for(int k=0;k< arrSum.length-1;k++){
                arrSum[k]=calculateFactorial(i)/(calculateFactorial(k)*calculateFactorial(i-k));
            }

            for(long number:arrSum){
                System.out.print(number+" ");
            }
            System.out.println();
        }


//        int r, i, k, number = 1, j;
//        Scanner scan = new Scanner(System.in);
//
//        System.out.print("Enter Number of Rows : ");
//        r = scan.nextInt();
//
//        for (i = 0; i < r; i++) {
//            number = 1;
//            for (j = 0; j <= i; j++) {
//                System.out.print(number + " ");
//                number = number * (i - j) / (j + 1);
//            }
//            System.out.println();
//        }
    }

    public static long calculateFactorial(long number){
        long result=1;
        for(int i=1;i<=number;i++){
            result*=i;
        }
        return result;
    }
}
