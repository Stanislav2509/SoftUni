import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Ex03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        TreeSet<String> elements=new TreeSet<>();

        while (n-->0){
            String[]input=scanner.nextLine().split(" ");
            for(int i=0;i< input.length;i++){
                elements.add(input[i]);
            }
        }
        System.out.println(String.join(" ",elements));
    }
}
