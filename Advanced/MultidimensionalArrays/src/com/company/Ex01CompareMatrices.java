package com.company;

import java.util.Scanner;

public class Ex01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int row= scanner.nextInt();
        int col= scanner.nextInt();
        int[][] firstMatrix=inputMatrix(scanner,row,col);

        row= scanner.nextInt();
        col= scanner.nextInt();
        int [][] secondMatrix=inputMatrix(scanner,row,col);

        System.out.println(areMatrixEqual(firstMatrix,secondMatrix) ? "equal" : "not equal");
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

    public  static  boolean areMatrixEqual(int[][] firstMatrix,int[][] secondMatrix){
        if(firstMatrix.length!= secondMatrix.length){
           return false;
        }
        for(int i=0;i< firstMatrix.length;i++){
            int[] firstArr=firstMatrix[i];
            int [] secondArr=secondMatrix[i];
            if(firstArr.length!=secondArr.length){
                return false;
            }
            for(int k=0;k<firstArr.length;k++){
                if(firstArr[k]!=secondArr[k]){
                   return false;
                }
            }
        }
        return true;
    }
}
