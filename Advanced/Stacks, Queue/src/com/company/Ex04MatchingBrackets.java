package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Ex04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayDeque<Integer>stack=new ArrayDeque<>();
        String input= scanner.nextLine();
        for(int i=0;i<input.length();i++){
            if (input.charAt(i) == '(') {
                stack.push(i);
            }else if(input.charAt(i) == ')'){
                int endIndex=i;
                int startIndex=stack.pop();
                System.out.println(input.substring(startIndex,endIndex+1));
            }
        }
    }
}
