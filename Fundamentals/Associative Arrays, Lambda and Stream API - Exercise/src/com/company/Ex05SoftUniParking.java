package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex05SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        Map<String, String> ownerPlateNumbers=new LinkedHashMap<>();

        for(int i=0;i<n;i++){
            String input = scanner.nextLine();
            String command= input.split(" ")[0];
            String username= input.split(" ")[1];
            if(command.equals("register")){
                String carPlateNumber= input.split(" ")[2];
                if(ownerPlateNumbers.containsKey(username)){
                    System.out.printf("ERROR: already registered with plate number %s%n",ownerPlateNumbers.get(username));
                }else {
                    System.out.printf("%s registered %s successfully%n",username,carPlateNumber);
                    ownerPlateNumbers.put(username,carPlateNumber);
                }
            }else {
                if(!ownerPlateNumbers.containsKey(username)){
                    System.out.printf("ERROR: user %s not found%n",username);
                }else {
                    System.out.printf("%s unregistered successfully%n",username);
                    ownerPlateNumbers.remove(username);
                }
            }
        }
        ownerPlateNumbers.forEach((key,value)-> System.out.printf("%s => %s%n",key,value));
    }
}
