package com.company;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex07Crossfire {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String [] sizes= scanner.nextLine().split(" ");
        int rows=Integer.parseInt(sizes[0]);
        int cols=Integer.parseInt(sizes[1]);
        String [][] matrix=new String[rows][cols];

        int count=1;
        for(int r=0;r<matrix.length;r++){
            for(int c=0;c< matrix[r].length;c++){
                matrix[r][c]= String.valueOf(count);
                count++;
            }
        }
        String input= scanner.nextLine();
        while (!input.equals("Nuke it from orbit")){
            int row=Integer.parseInt(input.split(" ")[0]);
            int col=Integer.parseInt(input.split(" ")[1]);
            int rad=Integer.parseInt(input.split(" ")[2]);
                                //>=
            if(row<0 && row+rad>0 && col>=0 && col<cols){
                //go to bottom
                for(int r=row;r<row+rad;r++){
                    if(isCorrectCoordinates(matrix,r,col)){
                        matrix[r][col]=null;
                    }

                }                           //-1
            }else if(row>=rows &&rad<0 && row+rad <rows && col>=0 && col<cols){
                //go to top
                for(int r=row;r>=row+rad;r--){
                    if(isCorrectCoordinates(matrix,r,col)){
                        matrix[r][col]=null;
                    }

                }
            }
            else if(row>=rows &&rad>0 && row-rad <rows && col>=0 && col<cols){
                //go to top
                for(int r=row;r>=row-rad;r--){
                    if(isCorrectCoordinates(matrix,r,col)){
                        matrix[r][col]=null;
                    }
                }
            }else if(col<0 && col+rad>0 && row>=0 && row<rows){
                //go to right
                for(int c=col;c<col+rad;c++){
                    if(isCorrectCoordinates(matrix,row,c)){
                        matrix[row][c]=null;
                    }
                }
            }else if(col>=cols && rad<0 && col+rad<cols && row>=0 && row<rows){{
                //go to left
                for(int c=col;c>=col+rad;c--){
                    if(isCorrectCoordinates(matrix,row,c)){
                        matrix[row][c]=null;
                    }
                }
            }

            }else if(col>=cols && rad>0 && col-rad<cols && row>=0 && row<rows ){
                //go to left
                for(int c=col;c>=col-rad;c--){
                    if(isCorrectCoordinates(matrix,row,c)){
                        matrix[row][c]=null;
                    }
                }
            }else {

                //top
                for(int r=row;r>=row-rad;r--){
                    if(!isCorrectCoordinates(matrix,r,col)){
                        break;
                    }
                    matrix[r][col]=null;
                }
                //bottom
                for(int r=row;r<=row+rad;r++){
                    if(!isCorrectCoordinates(matrix,r,col)){
                        break;
                    }
                    matrix[r][col]=null;
                }
                //right
                for(int c=col;c<=col+rad;c++){
                    if(!isCorrectCoordinates(matrix,row,c)){
                        break;
                    }
                    matrix[row][c]=null;
                }
                //left
                for(int c=col;c>=col-rad;c--){
                    if(!isCorrectCoordinates(matrix,row,c)){
                        break;
                    }
                    matrix[row][c]=null;
                }
            }

            List<String> num=new ArrayList<>();
            for(int r=0;r< matrix.length;r++){
                for(int c=0;c<matrix[r].length;c++){
                    if(matrix[r][c]!=null){
                        num.add(matrix[r][c]);
                        matrix[r][c]=null;
                    }
                }
                for(int i=0;i< num.size();i++){
                    matrix[r][i]=num.get(i);

                }
                num.clear();
            }

            input= scanner.nextLine();
        }
        List<List <Integer>> indexesOnNull=new ArrayList<>();
        for(int r=0;r< matrix.length;r++){
            for(int c=0;c<matrix[r].length;c++){
                if(matrix[r][c]==null){
                    List<Integer> indexes=new ArrayList<>();
                    indexes.add(r);
                    indexes.add(c);
                    indexesOnNull.add(indexes);
                    break;
                }
            }
        }
        for(int r=0;r< matrix.length;r++ ){
            int rowOnNull=-1;
            int colOnNull=-1;
            for(int i=0;i<indexesOnNull.size();i++){
                if(indexesOnNull.get(i).get(0)==r){
                    rowOnNull=r;
                    colOnNull=indexesOnNull.get(i).get(1);
                }
            }
            int lastCol=0;
            if(rowOnNull==-1){
                for (int c=0;c< matrix[r].length-1;c++){
                    System.out.print(matrix[r][c]+" ");
                    lastCol++;
                }
            }else {
                for (int c=0;c< colOnNull-1;c++){
                    System.out.print(matrix[r][c]+" ");
                    lastCol++;
                }
            }
            if(colOnNull!=0){
                System.out.print(matrix[r][lastCol]);
            }

            System.out.println();
        }

    }
    public  static  boolean isCorrectCoordinates(String [][]matrix, int r, int c){
        return r>=0 && r< matrix.length && c>=0 && c< matrix[r].length;
    }
}
