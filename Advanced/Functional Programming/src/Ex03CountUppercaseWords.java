import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class Ex03CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String[] word=scanner.nextLine().split(" ");

        Predicate<String> isStartingWithUpperCase=w-> Character.isUpperCase(w.charAt(0));

        ArrayDeque<String> queue=new ArrayDeque<>();

        Arrays.stream(word).filter(isStartingWithUpperCase).forEach(queue::offer);

        System.out.println(queue.size());
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
