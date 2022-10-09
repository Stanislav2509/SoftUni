package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Ex06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int row= Integer.parseInt(scanner.nextLine());

        int [][] matrix=new int[row][row];
        for(int r=0;r< matrix.length;r++){
            matrix[r]= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i=0;i< matrix.length;i++){
            System.out.print(matrix[i][i]+" ");
        }
        System.out.println();
        row=row-1;
        int col=0;
        while (row>=0 && col<matrix[row].length){
            System.out.print(matrix[row][col]+" ");
            row--;
            col++;
        }
    }
}
