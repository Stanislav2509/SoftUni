import java.util.*;

import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num= Integer.parseInt(scanner.nextLine());
        List<String> names= Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());


        Predicate<String> predicate= name-> name.length()<=num;
        names.stream().filter(predicate).forEach(System.out::println);
    }
}
