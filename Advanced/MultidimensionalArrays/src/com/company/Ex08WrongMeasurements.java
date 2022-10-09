package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int size=Integer.parseInt(scanner.nextLine());
        int [][] matrix=new int[size][];
        for(int i=0;i<matrix.length;i++){
            matrix[i]= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[] coordinates=Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int searchedNumber=matrix[coordinates[0]][coordinates[1]];

        List<int[]>dataList=new ArrayList<>();
        int []data=new int[3];
        for(int r=0;r<matrix.length;r++){
            for(int c=0;c<matrix[r].length;c++){
                if(matrix[r][c]==searchedNumber){
                    data=new int[3];
                    data[0]=r;
                    data[1]=c;
                    data[2]=getSum(matrix,r,c,searchedNumber);
                    dataList.add(data);
                }
            }
        }
        for(int i=0;i<dataList.size();i++){
            int [] currData=dataList.get(i);
            int row=currData[0];
            int col=currData[1];
            int sum=currData[2];
            matrix[row][col]=sum;
        }
        for(int [] row:matrix){
            for (int num:row){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
    public static  int getSum(int[][] matrix, int r , int c , int searchedNumber){
        int sum=0;
        if(isInBound(matrix,r+1,c) && matrix[r+1][c]!=searchedNumber){
            sum+=matrix[r+1][c];
        }
        if(isInBound(matrix,r-1,c) &&matrix[r-1][c]!=searchedNumber ){
            sum+=matrix[r-1][c];
        }
        if(isInBound(matrix,r,c+1) &&matrix[r][c+1]!=searchedNumber){
            sum+=matrix[r][c+1];
        }
        if(isInBound(matrix,r,c-1)&& matrix[r][c-1]!=searchedNumber){
            sum+=matrix[r][c-1];
        }
        return sum;
    }

    public  static  boolean isInBound(int[][]matrix,int r,int c){
        return r>=0 && r< matrix.length && c>=0 && c< matrix[r].length;
    }

}
