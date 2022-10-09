package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Ex04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String [] input= scanner.nextLine().split(" ");
        int rows=Integer.parseInt(input[0]);
        int cols=Integer.parseInt(input[1]);
        int [][] matrix=new int[rows][cols];

        for(int r=0;r<matrix.length;r++){
            matrix[r]= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int maxSum=Integer.MIN_VALUE;
        int bestRow=0;
        int bestCol=0;
        for(int r=0;r<matrix.length-2;r++){
            for(int c=0;c<matrix[r].length-2;c++){
                int currSum=0;
//                currSum+=  matrix[r][c] + matrix[r][c+1] + matrix[r][c+2]+
//                        matrix[r+1][c] + matrix[r+1][c+1] + matrix[r+1][c+2]+
//                        matrix[r+2][c] + matrix[r+2][c+1] + matrix[r+2][c+2];

                for(int i=r;i<r+3;i++){
                    for(int k=c;k<c+3;k++){
                        currSum+=matrix[i][k];
                    }
                }

                if(currSum>maxSum){
                    maxSum=currSum;
                    bestRow=r;
                    bestCol=c;
                }
            }
        }
        System.out.println("Sum = "+maxSum);
        for(int r=bestRow;r<bestRow+3;r++){
            for(int c=bestCol;c<bestCol+3;c++){
                System.out.print(matrix[r][c]+" ");
            }
            System.out.println();
        }
    }
}
