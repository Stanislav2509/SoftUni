package com.company;

import java.util.Scanner;

public class Ex05DecryptingMessages {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int key=Integer.parseInt(scanner.nextLine());
        int lanes=Integer.parseInt(scanner.nextLine());
        char letter,decryptLetter;
        StringBuilder decryptWord= new StringBuilder();
        for(int i=0;i<lanes;i++){
            letter=scanner.nextLine().charAt(0);
            decryptLetter=(char)(letter+key);
            decryptWord.append(decryptLetter);
        }
        System.out.println(decryptWord);
    }
}
