package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Ex05NetherRealms {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String>demonNames= Arrays.stream(scanner.nextLine().split(",\\s*")).collect(Collectors.toList());
        String healthRegex="[^\\d./+*, -]";
        Pattern healthPattern=Pattern.compile(healthRegex);
        String damageRegex="[-]?\\d+\\.?\\d*";
        Pattern damagePattern=Pattern.compile(damageRegex);
        String arithmeticRegex="[*/]";
        Pattern arithmeticPattern=Pattern.compile(arithmeticRegex);
        for (String name:demonNames){
            name=name.replace(" ","");
            int health=0;
            double damage=0;
            Matcher healthMatcher= healthPattern.matcher(name);
            while (healthMatcher.find()){
                String chars= healthMatcher.group();
                for(char symbol:chars.toCharArray()){
                    health+=symbol;
                }
            }

            Matcher damageMatcher=damagePattern.matcher(name);
            while (damageMatcher.find()){
                damage+=Double.parseDouble(damageMatcher.group());
            }

            Matcher arithmeticMatcher=arithmeticPattern.matcher(name);
            while (arithmeticMatcher.find()){
                String symbols=arithmeticMatcher.group();
                for(char symbol:symbols.toCharArray()){
                    if(symbol=='*'){
                        damage*=2;
                    }else{
                        damage/=2;
                    }
                }
            }
            System.out.printf("%s - %d health, %.2f damage%n",name,health,damage);
        }
    }
}
