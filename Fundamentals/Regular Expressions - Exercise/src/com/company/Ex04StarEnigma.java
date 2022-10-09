package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex04StarEnigma {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        String regex="@(?<name>[A-Z][a-z]+)[^@:->!]*:(?<population>[0-9]+)[^@:->!]*\\!(?<attackType>[AD])\\![^@:->!]*->(?<soldier>[0-9]+)";
        Pattern pattern=Pattern.compile(regex);
        Map<String, List<String>>attackTypePlanet=new LinkedHashMap<>();
        attackTypePlanet.put("Attacked",new ArrayList<>());
        attackTypePlanet.put("Destroyed",new ArrayList<>());
        for(int i=0;i<n;i++){
            String messages= scanner.nextLine();
            String decryptMassage=getDecryptMessage(messages);
            Matcher matcher=pattern.matcher(decryptMassage);
            while (matcher.find()){
                String name=matcher.group("name");
                int population=Integer.parseInt(matcher.group("population"));
                String attackType=matcher.group("attackType");
                int countSoldier=Integer.parseInt(matcher.group("soldier"));

                if(attackType.charAt(0)=='A'){
                    attackTypePlanet.get("Attacked").add(name);
                }else if(attackType.charAt(0)=='D'){
                    attackTypePlanet.get("Destroyed").add(name);
                }
            }
        }
        for (Map.Entry<String, List<String>> entry : attackTypePlanet.entrySet()) {
            System.out.printf("%s planets: %d%n",entry.getKey(),entry.getValue().size());
            Collections.sort(entry.getValue());
            for(String planetName: entry.getValue()){
                System.out.printf("-> %s%n",planetName);
            }
        }

    }

    public  static String getDecryptMessage(String massage){
        int countSpecialLetter=getSpecialLettersCount(massage);
        StringBuilder decrypt=new StringBuilder();
        for(int i=0;i<massage.length();i++){
            char letter= (char) (massage.charAt(i)-countSpecialLetter);
            decrypt.append(letter);
        }
        return  decrypt.toString();
    }

    public  static int getSpecialLettersCount(String message){
        int count=0;
        for(char symbol:message.toCharArray()){
            switch (symbol) {
                case 's':
                case't':
                case 'a':
                case'r':
                case 'S':
                case'T':
                case'A':
                case 'R':
                    count++;break;
            }
        }
        return count;
    }
}
