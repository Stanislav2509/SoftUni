package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Ex05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayDeque<Character> stack=new ArrayDeque<>();
        String input= scanner.nextLine();
        boolean isValid=true;
        for(int i=0;i<input.length();i++){
            char currentBracket = input.charAt(i);
            if(currentBracket==')'|| currentBracket=='}'|| currentBracket==']'){
                if(stack.isEmpty()){
                    isValid=false;break;
                }
                char lastBracket=stack.pop();
                if(lastBracket=='(' && currentBracket!=')'){
                    isValid=false;
                    break;
                }else if(lastBracket=='{' && currentBracket!='}'){
                    isValid=false;
                    break;
                }else if(lastBracket=='[' && currentBracket!=']'){
                    isValid=false;
                    break;
                }
            }else {
                stack.push(currentBracket);
            }
        }
        if(isValid&&stack.isEmpty()){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
