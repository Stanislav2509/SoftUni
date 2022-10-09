package carSalesman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int countEngine=Integer.parseInt(scanner.nextLine());
        List<Engine> engines=new ArrayList<>();

        for(int i=0;i<countEngine;i++){
            String[] engineData=scanner.nextLine().split(" ");
            Engine engine=new Engine(engineData[0],Integer.parseInt(engineData[1]));
            if(engineData.length==2){
                engine.setDisplacement("n/a");
                engine.setEfficiency("n/a");
            }else if(engineData.length==3){
                char ch=engineData[2].charAt(0);
                if(Character.isDigit(ch)){
                    engine.setDisplacement(engineData[2]);
                    engine.setEfficiency("n/a");
                }else {
                    engine.setEfficiency(engineData[2]);
                    engine.setDisplacement("n/a");
                }
            }else if(engineData.length==4){
                engine.setDisplacement(engineData[2]);
                engine.setEfficiency(engineData[3]);
            }
            engines.add(engine);
        }

        int countCar=Integer.parseInt(scanner.nextLine());
        List<Car> cars=new ArrayList<>();

        for(int i=0;i<countCar;i++){
            String [] carData= scanner.nextLine().split(" ");
            Engine engine=new Engine();
            for(int k=0;k<engines.size();k++){
                if(engines.get(k).getModel().equals(carData[1])){
                    engine=engines.get(k);
                }
            }
            Car car=new Car(carData[0],engine);

            if(carData.length==2){
                car.setWeight("n/a");
                car.setColor("n/a");
            }else if (carData.length==3){
                char ch=carData[2].charAt(0);
                if(Character.isDigit(ch)){
                    car.setWeight(carData[2]);
                    car.setColor("n/a");
                }else{
                    car.setWeight("n/a");
                    car.setColor(carData[2]);
                }
            }else if(carData.length==4){
                car.setWeight(carData[2]);
                car.setColor(carData[3]);
            }
            cars.add(car);
        }

        for(Car car:cars){
            System.out.printf("%s:%n  %s:%n    Power: %d%n    Displacement: %s%n    Efficiency: %s%n Weight: %s%n Color: %s%n",
                    car.getModel(),car.getEngine().getModel(),car.getEngine().getPower(),
                    car.getEngine().getDisplacement(), car.getEngine().getEfficiency(),car.getWeight(),car.getColor());
        }
    }
}
