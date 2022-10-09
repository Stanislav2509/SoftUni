package com.company;

import java.util.Scanner;

public class Ex07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[][] matrix=new String[8][8];
        for (int i=0;i< matrix.length;i++){
            matrix[i]=scanner.nextLine().split(" ");
        }
        int countRepeat=0;
        boolean isCorrectQueen=true;
        int row=0,col=0;
       loop: for(int r=0;r< matrix.length;r++){
            for(int c=0;c<matrix[r].length;c++){
                if(matrix[r][c].equals("q")){
                    row=r;
                    col=c;
                    isCorrectQueen=true;
                    countRepeat=0;

                    isCorrectQueen = searchHorizontally(matrix, countRepeat, isCorrectQueen, r);

                    if(isCorrectQueen){
                       countRepeat=0;
                        isCorrectQueen = searchVertically(matrix, countRepeat, isCorrectQueen, c);
                    }

                    if(r>0 && c>0 && isCorrectQueen){
                        //do gore v lqvo
                        isCorrectQueen = topLeftDiagonal(matrix, isCorrectQueen, row, col);

                    }
                    if(r>0 && c<matrix[r].length-1 && isCorrectQueen){
                        //do gore v dqsno
                        isCorrectQueen = topRightDiagonal(matrix, isCorrectQueen, row, col, matrix[r]);
                    }

                    if(r< matrix.length-1 && c>0 && isCorrectQueen){
                        //do dolu v lqvo
                        isCorrectQueen = bottomLeftDiagonal(matrix, isCorrectQueen, row, col);
                    }

                    if(r< matrix.length-1 && c<matrix[r].length-1 && isCorrectQueen){
                        //do dolu v dqsno
                        isCorrectQueen = bottomRightDiagonal(matrix, isCorrectQueen, row, col, matrix[r]);
                    }
                    if(isCorrectQueen){
                        System.out.println(r+" "+c);
                        break loop;
                    }

                }

            }
        }
    }

    private static boolean bottomRightDiagonal(String[][] matrix, boolean isCorrect, int row, int col, String[] matrix1) {
        for(int i = row+1, k = col+1; i< matrix.length && k< matrix1.length; i++,k++){
            if(matrix[i][k].equals("q")){
                isCorrect=false;
            }
        }
        return isCorrect;
    }

    private static boolean bottomLeftDiagonal(String[][] matrix, boolean isCorrect, int row, int col) {
        for(int i = row +1, k = col -1; i< matrix.length && k>=0; i++,k--){
            if(matrix[i][k].equals("q")){
                isCorrect =false;
            }
        }
        return isCorrect;
    }

    private static boolean topRightDiagonal(String[][] matrix, boolean isCorrect, int row, int col, String[] matrix1) {
        for(int i = row-1, k = col+1; i>=0 && k< matrix1.length; i--,k++){
            if(matrix[i][k].equals("q")){
                isCorrect=false;
            }
        }
        return isCorrect;
    }

    private static boolean topLeftDiagonal(String[][] matrix, boolean isCorrect, int row, int col) {
        for(int i = row -1, k = col -1; i>=0&&k>=0; i--,k--){
            if(matrix[i][k].equals("q")){
                isCorrect =false;
            }
        }
        return isCorrect;
    }

    private static boolean searchVertically(String[][] matrix, int countRepeat, boolean isCorrect, int c) {
        for(int i = 0; i< matrix.length; i++){
            if(matrix[i][c].equals("q")){
                countRepeat++;
            }
            if(countRepeat >1){
                isCorrect =false;
            }
        }
        return isCorrect;
    }

    private static boolean searchHorizontally(String[][] matrix, int countRepeat, boolean isCorrect, int r) {
        for(int i = 0; i< matrix[r].length; i++){
            if(matrix[r][i].equals("q")){
                countRepeat++;
            }
            if(countRepeat >1){
               isCorrect =false;
               break ;
            }
        }
        return isCorrect;
    }
}
