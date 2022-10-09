import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int range=Integer.parseInt(scanner.nextLine());
        List<Integer> numbers= Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        Predicate<Integer> isDivisible=number->{
            for (int num : numbers) {
                if(number%num!=0){
                    return false;
                }
            }
            return true;
        };

        for (int i=1;i<=range;i++){
            if(isDivisible.test(i)){
                System.out.print(i+" ");
            }
        }
    }
}
