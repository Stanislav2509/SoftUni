package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Ex06RecursiveFibonacci {
    public static long[] memory;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        ArrayDeque<Long>stack=new ArrayDeque<>();
        stack.push(0l);
        stack.push(1l);
        if(n<2){
            System.out.println(stack.peek());
        }else {
            for(int i=0;i<n;i++){
                long firstNum=stack.pop();
                long secondNum=stack.pop();
                stack.push(firstNum);
                stack.push(firstNum+secondNum);
            }
            System.out.println(stack.peek());
        }



//        memory=new long[n+1];
//        long result=fib(n);
//        System.out.println(result);
    }
    public static long fib(int n){
        if(n<2){
            return 1;
        }
        if(memory[n]!=0){
            return memory[n];
        }
        memory[n]=fib(n-1)+fib(n-2);
        return memory[n];
    }

}
