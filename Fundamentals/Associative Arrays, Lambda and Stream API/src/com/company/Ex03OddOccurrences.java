package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Ex03OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String> words= Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        Map<String,Integer> counts=new LinkedHashMap<>();
        for(int i=0;i< words.size();i++){
            if(counts.containsKey(words.get(i).toLowerCase())){
                counts.put(words.get(i).toLowerCase(),counts.get(words.get(i).toLowerCase())+1);
            }else {
                counts.put(words.get(i).toLowerCase(),1);
            }
        }
        List<String>oddCounts=new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if(entry.getValue()%2==1){
                oddCounts.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ",oddCounts));
    }
}
