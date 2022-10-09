package com.company;

import java.util.Scanner;

public class Ex03GamingStore {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double currentBalance=Double.parseDouble(scanner.nextLine());
        String gameName= scanner.nextLine();
        double spentMoney=0;

        while (!gameName.equals("Game Time")){
            if(hasHeThisGame(gameName)){
                if(currentBalance<findGamePrice(gameName)){
                    System.out.println("Too Expensive");
                }
                else {
                    System.out.println("Bought "+gameName);
                    spentMoney+=findGamePrice(gameName);
                    currentBalance-=findGamePrice(gameName);
                }
            }else {
                System.out.println("Not Found");
            }
            if(currentBalance==0){
                System.out.println("Out of money!");break;
            }
            gameName= scanner.nextLine();
        }

//        while (!gameName.equals("Game Time")){
//            if(gameName.equals("OutFall 4") || gameName.equals("CS: OG") || gameName.equals("Zplinter Zell")
//                    || gameName.equals("Honored 2") || gameName.equals("RoverWatch") || gameName.equals("RoverWatch Origins Edition")){
//                switch (gameName){
//                    case "OutFall 4":
//                        if(currentBalance<39.99){
//                            System.out.println("Too Expensive");
//                        }else {
//                            currentBalance-=39.99;
//                            System.out.println("Bought "+gameName);
//                            spentMoney+=39.99;
//                        }
//
//                        break;
//                    case "CS: OG":
//                        if(currentBalance<15.99){
//                            System.out.println("Too Expensive");
//                        }else {
//                            currentBalance-=15.99;
//                            System.out.println("Bought "+gameName);
//                            spentMoney+=15.99;
//                        }
//                        break;
//                    case "Zplinter Zell":
//                        if(currentBalance<19.99){
//                            System.out.println("Too Expensive");
//                    }else {
//                        currentBalance-=19.99;
//                             System.out.println("Bought "+gameName);
//                             spentMoney+=19.99;
//                    }
//                        break;
//                    case "Honored 2":
//                        if(currentBalance<59.99){
//                            System.out.println("Too Expensive");
//                        }else {
//                            currentBalance-=59.99;
//                            System.out.println("Bought "+gameName);
//                            spentMoney+=59.99;
//                        }
//                        break;
//                    case "RoverWatch":
//                        if(currentBalance<29.99){
//                            System.out.println("Too Expensive");
//                        }else {
//                            currentBalance-=29.99;
//                            System.out.println("Bought "+gameName);
//                            spentMoney+=29.99;
//                        }
//                        break;
//                    case "RoverWatch Origins Edition":
//                        if(currentBalance<39.99){
//                            System.out.println("Too Expensive");
//                        }else {
//                            currentBalance-=39.99;
//                            System.out.println("Bought "+gameName);
//                            spentMoney+=39.99;
//                        }
//                        break;
//                }
//            }
//            else {
//                System.out.println("Not Found");
//            }
//
//            if(currentBalance==0){
//                System.out.println("Out of money!");break;
//            }
//            gameName= scanner.nextLine();
//
//        }
        if(currentBalance>0){
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", spentMoney,currentBalance);
        }
    }

    public static boolean hasHeThisGame(String name){
        boolean flag=false;
        if(name.equals("OutFall 4") || name.equals("CS: OG") || name.equals("Zplinter Zell")
                || name.equals("Honored 2") || name.equals("RoverWatch") || name.equals("RoverWatch Origins Edition")){
            flag=true;
        }
        return flag;
    }

    public static double findGamePrice(String name) {
        double gamePrice = 0;
        switch (name) {
            case "OutFall 4":
                gamePrice = 39.99;
                break;
            case "CS: OG":
                gamePrice = 15.99;
                break;
            case "Zplinter Zell":
                gamePrice = 19.99;
                break;
            case "Honored 2":
                gamePrice = 59.99;
                break;
            case "RoverWatch":
                gamePrice = 29.99;
                break;
            case "RoverWatch Origins Edition":
                gamePrice = 39.99;
                break;
        }
        return gamePrice;
    }
}
