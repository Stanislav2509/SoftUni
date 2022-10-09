package com.company;

import java.util.Scanner;

public class Ex03Substring {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String remove= scanner.nextLine();
        String text= scanner.nextLine();

        int startIndex=text.indexOf(remove);
        while (startIndex>=0){
            text=text.replace(remove,"");
            startIndex=text.indexOf(remove);
        }
        System.out.println(text);
    }
}
