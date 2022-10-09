package rawdata;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int countCars=Integer.parseInt(scanner.nextLine());
        List<Car>cars=new ArrayList<>();

        for(int i=0;i<countCars;i++){
            String [] data=scanner.nextLine().split(" ");
            Engine engine=new Engine(Integer.parseInt(data[1]),Integer.parseInt(data[2]));
            Cargo cargo =new Cargo(Integer.parseInt(data[3]),data[4]);
            List<Tire> tires=new ArrayList<>();

            for(int k=5;k< data.length;k+=2){
                Tire tire =new Tire(Double.parseDouble(data[k]),Integer.parseInt(data[k+1]));
                tires.add(tire);
            }
            Car car=new Car(data[0],engine,cargo,tires);
            cars.add(car);
        }

        String command= scanner.nextLine();
        if(command.equals("fragile")){
            for(Car car:cars){
                boolean flag=false;
                for(Tire tire : car.getTires()){
                    if(tire.getPressure()<1){
                        flag=true;break;
                    }
                }
                if(car.getCargo().getType().equals("fragile")&&flag){
                    System.out.println(car.getModel());
                }
            }

        }else if(command.equals("flamable")){
            for(Car car:cars){
                if(car.getCargo().getType().equals("flamable")&&car.getEngine().getPower()>250){
                    System.out.println(car.getModel());
                }

            }
        }
    }
}
