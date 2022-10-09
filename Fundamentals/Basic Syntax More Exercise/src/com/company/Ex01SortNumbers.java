package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex01SortNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int firstNumber=Integer.parseInt(scanner.nextLine());
        int secondNumber=Integer.parseInt(scanner.nextLine());
        int thirdNumber=Integer.parseInt(scanner.nextLine());

        List<Integer> numbers=new ArrayList<>();
        numbers.add(firstNumber);
        numbers.add(secondNumber);
        numbers.add(thirdNumber);
        Collections.sort(numbers);
        Collections.reverse(numbers);

        for (int number:numbers){
            System.out.println(number);
        }
    }
}
