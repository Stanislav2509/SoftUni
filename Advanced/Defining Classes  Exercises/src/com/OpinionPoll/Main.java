package com.OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int countPeople=Integer.parseInt(scanner.nextLine());
        List<Person> people=new ArrayList<>();
        while (countPeople-->0){
            String [] data=scanner.nextLine().split(" ");
            String name =data[0];
            int age=Integer.parseInt(data[1]);
            if(age>30){
                Person person=new Person(name,age);
                people.add(person);
            }
        }
        people.stream().sorted((f,s)->f.getName().compareTo(s.getName()))
                .forEach(person -> System.out.println(person));
    }
}
