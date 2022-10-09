import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String> names= Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        Set<String> filters=new HashSet<>();

        String input= scanner.nextLine();
        while (!input.equals("Print")){
            String[] data=input.split(";");
            String command=data[0];
            String type=data[1];
            String parameter=data[2];
            if(command.equals("Add filter")){
                filters.add(type+";"+parameter);
            }else {
                filters.remove(type+";"+parameter);
            }
            input= scanner.nextLine();
        }

        filters.forEach(filter->{
            Predicate<String> applyFilter=getPredicate(filter);
            names.removeIf(applyFilter);
        });

        names.forEach(name-> System.out.print(name+" "));

    }

    private static Predicate<String> getPredicate(String filter) {
        String[] filterPart=filter.split(";");
        String type=filterPart[0];
        String parameter=filterPart[1];
        switch (type){
            case "Starts with":
                return  s->s.startsWith(parameter);
            case "Ends with":
                return  s->s.endsWith(parameter);
            case "Length":
                return  s->s.length()==Integer.parseInt(parameter);
            case "Contains":
                return  s->s.contains(parameter);
        }
        return null;
    }
}
