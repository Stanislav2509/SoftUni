package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Ex03LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Map<String,Integer> legendaryMaterials=new LinkedHashMap<>();
        Map<String,Integer> junkMaterials=new LinkedHashMap<>();
        legendaryMaterials.put("shards",0);
        legendaryMaterials.put("fragments",0);
        legendaryMaterials.put("motes",0);
        List<String> data= Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

       loop: while (true){
            for(int i=0;i<data.size();i+=2){
                int quantity=Integer.parseInt(data.get(i));
                String material= data.get(i+1).toLowerCase(Locale.ROOT);
                if(material.equals("shards")){
                    legendaryMaterials.put(material, legendaryMaterials.get(material)+quantity);
                    if(legendaryMaterials.get(material)>=250){
                        System.out.println("Shadowmourne obtained!");
                        legendaryMaterials.put(material, legendaryMaterials.get(material)-250);break loop;
                    }

                }else if(material.equals("fragments")){
                    legendaryMaterials.put(material, legendaryMaterials.get(material)+quantity);
                    if(legendaryMaterials.get(material)>=250){
                        System.out.println("Valanyr obtained!");
                        legendaryMaterials.put(material, legendaryMaterials.get(material)-250);break loop;
                    }
                }else if(material.equals("motes")){
                    legendaryMaterials.put(material, legendaryMaterials.get(material)+quantity);
                    if(legendaryMaterials.get(material)>=250){
                        System.out.println("Dragonwrath obtained!");
                        legendaryMaterials.put(material, legendaryMaterials.get(material)-250);break loop;
                    }
                }else{
                    if(junkMaterials.containsKey(material)){
                        junkMaterials.put(material, junkMaterials.get(material)+quantity);
                    }else {
                        junkMaterials.put(material, quantity);
                    }
                }
            }
             data= Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        }

        legendaryMaterials.forEach((key,value)-> System.out.println(key+": "+value));
        junkMaterials.forEach((key,value)-> System.out.println(key+": "+value));
    }
}
