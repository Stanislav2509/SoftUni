package com.company.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int countEngines=Integer.parseInt(scanner.nextLine());
        Set<Engine> engines=new LinkedHashSet<>();
        Engine engine;
        while (countEngines-->0){
            String []data=scanner.nextLine().split(" ");
            String model=data[0];
            int power=Integer.parseInt(data[1]);
            if(data.length==4){
                String displacement=data[2];
                String efficiency=data[3];
                engine=new Engine(model,power,displacement,efficiency);
            }else if(data.length==2){
                engine=new Engine(model,power);
            }
            else {
                if(Character.isDigit(data[2].charAt(0))){
                    String displacement=data[2];
                    engine=new Engine(model,power);
                    engine.setDisplacement(displacement);
                }else {
                    String efficiency=data[2];
                    engine=new Engine(model,power);
                    engine.setEfficiency(efficiency);
                }
            }

            engines.add(engine);
        }

        int countCars=Integer.parseInt(scanner.nextLine());
        List<Car> cars=new ArrayList<>();

        while (countCars-->0){
            Car car;
            String []data=scanner.nextLine().split(" ");
            String model=data[0];
            Engine engineType=findEngine(engines,data[1]);
            if(data.length==4){
                String  weight=data[2];
                String color=data[3];
                car=new Car(model,engineType,weight,color);
            }else if(data.length==2){
                car=new Car(model,engineType);
            }else {
                if(Character.isDigit(data[2].charAt(0))){
                    String  weight=data[2];
                    car=new Car(model,engineType);
                    car.setWeight(weight);
                }else {
                    String color=data[2];
                    car=new Car(model,engineType);
                    car.setColor(color);
                }
            }
            cars.add(car);
        }
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private static Engine findEngine(Set<Engine> engines, String engineType) {
        for (Engine engine : engines) {
            if(engine.getModel().equals(engineType)){
                return engine;
            }
        }
        return null;
    }
}
