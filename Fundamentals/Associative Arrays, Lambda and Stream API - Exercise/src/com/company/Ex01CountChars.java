package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex01CountChars {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String word= scanner.nextLine();
        Map<Character, Integer> countChar=new LinkedHashMap<>();
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(ch==' '){
                continue;
            }
            if(countChar.containsKey(ch)){
                countChar.put(ch, countChar.get(ch)+1);
            }else {
                countChar.put(ch,1);
            }
        }
        countChar.forEach((key,value)-> System.out.println(key+" -> "+value));
    }
}
