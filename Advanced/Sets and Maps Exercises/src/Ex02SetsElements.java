import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Ex02SetsElements {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int [] sizes= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int firstSetSize=sizes[0];
        LinkedHashSet<String> firstSet=new LinkedHashSet<>();
        LinkedHashSet<String> secondSet=new LinkedHashSet<>();
        int secondSetSize=sizes[1];

        while (firstSetSize-->0){
            firstSet.add(scanner.nextLine());
        }

        while (secondSetSize-->0){
            secondSet.add(scanner.nextLine());
        }

        firstSet.retainAll(secondSet);

        System.out.println(String.join(" ",firstSet));
    }
}
