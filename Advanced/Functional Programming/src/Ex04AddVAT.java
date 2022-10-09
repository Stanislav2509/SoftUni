import java.util.Arrays;
import java.util.Scanner;
import java.util.function.*;
import java.util.stream.Collectors;

public class Ex04AddVAT {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        double[] prices= Arrays.stream(scanner.nextLine().split(", ")).mapToDouble(Double::parseDouble).toArray();

        DoubleUnaryOperator addVat= p -> p * 1.20;

        Consumer<double[]> print= p-> {
            System.out.println("Prices with VAT:");
            System.out.println(Arrays.stream(p)
                    .map(addVat)
                    .mapToObj(d -> String.format("%.2f", d))
                    .collect(Collectors.joining(System.lineSeparator())));
        };

        print.accept(prices);
    }
}
