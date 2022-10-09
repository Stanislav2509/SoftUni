package com.company;

import java.security.SecureRandom;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex01ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input= scanner.nextLine();
        Map<String, String> wordRevers=new LinkedHashMap<>();

        while (!input.equals("end")){
            String reversWord="";
            for(int i=input.length()-1;i>=0;i--){
                char ch=input.charAt(i);
                reversWord+=ch;
            }
            wordRevers.put(input,reversWord);
            input=scanner.nextLine();
        }
        wordRevers.forEach((k,v)-> System.out.printf("%s = %s%n",k,v));
    }
}
