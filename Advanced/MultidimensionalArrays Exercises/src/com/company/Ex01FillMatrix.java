package com.company;

import java.util.Scanner;

public class Ex01FillMatrix {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String [] input= scanner.nextLine().split(", ");
        int size=Integer.parseInt(input[0]);
        String type=input[1];
        int [][] matrix=new int[size][size];
        int count=1;

        if(type.equals("A")){
            for(int c=0;c<matrix[size-1].length;c++){
                for(int r=0;r< matrix.length;r++){
                    matrix[r][c]=count;
                    count++;
                }
            }
        }else {
            for(int c=0;c<matrix[size-1].length;c++){
                if(c%2==0){
                    for(int r=0;r< matrix.length;r++){
                        matrix[r][c]=count;
                        count++;
                    }
                }else {
                    for(int r=matrix.length-1;r>=0;r--){
                        matrix[r][c]=count;
                        count++;
                    }
                }

            }
        }

        for(int []arr:matrix){
            for(int num:arr){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

}
