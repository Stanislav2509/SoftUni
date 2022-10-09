import java.util.*;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Ex05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> numbers= Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int num= Integer.parseInt(scanner.nextLine());
        Collections.reverse(numbers);
        Predicate<Integer> predicate=n-> n%num!=0;
        UnaryOperator<List<Integer>> func=list-> list.stream().filter(predicate).collect(Collectors.toList());
        func.apply(numbers).forEach(n->System.out.print(n+" "));
    }
}
