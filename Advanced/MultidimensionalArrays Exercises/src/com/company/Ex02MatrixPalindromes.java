package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Ex02MatrixPalindromes {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] sizes= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String [][] matrix=new String[sizes[0]][sizes[1]];

        for(int r=0;r<matrix.length;r++){
            for(int c=0;c<matrix[r].length;c++){
                char borderChar=(char)('a'+r);
                char middleChar=(char)('a'+r+c);
                matrix[r][c]=""+borderChar+middleChar+borderChar;
            }
        }
        for(String []arr:matrix){
            for(String num:arr){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}
