package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex04TextFilter {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String>banList= Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String text=scanner.nextLine();

        for(String s:banList){
            String replacement="";
            for(int i=0;i<s.length();i++){
                replacement+="*";
            }
            text=text.replace(s,replacement);
        }
        System.out.println(text);
    }
}
