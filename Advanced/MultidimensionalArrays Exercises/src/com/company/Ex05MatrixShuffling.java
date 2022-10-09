package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Ex05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String [] input= scanner.nextLine().split(" ");
        int rows=Integer.parseInt(input[0]);
        int cols=Integer.parseInt(input[1]);
        String [][] matrix=new String[rows][cols];

        for(int r=0;r<matrix.length;r++){
            matrix[r]= (scanner.nextLine().split(" "));
        }

        String command= scanner.nextLine();
        while (!command.equals("END")){
            String [] data=command.split(" ");
            if(data.length==5){
                String operation=data[0];
                int row1=Integer.parseInt(data[1]);
                int col1=Integer.parseInt(data[2]);
                int row2=Integer.parseInt(data[3]);
                int col2=Integer.parseInt(data[4]);
                if(isCorrectCoordinates(matrix,row1,col1) && isCorrectCoordinates(matrix,row2,col2) && operation.equals("swap")){
                    String getNumber1=matrix[row1][col1];
                    String getNumber2=matrix[row2][col2];
                    matrix[row2][col2]=getNumber1;
                    matrix[row1][col1]=getNumber2;
                    for(String []arr:matrix){
                        for(String num:arr){
                            System.out.print(num+" ");
                        }
                        System.out.println();
                    }
                }else {
                    System.out.println("Invalid input!");
                }
            }else {
                System.out.println("Invalid input!");
            }


            command= scanner.nextLine();
        }
    }
    public  static  boolean isCorrectCoordinates(String [][]matrix, int r, int c){
        return r>=0 && r< matrix.length && c>=0 && c< matrix[r].length;
    }
}
