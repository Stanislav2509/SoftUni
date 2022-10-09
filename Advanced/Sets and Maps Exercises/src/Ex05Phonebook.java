import java.util.HashMap;
import java.util.Scanner;

public class Ex05Phonebook {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        HashMap<String,String> phoneBook=new HashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("search")){
            String[] data=input.split("-");
            phoneBook.put(data[0],data[1]);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("stop")){
            if(phoneBook.containsKey(input)){
                System.out.println(input+" -> "+ phoneBook.get(input));
            }else {
                System.out.println("Contact "+input+ " does not exist.");
            }
            input = scanner.nextLine();

        }
    }
}
