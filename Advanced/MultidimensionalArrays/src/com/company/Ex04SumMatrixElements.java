package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Ex04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int [] sizes= Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int row=sizes[0];
        int col=sizes[1];
        int [][]matrix=new int[row][col];
        for(int i=0;i<row;i++){
            matrix[i]=Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }
        int sum=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                sum+=matrix[i][j];
            }
        }
        System.out.printf("%d%n%d%n%d",row,col,sum);
    }
}
