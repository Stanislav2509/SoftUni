package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Ex04CountRealNumbers {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Double> numbers= Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());
        Map<Double, Integer> countRepeat= new LinkedHashMap<>();

        for(int i=0;i< numbers.size();i++){
            double curNum=numbers.get(i);
            countRepeat.putIfAbsent(curNum,0);
            countRepeat.put(curNum, countRepeat.get(curNum)+1);
        }
        countRepeat.forEach((key,value)-> System.out.printf("%.1f -> %d%n",key,value));
    }
}
