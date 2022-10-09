import java.util.*;

public class Ex08CustomComparator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Integer [] numbers= Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Comparator<Integer> comparator=(first,second)->{
            if(first%2==0 && second%2!=0){
                return -1;
            }else   if(first%2!=0 && second%2==0){
                return 1;
            }
            return first.compareTo(second);
        };

        Arrays.sort(numbers,comparator);
        Arrays.stream(numbers).forEach(n-> System.out.print(n+" "));
    }
}
