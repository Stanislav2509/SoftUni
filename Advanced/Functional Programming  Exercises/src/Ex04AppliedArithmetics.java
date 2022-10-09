import java.util.*;
import java.util.stream.Collectors;
public class Ex04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> numbers= Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String command= scanner.nextLine();
        while (!command.equals("end")){
            switch (command){
                case "add":
                    numbers=  numbers.stream().map(n->n+1).collect(Collectors.toList());
                    break;
                case "multiply":
                    numbers=  numbers.stream().map(n->n*2).collect(Collectors.toList());
                    break;
                case "subtract":
                    numbers=  numbers.stream().map(n->n-1).collect(Collectors.toList());
                    break;
                case "print":
                    numbers.forEach(n-> System.out.print(n+" "));
                    System.out.println();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + command);
            }
            command= scanner.nextLine();
        }
    }
}
