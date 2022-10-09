package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Ex03TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer>keys= Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input= scanner.nextLine();
        int countRepeat=0;
        String result="";
        Map<String ,String>typeAndCoordinates=new LinkedHashMap<>();
        while (!input.equals("find")){
            for(int i=0;i<input.length();i++){
                char letter=input.charAt(i);
                int codeLetter=0;
                if(i>=keys.size()){
                    countRepeat= i/keys.size();
                    int key=keys.get(i- (keys.size()* countRepeat));
                    codeLetter=letter-key;
                }else {
                    codeLetter=letter-keys.get(i);
                }
                result+=(char)codeLetter;
            }
            int startIndex=result.indexOf("&");
            int lastIndex=result.lastIndexOf("&");
            String type=result.substring(startIndex+1,lastIndex);
            startIndex=result.indexOf("<");
            lastIndex=result.lastIndexOf(">");
            String coordinates=result.substring(startIndex+1,lastIndex);
            typeAndCoordinates.put(type,coordinates);

            result="";
            input= scanner.nextLine();
        }
        typeAndCoordinates.forEach((k,v)-> System.out.printf("Found %s at %s%n",k,v));
    }
}
