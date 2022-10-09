package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Ex05MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int [] sizes= Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int row=sizes[0];
        int col=sizes[1];
        int [][]matrix=new int[row][col];
        for(int i=0;i<row;i++){
            matrix[i]=Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }
        StringBuilder indexes=new StringBuilder();
        int maxSum=Integer.MIN_VALUE;

        for(int r=0;r<matrix.length-1;r++){
            for(int c=0;c<matrix[r].length-1;c++){
                int currentSum=matrix[r][c]+matrix[r][c+1]
                             +matrix[r+1][c]+matrix[r+1][c+1];
                if(currentSum>maxSum){
                    maxSum=currentSum;
                    indexes=new StringBuilder();
                    indexes.append(matrix[r][c]).append(" ").append(matrix[r][c+1]).append(System.lineSeparator())
                            .append(matrix[r+1][c]).append(" ").append(matrix[r+1][c+1]);
                }
            }
        }
        System.out.println(indexes);
        System.out.println(maxSum);
    }
}
