package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Ex01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayDeque<String>stack=new ArrayDeque<>();
        String input = scanner.nextLine();
        String currentURl=null;
        while (!input.equals("Home")){

            if(input.equals("back")){
                if(stack.isEmpty()){
                    System.out.println("no previous URLs");
                    input= scanner.nextLine();
                    continue;
                }else {
                    currentURl= stack.pop();
                }
            }
            else {
                if(currentURl!=null){
                    stack.push(currentURl);
                }
                currentURl=input;

            }
            System.out.println(currentURl);
            input= scanner.nextLine();
        }
    }
}
