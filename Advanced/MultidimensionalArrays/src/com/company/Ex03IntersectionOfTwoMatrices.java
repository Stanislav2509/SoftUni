package com.company;

import java.util.Scanner;

public class Ex03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int row= scanner.nextInt();
        int col= scanner.nextInt();
        String[][] firstMatrix=inputMatrix(scanner,row,col);

        String [][] secondMatrix=inputMatrix(scanner,row,col);

       String[][]searchedMatrix= searchedMatrix(firstMatrix,secondMatrix,row,col);

       for(int i=0;i< searchedMatrix.length;i++){
           for(int k=0;k<searchedMatrix[i].length;k++){
               System.out.print(searchedMatrix[i][k]+" ");
           }
           System.out.println();
       }
    }

    public static String[][] inputMatrix(Scanner scanner, int row,int col){
        String [][] matrix=new String[row][col];
        for(int r=0;r< matrix.length;r++ ){
            for(int c=0;c<matrix[r].length;c++){
                matrix[r][c]= scanner.next();
            }
        }
        return matrix;
    }

    public  static  String[][] searchedMatrix(String[][] firstMatrix, String[][] secondMatrix,int row,int col){
        String[][] matrix=new String[row][col] ;
        for(int i=0;i< firstMatrix.length;i++){
            String[] firstArr=firstMatrix[i];
            String [] secondArr=secondMatrix[i];
            for(int k=0;k<firstArr.length;k++){
                if(!firstArr[k].equals(secondArr[k]) ){
                    matrix[i][k]="*";
                }else {
                    matrix[i][k]=secondArr[k];
                }
            }
        }
        return matrix;
    }
}
