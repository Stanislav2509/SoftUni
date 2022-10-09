package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex04Orders {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String,Double> quantityProducts=new LinkedHashMap<>();
        Map<String,Double> priceProducts=new LinkedHashMap<>();

        while (!input.equals("buy")){
            String name=input.split(" ")[0];
            double price= Double.parseDouble(input.split(" ")[1]);
            double quantity= Double.parseDouble(input.split(" ")[2]);

            if(!quantityProducts.containsKey(name)){
                quantityProducts.put(name,quantity);
            }else {
                quantityProducts.put(name,quantityProducts.get(name)+ quantity);
            }
            if(!priceProducts.containsKey(name)){
                priceProducts.put(name,price);
            }else {
                priceProducts.replace(name,priceProducts.get(name),price);
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, Double> entry : quantityProducts.entrySet()) {
            Double quantity = quantityProducts.get(entry.getKey());
            Double price = priceProducts.get(entry.getKey());
            double totalPrice=quantity*price;
            System.out.printf("%s -> %.2f%n",entry.getKey(),totalPrice);
        }
    }
}
