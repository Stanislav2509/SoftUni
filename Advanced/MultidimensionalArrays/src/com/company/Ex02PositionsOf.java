package com.company;

import java.util.Scanner;

public class Ex02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int row= scanner.nextInt();
        int col= scanner.nextInt();
        int[][] firstMatrix=inputMatrix(scanner,row,col);

        int searchedNumber= scanner.nextInt();

       // StringBuilder result=new StringBuilder();
        boolean isFound=false;
        for(int r=0;r< firstMatrix.length;r++) {
            int[] firstArr = firstMatrix[r];
            for (int c = 0; c < firstArr.length; c++) {
                if (firstArr[c] ==searchedNumber) {
                    System.out.println(r+" "+c);
                    isFound=true;
                    //result.append(r).append(" ").append(c).append(System.lineSeparator());
                }
            }
        }
        if(!isFound){
            System.out.println("not found");
        }

        //System.out.println(result.isEmpty() ? "not found" : result.toString());
    }

    public static int[][] inputMatrix(Scanner scanner, int row,int col){
        int [][] matrix=new int[row][col];
        for(int r=0;r< matrix.length;r++ ){
            for(int c=0;c<matrix[r].length;c++){
                matrix[r][c]= scanner.nextInt();
            }
        }
        return matrix;
    }
}
