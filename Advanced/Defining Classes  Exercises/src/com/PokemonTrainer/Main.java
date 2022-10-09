package com.PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input= scanner.nextLine();
        List<Trainer> trainers=new ArrayList<>();
        while (!input.equals("Tournament")){
            String trainerName=input.split(" ")[0];
            String pokemonName=input.split(" ")[1];
            String pokemonElement=input.split(" ")[2];
            int health=Integer.parseInt(input.split(" ")[3]);
            Pokemon pokemon=new Pokemon(pokemonName,pokemonElement,health);

            if(trainers.isEmpty()){
                Trainer trainer1=new Trainer(trainerName);
                trainer1.getPokemons().add(pokemon);
                trainers.add(trainer1);
            }else {
                boolean isExist=false;
                for (Trainer trainer : trainers) {
                    if(trainer.getName().equals(trainerName)){
                        trainer.getPokemons().add(pokemon);
                        isExist=true;
                        break;
                    }
                }
                if(!isExist){
                    Trainer trainer1=new Trainer(trainerName);
                    trainer1.getPokemons().add(pokemon);
                    trainers.add(trainer1);
                }
            }

            input= scanner.nextLine();
        }

        System.out.println();

        input= scanner.nextLine();
        while (!input.equals("End")){
            int countPokemon=0;
            for (Trainer trainer : trainers) {
                List<Pokemon> pokemonList=trainer.getPokemons();
                for (int i=0;i<pokemonList.size();i++) {
                    if(pokemonList.get(i).getElement().equals(input)){
                        int numberBadges=trainer.getNumberBadges();
                        trainer.setNumberBadges(numberBadges+1);
                        countPokemon++;
                    }else {
                        if(countPokemon==0){
                            pokemonList.get(i).setHealth(pokemonList.get(i).getHealth()-10);
                            if(pokemonList.get(i).getHealth()<=0){
                                pokemonList.remove(pokemonList.get(i));
                                i--;
                            }
                        }
                    }
                }
            }
            input= scanner.nextLine();
        }
        trainers.stream().sorted(Comparator.comparingInt(Trainer::getNumberBadges).reversed())
                .forEach(trainer -> System.out.println(trainer.getName()+" "+trainer.getNumberBadges()+" "+trainer.getPokemons().size()));
    }
}
