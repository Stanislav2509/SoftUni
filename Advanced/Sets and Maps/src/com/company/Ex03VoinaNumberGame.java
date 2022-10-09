package com.company;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex03VoinaNumberGame {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Set<Integer> firstDeck= Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> secondDeck= Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int round=50;
        while (round-->0){
            int firstCard=firstDeck.stream().iterator().next();
            firstDeck.remove(firstCard);

            int secondCard=secondDeck.stream().iterator().next();
            secondDeck.remove(secondCard);

            if(firstCard>secondCard){
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);

            }else if(secondCard>firstCard){
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);

            }

            if(firstDeck.isEmpty()|| secondDeck.isEmpty()){
                break;
            }
        }

        if(firstDeck.size()> secondDeck.size()){
            System.out.println("First player win!");
        }else if(secondDeck.size()> firstDeck.size()) {
            System.out.println("Second player win!");
        }else {
            System.out.println("Draw");
        }
    }
}
