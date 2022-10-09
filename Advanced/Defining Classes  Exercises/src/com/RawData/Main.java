package com.RawData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int countCars=Integer.parseInt(scanner.nextLine());

        List<Car> cars=new ArrayList<>();
        Car car;
        while (countCars-->0){
            String [] data=scanner.nextLine().split(" ");
            String model=data[0];
            int engineSpeed=Integer.parseInt(data[1]);
            int enginePower=Integer.parseInt(data[2]);
            int cargoWeight=Integer.parseInt(data[3]);
            String cargoType=data[4];
            Tire[] tires=new Tire[4];
            for(int i=0;i<tires.length;i++){
                double pressure=Double.parseDouble(data[5]);
                int age=Integer.parseInt(data[6]);
                tires[i]=new Tire(pressure,age);
            }
            Engine engine=new Engine(engineSpeed,enginePower);
            Cargo cargo=new Cargo(cargoWeight,cargoType);
            car=new Car(model,cargo,engine,tires);
            cars.add(car);
        }

        String command= scanner.nextLine();
        switch (command){
            case "fragile":
                List<Car> fragile = cars
                        .stream()
                        .filter(c -> c.getCargo().getType().equals("fragile")).collect(Collectors.toList());
                for (Car c : fragile) {
                    for (Tire tire : c.getTires()) {
                        if(tire.getPressure()<1){
                            System.out.println(c.getModel());
                            break;
                        }
                    }
                }
                break;
            case "flamable":
                cars.stream().filter(c->c.getCargo().getType().equals("flamable"))
                        .filter(c->c.getEngine().getPower()>250)
                        .forEach(c-> System.out.println(c.getModel()));
                break;

        }
    }
}
