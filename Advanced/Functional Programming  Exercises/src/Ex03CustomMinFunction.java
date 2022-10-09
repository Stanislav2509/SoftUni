import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> numbers= Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        Function<List<Integer>,Integer> minNum= list->{
            int min=Integer.MAX_VALUE;
            for (int num : list) {
                if(num<min){
                    min=num;
                }
            }
            return min;
        };
        //Function<List<Integer>,Integer> function= Collections::min;
        System.out.println(minNum.apply(numbers));
    }
}
