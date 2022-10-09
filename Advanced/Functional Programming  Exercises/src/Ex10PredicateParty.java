import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex10PredicateParty {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        List<String> names= Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String input= scanner.nextLine();
        while (!input.equals("Party!")){
            String [] data=input.split(" ");
            String command=data[0];

            Predicate<String> applyFilter=getPredicate(data);
            if(command.equals("Remove")){
                names.removeIf(applyFilter);
            }else {
                int length=names.size();
                for(int i=0;i<length;i++){
                    if(applyFilter.test(names.get(i))){
                        names.add(names.get(i));
                    }
                }
            }
            input= scanner.nextLine();
        }
        if(names.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else {
            Collections.sort(names);
            System.out.print(String.join(", ",names));
            System.out.println(" are going to the party!");
        }
    }

    private static Predicate<String> getPredicate(String[] data) {
        String type=data[1];
        String parameter=data[2];

        switch (type){
            case "StartsWith":
                return  s->s.startsWith(parameter);
            case "EndsWith":
                return  s->s.endsWith(parameter);
            case "Length":
                return  s->s.length()==Integer.parseInt(parameter);
        }
        return null;
    }
}
