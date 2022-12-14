package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex09Largest3Numbers{

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> nums= Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted((n1,n2)->n2.compareTo(n1))
                .collect(Collectors.toList());
        if(nums.size()<3){
            for(int num:nums){
                System.out.print(num+" ");
            }
        }else {
                for(int i=0;i<3;i++){
                System.out.print(nums.get(i)+" ");
            }

        }
    }
}
