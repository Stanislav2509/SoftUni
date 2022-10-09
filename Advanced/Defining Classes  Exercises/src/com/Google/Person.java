package com.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Pokemon> pokemons;
    private List<Relative> parents;
    private List<Relative> children;

    public Person(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Relative> getParents() {
        return parents;
    }

    public void setParents(List<Relative> parents) {
        this.parents = parents;
    }

    public List<Relative> getChildren() {
        return children;
    }

    public void setChildren(List<Relative> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return  name + "\n" +
                "Company:"+ "\n" + company +
                "Car:"+ "\n" + car +
                "Pokemon:"+ "\n" + pokemons +
                "Parents: "+ "\n" + parents +
                "Children: "+ "\n" + children;
    }
}
