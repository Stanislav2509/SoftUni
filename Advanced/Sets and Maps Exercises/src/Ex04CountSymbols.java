import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Ex04CountSymbols {

    public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);
        TreeMap<Character,Integer> elements=new TreeMap<>();
        String word= scanner.nextLine();

        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            elements.putIfAbsent(ch,0);
            elements.put(ch,elements.get(ch)+1);
        }

        for(var entry: elements.entrySet()){
            System.out.printf("%c: %d time/s%n",entry.getKey(),entry.getValue());
        }
    }
}
