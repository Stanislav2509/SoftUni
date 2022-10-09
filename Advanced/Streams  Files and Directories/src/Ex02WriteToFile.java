import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class Ex02WriteToFile {
    public static void main(String[] args) throws IOException {
        String path ="C:\\Users\\ion computers\\Desktop\\SoftUni\\Advanced\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        Set<Character> punctuation=Set.of(',', '.', '!' ,'?');

        FileOutputStream fileOutputStream= new FileOutputStream("output.txt");
        FileInputStream fileInputStream =new FileInputStream(path);

        int bytes=fileInputStream.read();

        while (bytes!=-1){
            char symbol=(char)bytes;

            boolean isPunctuation=punctuation.contains(symbol);
            if(!isPunctuation){
                fileOutputStream.write(symbol);
            }

            bytes=fileInputStream.read();
        }
    }
}
