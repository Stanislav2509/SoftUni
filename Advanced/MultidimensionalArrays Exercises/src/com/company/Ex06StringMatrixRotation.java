package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int rotation=Integer.parseInt(scanner.nextLine().split("[()]")[1]);
        int degree=rotation%360;
        List<String> words=new ArrayList<>();
        String word= scanner.nextLine();
        int maxLength=0;
        while (!word.equals("END")){
            words.add(word);
            if(word.length()>maxLength){
                maxLength=word.length();
            }
            word= scanner.nextLine();
        }

        char[][]matrix=new char[words.size()][maxLength];
        for(int r=0;r< matrix.length;r++){
            for(int c=0;c< words.get(r).length();c++){
                char ch=words.get(r).charAt(c);
                matrix[r][c]=ch;
                }
            if(words.get(r).length()<maxLength){
                for(int i=words.get(r).length();i<maxLength;i++){
                    matrix[r][i]=' ';
            }
            }
        }

        switch (degree){
            case 0:
                for(char []arr:matrix){
                    for(char ch:arr){
                        System.out.print(ch);
                    }
                    System.out.println();
                }
                break;
            case 90:
                for(int c=0;c<maxLength;c++){
                    for(int r=matrix.length-1;r>=0;r--){
                        System.out.print(matrix[r][c]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for(int r= matrix.length-1;r>=0;r--){
                    for(int c=matrix[r].length-1;c>=0;c--){
                        System.out.print(matrix[r][c]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                for(int c=maxLength-1;c>=0;c--){
                    for(int r=0;r<matrix.length;r++){
                        System.out.print(matrix[r][c]);
                    }
                    System.out.println();
                }
                break;
        }

    }
}
