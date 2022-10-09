package com.company;

import java.util.*;

public class Ex07CitiesByContinentAndCountry {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Map<String, Map<String,List<String>>> continents=new LinkedHashMap<>();
        int n=Integer.parseInt(scanner.nextLine());
        while (n-->0){
            String input= scanner.nextLine();
            String continent=input.split(" ")[0];
            String country=input.split(" ")[1];
            String city=input.split(" ")[2];

            continents.putIfAbsent(continent,new LinkedHashMap<>());

            Map<String,List<String>> countries=continents.get(continent);
            countries.putIfAbsent(country,new ArrayList<>());
            List<String> cities=countries.get(country);
            cities.add(city);
            countries.put(country,cities);
        }

        for(var entry:continents.entrySet()){
            String name= entry.getKey();
            System.out.println(name+":");
            Map<String,List<String>> countries= entry.getValue();
            for(var e:countries.entrySet()){
                String cities=String.join(", ",e.getValue());
                System.out.printf("  %s -> %s",e.getKey(),cities);
                System.out.println();
            }
        }
    }
}
