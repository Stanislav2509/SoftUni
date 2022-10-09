package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ex06ProductShop {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Map<String, Map<String,Double>> magazineProducts=new TreeMap<>();
        String input =scanner.nextLine();

        while (!input.equals("Revision")){
            String name=input.split(", ")[0];
            String product=input.split(", ")[1];
            double price=Double.parseDouble(input.split(", ")[2]);

            magazineProducts.putIfAbsent(name,new LinkedHashMap());
            Map<String,Double> products=magazineProducts.get(name);
            products.putIfAbsent(product,price);

            input =scanner.nextLine();
        }

        for(var entry:magazineProducts.entrySet()){
            String name= entry.getKey();
            System.out.println(name+"->");
            Map<String,Double> products= entry.getValue();
            for(var e:products.entrySet()){
                System.out.printf("Product: %s, Price: %.1f%n",e.getKey(),e.getValue());
            }
        }
    }
}
