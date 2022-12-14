package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        String str="e-!btiz=:dmjuvg q>p\"co.yh~%/}a[f^{w`<l&$)*_('x]|n@#+k";
//        for(int i=0;i<str.length();i++){
//            if(str.lastIndexOf(str.charAt(i))!=i){
//                System.out.println("error : "+str.charAt(i));
//            }
//
//        }
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "(?<string>[\\D]*)(?<count>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            int n = Integer.parseInt(matcher.group("count"));
            String word = matcher.group("string").toUpperCase();
            for (int i = 0; i < n; i++) {
                sb.append(word);
            }
        }

        System.out.printf("Unique symbols used: %d%n", sb.chars().distinct().count());
        System.out.println(sb);

    }
}
