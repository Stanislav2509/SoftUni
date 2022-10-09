package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex06LadyBugs {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int fieldSize=Integer.parseInt(scanner.nextLine());
        int []field=new int[fieldSize];
        int []ladyBugsAllIndexes= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> ladyBugsCorrectIndexes=new ArrayList<>();

        for(int i=0;i<ladyBugsAllIndexes.length;i++){
            if(ladyBugsAllIndexes[i]>=0&&ladyBugsAllIndexes[i]<fieldSize){
                ladyBugsCorrectIndexes.add(ladyBugsAllIndexes[i]);
            }
        }

        for(int i=0;i<ladyBugsCorrectIndexes.size();i++){
           int element= ladyBugsCorrectIndexes.get(i);
           field[element]=1;
        }

        String command=scanner.nextLine();

        while (!command.equals("end")){
            String [] data=command.split(" ");
            int ladyBugsIndex=Integer.parseInt(data[0]);
            String route=data[1];
            int routeLength=Integer.parseInt(data[2]);
            if(route.equals("right")){
                if(ladyBugsIndex>=0 && ladyBugsIndex<fieldSize && field[ladyBugsIndex]!=0){
                    int endPosition=ladyBugsIndex;

                    if(routeLength>0){
                        boolean isEmpty=true;
                        endPosition+=routeLength;
                        if(!isEmptyRightPossition(endPosition,fieldSize,field,ladyBugsIndex,isEmpty)){
                            endPosition+=routeLength;
                            isEmptyRightPossition(endPosition,fieldSize,field,ladyBugsIndex,isEmpty);
                        }

                    }else if(routeLength<0){
                        boolean isEmpty=true;
                        endPosition-=routeLength;
                        if(!isEmptyLeftPossition(endPosition,field,ladyBugsIndex,isEmpty)){
                            endPosition-=routeLength;
                            isEmptyLeftPossition(endPosition,field,ladyBugsIndex,isEmpty);
                        }
                    }
                }

            }else if(route.equals("left")){
                if(ladyBugsIndex>=0 && ladyBugsIndex<fieldSize && field[ladyBugsIndex]!=0){
                    int endPosition=ladyBugsIndex;
                    if(routeLength>0){
                        boolean isEmpty=true;
                        endPosition-=routeLength;
                        if(!isEmptyLeftPossition(endPosition,field,ladyBugsIndex,isEmpty)){
                            endPosition-=routeLength;
                            isEmptyLeftPossition(endPosition,field,ladyBugsIndex,isEmpty);
                        }

                    }else if(routeLength<0){
                        boolean isEmpty=true;
                        endPosition+=Math.abs(routeLength);
                        if(!isEmptyRightPossition(endPosition,fieldSize,field,ladyBugsIndex,isEmpty)){
                            endPosition+=Math.abs(routeLength);
                            isEmptyRightPossition(endPosition,fieldSize,field,ladyBugsIndex,isEmpty);
                        }
                    }
                }
            }

            command=scanner.nextLine();
        }

        for (int i=0;i<field.length;i++){
            if(field[i]!=0){
                System.out.print(1+" ");
            }else {
                System.out.print(0+" ");
            }
        }

    }

    public  static boolean isEmptyRightPossition(int endPosition,int fieldSize,int[]field,int ladyBugsIndex,boolean isEmpty){
        if(endPosition<fieldSize){
            field[ladyBugsIndex]=0;

            if(field[endPosition]==0){
                isEmpty=true;
                field[endPosition]=1;
            }else {
                isEmpty=false;
            }
        }
        else {
            field[ladyBugsIndex]=0;
        }
        return  isEmpty;
    }
    public  static boolean isEmptyLeftPossition(int endPosition, int[]field, int ladyBugsIndex, boolean isEmpty){
        if(endPosition>=0){
            field[ladyBugsIndex]=0;
            if(field[endPosition]==0){
                isEmpty=true;
                field[endPosition]=1;
            }else {
                isEmpty=false;
            }
        }else {
            field[ladyBugsIndex]=0;
        }
        return isEmpty;
    }
}
