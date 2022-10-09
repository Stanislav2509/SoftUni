package com.company;

import java.util.Scanner;

public class CookingMasterclass {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double budget=Double.parseDouble(scanner.nextLine());
        int students=Integer.parseInt(scanner.nextLine());
        double pricePackageFlour=Double.parseDouble(scanner.nextLine());
        double priceSingleEgg=Double.parseDouble(scanner.nextLine());
        double priceSingleApron=Double.parseDouble(scanner.nextLine());

        double moneyForFlour=pricePackageFlour*(students-students/5);
        double moneyForEgg=priceSingleEgg*students*10;
        double moneyForApron=priceSingleApron*(students+Math.ceil(students*0.2));

        double cost=moneyForApron+moneyForEgg+moneyForFlour;

        if(cost<=budget){
            System.out.printf("Items purchased for %.2f$.",cost);
        }else {
            System.out.printf("%.2f$ more needed.",cost-budget);
        }

    }
}
