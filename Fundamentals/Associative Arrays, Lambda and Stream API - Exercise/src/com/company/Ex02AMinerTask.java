package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex02AMinerTask {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String command= scanner.nextLine();
        Map<String,Integer> resources=new LinkedHashMap<>();
        while (!command.equals("stop")){
            int quantity=Integer.parseInt(scanner.nextLine());
            if (resources.containsKey(command)) {
                resources.put(command,resources.get(command)+ quantity);
            }else {
                resources.put(command,quantity);
            }

            command= scanner.nextLine();
        }
        resources.forEach((key,value)-> System.out.println(key+" -> "+value));
    }
}
