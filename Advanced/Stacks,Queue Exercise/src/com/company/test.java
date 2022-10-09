package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayDeque<Character> operators =new ArrayDeque<>();
        ArrayDeque<Character> outputQueue =new ArrayDeque<>();
        char [] data=scanner.next().toCharArray();
        // (x-y/(z+u)*v)
        for(int i=0;i< data.length;i++){
            char ch=data[i];

//if it's an operand, add it to the string
            if (Character.isLetter(ch))
                outputQueue.offer(ch);
               // postfix = postfix + ch;
            else if (ch=='(')
//push (
            {
                operators.push(ch);
            }
            else if (ch==')')
//push everything back to (
            {
                while (operators.peek() != '(')
                {
                    outputQueue.offer(operators.pop());
                }
                operators.pop();        //remove '('
            }
            else
//print operators occurring before it that have greater precedence
            {
                while (!operators.isEmpty() && !(operators.peek()=='(') && prec(ch) <= prec(operators.peek()))
                    outputQueue.offer(operators.pop());
                operators.push(ch);
            }
        }
        while (!operators.isEmpty()){
            outputQueue.offer(operators.pop());
        }
        while (!outputQueue.isEmpty()){
            System.out.print(outputQueue.poll()+" ");
        }
    }
    static int prec(char x)
    {
        if (x == '+' || x == '-')
            return 1;
        if (x == '*' || x == '/' || x == '%')
            return 2;
        return 0;
    }
}
