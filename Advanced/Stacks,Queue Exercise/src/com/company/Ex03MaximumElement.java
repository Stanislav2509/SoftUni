package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Ex03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayDeque<Integer>stack=new ArrayDeque<>();
        int countCommands=Integer.parseInt(scanner.nextLine());
        for(int i=0;i<countCommands;i++){
            String[]input=scanner.nextLine().split(" ");
            int command=Integer.parseInt(input[0]);
            switch (command){
                case 1:
                    int number=Integer.parseInt(input[1]);
                    stack.push(number);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    int maxNum=stack.stream().mapToInt(e->e).max().getAsInt();
                    System.out.println(maxNum);
                    break;

            }
        }
    }
}
