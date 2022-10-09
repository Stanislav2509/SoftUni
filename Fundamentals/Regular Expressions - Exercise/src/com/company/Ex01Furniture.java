package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex01Furniture {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String regex=">>(?<name>[A-Za-z]+)<<(?<price>\\d+.?\\d*)!(?<quantity>\\d+)";
        String input= scanner.nextLine();
        List<String>products=new ArrayList<>();
        double totalPrice=0;
        while (!input.equals("Purchase")){
            Pattern pattern=Pattern.compile(regex);
            Matcher matcher= pattern.matcher(input);
            if(matcher.find()){
                String name=matcher.group("name");
                double price= Double.parseDouble(matcher.group("price"));
                int quantity= Integer.parseInt(matcher.group("quantity"));
                products.add(name);
                totalPrice+=price*quantity;
            }
            input=scanner.nextLine();
        }

        System.out.println("Bought furniture:");
        for (String product : products) {
            System.out.println(product);
        }
        System.out.printf("Total money spend: %.2f",totalPrice);
    }
}
