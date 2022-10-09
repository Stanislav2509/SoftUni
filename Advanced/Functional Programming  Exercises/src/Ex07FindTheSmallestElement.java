import java.util.*;

import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> names= Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        Function<List<Integer>,Integer> func= list->{
            int min=Integer.MAX_VALUE;
            int index=0;
            for (int num=0;num<list.size();num++) {
                if(list.get(num)<=min){
                    min=list.get(num);
                    index=num;
                }
            }
            return index;
        };
        System.out.println(func.apply(names));
    }
}
