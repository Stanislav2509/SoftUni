package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Ex11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String [] input= scanner.nextLine().split(" ");
        int rows=Integer.parseInt(input[0]);
        int cols=Integer.parseInt(input[1]);
        int [][] matrix=new int[rows][cols];

        for(int r=0;r<matrix.length;r++){
            matrix[r]= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int r= matrix.length-1;r>=0;r--){
            for(int c=matrix[r].length-1;c>=1;c--){
                System.out.println(matrix[r+2-c][c]+ " ");
            }
            System.out.println();
        }
    }
}
