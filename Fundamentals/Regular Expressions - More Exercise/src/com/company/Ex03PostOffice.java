package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Ex03PostOffice {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String> input= Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
        String capitalLettersRegex="([#$%*&])[A-Z]+\\1";
        Pattern capitalLetterPattern=Pattern.compile(capitalLettersRegex);
        Matcher capitalLetterMatcher= capitalLetterPattern.matcher(input.get(0));
         String capitalLetters = "";
        while (capitalLetterMatcher.find()){
            capitalLetters=capitalLetterMatcher.group().substring(1,capitalLetterMatcher.group().length()-1);
        }

        String asciiCodeRegex="\\d{2}:\\d{2}";
        Pattern asciiCodePattern=Pattern.compile(asciiCodeRegex);
        Matcher asciiCodeMatcher=asciiCodePattern.matcher(input.get(1));
        Map<Integer,Integer >asciiCodeLength=new LinkedHashMap<>();
        while (asciiCodeMatcher.find()){
            String[]result=asciiCodeMatcher.group().split(":");
            if(!asciiCodeLength.containsKey(Integer.valueOf(result[0]))){
                asciiCodeLength.put(Integer.valueOf(result[0]), Integer.valueOf(result[1]));
            }
        }

        List<String> words= Arrays.stream(input.get(2).split("\\s+")).collect(Collectors.toList());

        for(int k=0;k<capitalLetters.toCharArray().length;k++){
            char currentLetter=capitalLetters.charAt(k);
            for(int i=0;i<words.size();i++){
                char firstLetter=words.get(i).charAt(0);
                int length= asciiCodeLength.get((int)currentLetter);
                if(firstLetter == currentLetter && words.get(i).length()==length+1 && !words.get(i).contains(" ") ){
                    System.out.println(words.get(i));
                }
            }
        }
    }
}
