package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String>words= Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        int sum=0;
        if(words.get(0).length()>words.get(1).length()){
           sum= sumCharacters(words.get(1),words.get(0));
        }else {
            sum=sumCharacters(words.get(0),words.get(1));
        }

        System.out.println(sum);
    }
    public static int sumCharacters(String smallString,String bigString){
        int sum=0;
        int lastIndex = 0;
        for(int i=0;i<smallString.length();i++){
            sum+=smallString.charAt(i)*bigString.charAt(i);
            lastIndex=i+1;
        }
        for(int i=lastIndex;i<bigString.length();i++){
            sum+=bigString.charAt(i);
        }
        return sum;
    }
}
