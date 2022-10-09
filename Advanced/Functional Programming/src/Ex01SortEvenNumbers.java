import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int [] numbers= Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(n->n%2==0)
                .toArray();

        System.out.println( Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ")));

        System.out.println(Arrays.stream(numbers).sorted().mapToObj(String::valueOf)
                .collect(Collectors.joining(", ")));
    }
}
