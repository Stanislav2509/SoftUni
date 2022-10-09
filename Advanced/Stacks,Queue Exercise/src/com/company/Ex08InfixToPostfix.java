package com.company;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Ex08InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayDeque<String> operationStack =new ArrayDeque<>();
        ArrayDeque<String> outputQueue =new ArrayDeque<>();
        String [] data =scanner.nextLine().split(" ");


        // (x-y/(z+u)*v)
        for(int i=0;i< data.length;i++){
            String symbol=data[i];
            if(symbol.equals("*")||symbol.equals("/")){
                while (!operationStack.isEmpty()&&!operationStack.peek().equals("(")
                        &&!operationStack.peek().equals("+")&&!operationStack.peek().equals("-")){
                    outputQueue.offer(operationStack.pop());
                }
                operationStack.push(symbol);

            }else if(symbol.equals("+")||symbol.equals("-")||symbol.equals("(")){
                operationStack.push(symbol);
            }else if(symbol.equals(")")){
                while (!operationStack.peek().equals("(")){
                    outputQueue.offer(operationStack.pop());
                }
                operationStack.pop();
            }
            else {
                outputQueue.offer(symbol);
            }
        }

        while (!operationStack.isEmpty()){
            outputQueue.offer(operationStack.pop());
        }
        while (!outputQueue.isEmpty()){
            System.out.print(outputQueue.poll()+" ");
        }
    }
}
