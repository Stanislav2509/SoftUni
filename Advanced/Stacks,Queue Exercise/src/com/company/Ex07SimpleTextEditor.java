package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Ex07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayDeque<String> stack=new ArrayDeque<>();
        int countCommands=Integer.parseInt(scanner.nextLine());
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < countCommands; i++)
        {
            String[] input = scanner.nextLine().split(" ");
            int command = Integer.parseInt(input[0]);
            String text;
            switch (command)
            {
                case 1:
                    builder.append(input[1]);
                     text=builder.toString();
                    stack.push(text);
                    break;
                case 2:
                    int number = Integer.parseInt(input[1]);
                    builder.delete(builder.length() - number, builder.length());
                    text=builder.toString();
                    stack.push(text);
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
