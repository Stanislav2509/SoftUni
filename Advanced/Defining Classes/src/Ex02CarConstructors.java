import java.util.Scanner;

public class Ex02CarConstructors {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        while (n-->0){
            String [] data=scanner.nextLine().split(" ");
            Car car;
            if(data.length==1){
                car=new Car(data[0]);
            }else {
                car =new Car(data[0],data[1],Integer.parseInt(data[2]));
            }

            System.out.println(car.carInfo());

        }
    }
}
