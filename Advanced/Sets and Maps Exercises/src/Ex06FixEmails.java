import java.util.LinkedHashSet;
import java.util.Scanner;

public class Ex06FixEmails {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        LinkedHashSet<String> names=new LinkedHashSet<>();
        String input= scanner.nextLine();
        int count=0;
        while (!input.equals("stop")){
            if(count%2==0){
                names.add(input);
            }else {
                if(!input.endsWith("us") && !input.endsWith("uk") && !input.endsWith("com")){
                    System.out.println(names.iterator().next() +" -> "+ input);

                }
                names.clear();
            }

            input= scanner.nextLine();
            count++;
        }
    }
}
