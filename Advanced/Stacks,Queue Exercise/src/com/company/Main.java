package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        StringBuilder builder = new StringBuilder();
        ArrayDeque<String>stack=new ArrayDeque<>();

        for (int i = 0; i < n; i++)
        {
            String[] input = scanner.nextLine().split(" ");
            int command = Integer.parseInt(input[0]);

            switch (command)
            {
                case 1:
                    builder.append(input[1]);
                    stack.push(builder.toString());
                    break;
                case 2:
                    int number = Integer.parseInt(input[1]);
                    builder.delete(builder.length() - number, builder.length());
                    stack.push(builder.toString());
                    break;
                case 3:
                    int index = Integer.parseInt(input[1]);
                    System.out.println((builder.charAt(index - 1)));
                    break;
                case 4:
                    stack.pop();
                    builder = new StringBuilder();
                    builder.append(stack.peek());
                    break;
            }
        }
    }
}
