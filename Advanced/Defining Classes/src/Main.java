import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        while (n-->0){
            String [] data=scanner.nextLine().split(" ");
            Car car =new Car(data[0],data[1],Integer.parseInt(data[2]));
            System.out.println(car.carInfo());

        }
    }

}