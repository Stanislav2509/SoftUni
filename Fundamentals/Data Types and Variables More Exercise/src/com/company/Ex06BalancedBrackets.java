package com.company;

import java.util.Scanner;

public class Ex06BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int countLines=Integer.parseInt(scanner.nextLine());
        String input="";
        int openedBrackets=0,closedBrackets=0;
        char letter;
        for(int i=0;i<countLines;i++){
            input= scanner.nextLine();

            for(int k=0;k<input.length();k++){
                letter=input.charAt(k);

                if(letter==40){
                    openedBrackets++;
                }else if(letter==41){
                    closedBrackets++;
                    if(closedBrackets>openedBrackets){
                        System.out.println("UNBALANCED");return;
                    }
                }
            }


        }
        if(openedBrackets==closedBrackets){
            System.out.println("BALANCED");
        }else {
            System.out.println("UNBALANCED");
        }
    }
}
