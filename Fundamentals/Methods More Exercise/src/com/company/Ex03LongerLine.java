package com.company;

import java.util.Scanner;

public class Ex03LongerLine {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x1=Integer.parseInt(scanner.nextLine());
        int y1=Integer.parseInt(scanner.nextLine());
        int x2=Integer.parseInt(scanner.nextLine());
        int y2=Integer.parseInt(scanner.nextLine());

        int x3=Integer.parseInt(scanner.nextLine());
        int y3=Integer.parseInt(scanner.nextLine());
        int x4=Integer.parseInt(scanner.nextLine());
        int y4=Integer.parseInt(scanner.nextLine());

        printTheLongestVector(x1,y1,x2,y2,x3,y3,x4,y4);

    }

    public static void printTheLongestVector(int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4){
        double lengthOfFirstVector=Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
        double lengthOfSecondVector=Math.sqrt(Math.pow(x4-x3,2)+Math.pow(y4-y3,2));

        if(lengthOfFirstVector<lengthOfSecondVector){
            closestPointToCenter(x3,y3,x4,y4);
        }else if(lengthOfFirstVector>lengthOfSecondVector){
            closestPointToCenter(x1,y1,x2,y2);
        }
        else {
            closestPointToCenter(x1,y1,x2,y2);
        }
    }

    public static void closestPointToCenter(int x1,int y1,int x2,int y2){
        int sumOfCoordinatesOnFirstPoint=Math.abs(x1+y1);
        int sumOfCoordinatesOnSecondPoint=Math.abs(x2+y2);

        if(sumOfCoordinatesOnFirstPoint<sumOfCoordinatesOnSecondPoint){
            System.out.printf("(%d, %d)(%d, %d)",x1,y1,x2,y2);
        }else if(sumOfCoordinatesOnFirstPoint>sumOfCoordinatesOnSecondPoint){
            System.out.printf("(%d, %d)(%d, %d)",x2,y2,x1,y1);
        }else {
            System.out.printf("(%d, %d)(%d, %d)",x1,y1,x2,y2);
        }
    }
}
