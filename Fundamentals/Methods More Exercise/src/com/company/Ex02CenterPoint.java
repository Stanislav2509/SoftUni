package com.company;

import java.util.Scanner;

public class Ex02CenterPoint {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x1=Integer.parseInt(scanner.nextLine());
        int y1=Integer.parseInt(scanner.nextLine());
        int x2=Integer.parseInt(scanner.nextLine());
        int y2=Integer.parseInt(scanner.nextLine());

        closestPointToCenter(x1,y1,x2,y2);
    }

    public static void closestPointToCenter(int x1,int y1,int x2,int y2){
        int sumOfCoordinatesOnFirstPoint=Math.abs(x1+y1);
        int sumOfCoordinatesOnSecondPoint=Math.abs(x2+y2);

        if(sumOfCoordinatesOnFirstPoint<sumOfCoordinatesOnSecondPoint){
            System.out.printf("(%d, %d)",x1,y1);
        }else if(sumOfCoordinatesOnFirstPoint>sumOfCoordinatesOnSecondPoint){
            System.out.printf("(%d, %d)",x2,y2);
        }else {
            System.out.printf("(%d, %d)",x1,y1);
        }
    }
}
