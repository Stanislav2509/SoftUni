package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Ex04MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer>firstList=Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer>secondList=Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer>correctList=new ArrayList<>();

        if(firstList.size()-secondList.size()==2){
            for(int i=0;i< firstList.size()-2;i++){
                correctList.add(firstList.get(i));
                correctList.add(secondList.get(secondList.size()-1-i));
            }

            int firstBorder=firstList.get(firstList.size()-2);
            int secondBorder=firstList.get(firstList.size()-1);
            int startValue=Math.min(firstBorder,secondBorder);
            int endValue=Math.max(firstBorder,secondBorder);

            for(int i=0;i<correctList.size();i++){
                if(startValue>=correctList.get(i)||endValue<=correctList.get(i)){
                    correctList.remove(i);
                    i--;
                }
            }
            Collections.sort(correctList);


        }else if(secondList.size()- firstList.size()==2){
            for(int i=0;i< firstList.size();i++){
                correctList.add(firstList.get(i));
                correctList.add(secondList.get(secondList.size()-1-i));
            }

            int firstBorder=secondList.get(0);
            int secondBorder=secondList.get(1);
            int startValue=Math.min(firstBorder,secondBorder);
            int endValue=Math.max(firstBorder,secondBorder);

            for(int i=0;i<correctList.size();i++){
                if(startValue>=correctList.get(i)||endValue<=correctList.get(i)){
                    correctList.remove(i);
                    i--;
                }
            }
            Collections.sort(correctList);
        }

        for(int number:correctList){
            System.out.print(number+" ");
        }
    }
}
