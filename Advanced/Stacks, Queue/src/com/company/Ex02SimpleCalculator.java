package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        List<String> input= Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        int result=0;
        int firstNum=0;
        int secondNum=0;
        for(int i=0;i< input.size()-1;i++){
            String symbols=input.get(i);
            if ( symbols.equals("+")) {
                firstNum=stack.pop();
                secondNum=Integer.parseInt(String.valueOf(input.get(i+1)));
                result=firstNum+secondNum;
                stack.push(result);
                i++;
            }else if(symbols.equals("-")){
                firstNum=stack.pop();
                secondNum=Integer.parseInt(String.valueOf(input.get(i+1))) ;
                result=firstNum-secondNum;
                stack.push(result);
                i++;
            }else {
                int num= Integer.parseInt((symbols));
                stack.push(num);
            }
        }
        System.out.println(stack.peek());
    }
}
