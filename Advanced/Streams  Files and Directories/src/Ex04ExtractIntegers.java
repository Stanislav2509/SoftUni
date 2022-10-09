import java.io.*;
import java.util.Scanner;

public class Ex04ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String path ="C:\\Users\\ion computers\\Desktop\\SoftUni\\Advanced\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        Scanner scanner=new Scanner(new FileInputStream(path));

        while (scanner.hasNext()){
            if(scanner.hasNextInt()) System.out.println(scanner.nextInt());

            scanner.next();
        }


    }
}
