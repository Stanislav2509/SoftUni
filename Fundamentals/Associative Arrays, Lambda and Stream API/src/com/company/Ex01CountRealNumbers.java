package com.company;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Ex01CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Double> numbers= Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());
        Map<Double,Integer>countNumber=new TreeMap<>();
        for (double num:numbers) {
//            if(countNumber.containsKey(num)){
//                countNumber.put(num, countNumber.get(num)+1);
//            }else {
//                countNumber.put(num,1);
//            }
            countNumber.putIfAbsent(num,0);
            countNumber.put(num, countNumber.get(num)+1);
        }
        for (Map.Entry<Double, Integer> entry : countNumber.entrySet()) {
           // System.out.printf("%.0f -> %d%n",entry.getKey(),entry.getValue());
            DecimalFormat df=new DecimalFormat("#.#######");
            System.out.printf("%s -> %d%n",df.format(entry.getKey()),entry.getValue());
        }

    }
}
