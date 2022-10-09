package com.company;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ex02SoftUniParty {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Set<String> reservation=new TreeSet<>();
        String input = scanner.nextLine();
        while (!input.equals("PARTY")){
            reservation.add(input);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("END")){
            reservation.remove(input);
            input = scanner.nextLine();
        }
        System.out.println(reservation.size());
        for(String str: reservation){
            System.out.println(str);
        }
    }
}
