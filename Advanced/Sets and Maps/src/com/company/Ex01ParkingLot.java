package com.company;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex01ParkingLot {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Set<String> carNumbers=new LinkedHashSet<>();
        String input=scanner.nextLine();
        while (!input.equals("END")){
            String move=input.split(", ")[0];
            String carNumber=input.split(", ")[1];
            if (move.equals("IN")) {
                carNumbers.add(carNumber);
            } else {
                carNumbers.remove(carNumber);
            }

            input=scanner.nextLine();
        }
        if(carNumbers.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            for(String str: carNumbers){
                System.out.println(str);
            }
        }

    }
}
