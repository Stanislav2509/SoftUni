package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex03TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String text= scanner.nextLine();
        String numbers=text.replaceAll("[^0-9]","");
        String nonNumbers=text.replaceAll("[0-9]","");

        List<String> numbersList= Arrays.stream(numbers.split("")).collect(Collectors.toList());
        List<String> nonNumbersList= Arrays.stream(nonNumbers.split("")).collect(Collectors.toList());
        List<String> takeList=new ArrayList<>();
        List<String> skipList=new ArrayList<>();

        StringBuilder result=new StringBuilder();

        for(int i=0;i<numbersList.size();i++){
            if(i%2==0){
                takeList.add(numbersList.get(i));
            }else {
                skipList.add(numbersList.get(i));
            }
        }

        loop:for(int i=0;i<takeList.size();i++){
            int take=Integer.parseInt(takeList.get(i));
            int skip=Integer.parseInt(skipList.get(i));

            for(int k=0;k<take;k++){
                if(k<nonNumbersList.size()){
                    result.append(nonNumbersList.get(k));
                }else {
                    break loop;
                }

            }
            int delete=skip+take;
            for(int j=0;j<delete;j++){
                if(!nonNumbersList.isEmpty()){
                    nonNumbersList.remove(j);
                    j--;
                    delete--;
                }else {
                    break loop;
                }

            }
        }

        String[] resultStr=result.toString().split("");
        for(String item:resultStr){
            System.out.print(item);
        }
    }
}
