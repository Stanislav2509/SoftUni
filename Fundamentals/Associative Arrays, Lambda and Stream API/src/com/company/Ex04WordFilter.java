package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex04WordFilter {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
       // List<String>words= Arrays.stream(scanner.nextLine().split(" ")).filter(e ->e.length()%2==0).collect(Collectors.toList());
        String[]words= Arrays.stream(scanner.nextLine().split(" ")).filter(e ->e.length()%2==0).toArray(String[]::new);
        System.out.println(String.join(System.lineSeparator(),words));
    }
}
