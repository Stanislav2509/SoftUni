package com.company;

import java.util.*;

public class Ex02WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int countWords=Integer.parseInt(scanner.nextLine());

        Map<String,List<String >>wordsAndSynonyms=new LinkedHashMap<>();
        for(int i=0;i<countWords;i++){
            List<String> synonymsList=new ArrayList<>();
            String word= scanner.nextLine();
            String synonym= scanner.nextLine();
            if(wordsAndSynonyms.containsKey(word)){
                synonymsList=wordsAndSynonyms.get(word);
                synonymsList.add(synonym);
                wordsAndSynonyms.put(word,synonymsList);
            }else {
                synonymsList.add(synonym);
                wordsAndSynonyms.put(word,synonymsList);
            }
        }
        for (Map.Entry<String, List<String>> entry : wordsAndSynonyms.entrySet()) {
            System.out.printf("%s - %s%n",entry.getKey(),String.join(", ", entry.getValue()));
        }

    }
}
