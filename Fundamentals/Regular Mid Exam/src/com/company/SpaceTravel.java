package com.company;

import java.util.Scanner;

public class SpaceTravel {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //Travel 10||Enemy 30||Repair 15||Titan
        String[]input=scanner.nextLine().split("\\|\\|");
        int amountFuel=Integer.parseInt(scanner.nextLine());
        int amountAmmunition=Integer.parseInt(scanner.nextLine());
        String command;
        int element=0;
        loop:    for(int i=0;i<input.length;i++){
            String []route=input[i].split(" ");
            command=route[0];
            if(!command.equals("Titan")){
                element=Integer.parseInt(route[1]);
            }

            switch (command){
                case "Travel":
                    if(amountFuel-element>=0){
                        amountFuel-=element;
                        System.out.printf("The spaceship travelled %d light-years.%n",element);
                    }else {
                        System.out.println("Mission failed.");break loop;
                    }
                    break;
                case "Enemy":
                    if(amountAmmunition>=element){
                        amountAmmunition-=element;
                        System.out.printf("An enemy with %d armour is defeated.%n",element);
                    }else {
                        if(amountFuel-(element*2)>=0){
                            System.out.printf("An enemy with %d armour is outmaneuvered.%n",element);
                            amountFuel-=2*element;
                        }else {
                            System.out.println("Mission failed.");break loop;
                        }
                    }
                    break;
                case "Repair":
                    amountFuel+=element;
                    amountAmmunition+=element*2;
                    System.out.printf("Ammunitions added: %d.%n",element*2);
                    System.out.printf("Fuel added: %d.%n",element);
                    break;
                case "Titan":
                    System.out.println("You have reached Titan, all passengers are safe.");break loop;
            }
        }
    }
}