import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Ex02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        Consumer<String> print= name-> System.out.println("Sir "+name);
        String [] names=scanner.nextLine().split(" ");
        Arrays.stream(names).forEach(print);
    }
}
