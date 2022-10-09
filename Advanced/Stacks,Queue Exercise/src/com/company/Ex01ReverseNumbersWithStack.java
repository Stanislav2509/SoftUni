package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex01ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String> numbers= Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        ArrayDeque<String> stackNumbers=new ArrayDeque<>();
        for(int i=0;i< numbers.size();i++){
            stackNumbers.push(numbers.get(i));
        }
        while (!stackNumbers.isEmpty()){
            System.out.print(stackNumbers.pop()+" ");
        }
    }
}
