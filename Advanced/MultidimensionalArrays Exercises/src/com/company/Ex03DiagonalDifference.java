package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Ex03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= Integer.parseInt(scanner.nextLine());
        int [][]matrix=new int[n][n];
        for(int r=0;r<matrix.length;r++){
            matrix[r]= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int sumPrimaryDiagonal=0;
        for(int r=0;r<matrix.length;r++){
            for(int c=0;c<matrix[r].length;c++){
                if(r==c){
                    sumPrimaryDiagonal+=matrix[r][c];
                }
            }
        }
//        for(int i=0;i<n;i++){
//            sumPrimaryDiagonal+=matrix[i][i];
//        }

        int sumSecondaryDiagonal=0;
        for(int r=0;r<matrix.length;r++){
            sumSecondaryDiagonal+=matrix[r][n-r-1];
        }
//        for(int r=n-1, c=0; r>=0 && c<matrix[r].length;r--,c++){
//            sumSecondaryDiagonal+=matrix[r][c];
//        }
        System.out.println(Math.abs(sumPrimaryDiagonal-sumSecondaryDiagonal));
    }
}
