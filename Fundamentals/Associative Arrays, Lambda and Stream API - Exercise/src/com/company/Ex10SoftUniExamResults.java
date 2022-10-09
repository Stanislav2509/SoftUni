package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex10SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Map<String, Integer >countRepeatLanguage=new LinkedHashMap<>();
        Map<String, Integer >usernameAndPoint=new LinkedHashMap<>();
        String command= scanner.nextLine();
        while (!command.equals("exam finished")){
            String username=command.split("-")[0];
            String language=command.split("-")[1];

            if(!language.equals("banned")){
                int points=Integer.parseInt(command.split("-")[2]);
                if(usernameAndPoint.containsKey(username)){
                    if(usernameAndPoint.get(username)<points){
                        usernameAndPoint.put(username,points);
                    }
                }else {
                    usernameAndPoint.put(username,points);
                }

                if (countRepeatLanguage.containsKey(language)) {
                    countRepeatLanguage.put(language,countRepeatLanguage.get(language)+1);
                }else {
                    countRepeatLanguage.put(language,1);
                }

            }else {
                usernameAndPoint.remove(username);
            }

            command= scanner.nextLine();
        }
        System.out.println("Results:");
        usernameAndPoint.forEach((key,value)-> System.out.println(key+" | "+value));
        System.out.println("Submissions:");
        countRepeatLanguage.forEach((key,value)-> System.out.println(key+" - "+value));
    }
}
