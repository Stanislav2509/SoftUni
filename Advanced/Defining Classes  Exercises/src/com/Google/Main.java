package com.Google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        HashMap<String,Person> people=new HashMap<>();

        String input= scanner.nextLine();
        while (!input.equals("End")){
            String [] data=input.split(" ");
            String name=data[0];
            Person person=new Person(name);
            people.putIfAbsent(name,person);
            String type=data[1];

            switch (type){
                case "company":
                    String companyName=data[2];
                    String department=data[3];
                    double salary=Double.parseDouble(data[4]);
                    Company company=new Company(companyName,department,salary);
                    person=people.get(name);
                    person.setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName=data[2];
                    String pokemonType=data[3];
                    Pokemon pokemon=new Pokemon(pokemonName,pokemonType);
                    person=people.get(name);
                    List<Pokemon>pokemonList=person.getPokemons();
                    pokemonList.add(pokemon);
                    person.setPokemons(pokemonList);
                    break;
                case "parents":
                    String parentName=data[2];
                    String birthday=data[3];
                    Relative relative =new Relative(parentName,birthday);
                    person=people.get(name);
                    List<Relative> parents = person.getParents();
                    parents.add(relative);
                    person.setParents(parents);
                    break;
                case "children":
                    String childName=data[2];
                    String childBirthday=data[3];
                    Relative child=new Relative(childName,childBirthday);
                    person=people.get(name);
                    List<Relative> children = person.getChildren();
                    children.add(child);
                    person.setChildren(children);
                    break;
                case "car":
                    String model=data[2];
                    int speed=Integer.parseInt(data[3]);
                    Car car=new Car(model,speed);
                    person=people.get(name);
                    person.setCar(car);
                    break;
            }
            input= scanner.nextLine();
        }
        input= scanner.nextLine();
        Person person=people.get(input);
        System.out.println(person.toString().replaceAll("\\[","")
                .replaceAll("]","").replaceAll(", ","")
                .replaceAll("null",""));
    }
}
