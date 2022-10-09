package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex04MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String>input= Arrays.stream(scanner.nextLine().split("\\s+\\|\\s+")).collect(Collectors.toList());
        String result ="";
        for(int i=0;i<input.size();i++){
            List<String>words=Arrays.stream(input.get(i).split("\\s+")).collect(Collectors.toList());
            for(int k=0;k<words.size();k++){
                result+=getLetterFromMorseCode(words.get(k));
            }
            result+=" ";
        }
        System.out.println(result);
    }
        
    
    public  static char getLetterFromMorseCode(String code){
        char letter = 0;
        switch (code){
            case ".-":
                letter='A';break;
            case "-...":
                letter='B';break;
            case "-.-.":
                letter='C';break;
            case "-..":
                letter='D';break;
            case ".":
                letter='E';break;
            case "..-.":
                letter='F';break;
            case "--.":
                letter='G';break;
            case "....":
                letter='H';break;
            case "..":
                letter='I';break;
            case ".---":
                letter='J';break;
            case "-.-":
                letter='K';break;
            case ".-..":
                letter='L';
                break;
            case "--":
                letter='M';break;
            case "-.":
                letter='N';break;
            case "---":
                letter='O';break;
            case ".--.":
                letter='P';break;
            case "--.-":
                letter='Q';break;
            case ".-.":
                letter='R';break;
            case "...":
                letter='S';break;
            case "-":
                letter='T';break;
            case "..-":
                letter='U';break;
            case "...-":
                letter='V';break;
            case ".--":
                letter='W';break;
            case "-..-":
                letter='X';break;
            case "-.--":
                letter='Y';break;
            case "--..":
                letter='Z';break;
           
        }
        return letter;
    }
}
