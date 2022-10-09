package com.company;

import java.util.Scanner;

public class Ex05HTML {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String title= scanner.nextLine();
        String content= scanner.nextLine();
        System.out.printf("<h1>%n   %s%n</h1>%n",title);
        System.out.printf("<article>%n   %s%n</article>%n",content);
        String comment= scanner.nextLine();
        while (!comment.equals("end of comments")){
            System.out.printf("<div>%n   %s%n</div>%n",comment);
            comment=scanner.nextLine();
        }
    }
}
