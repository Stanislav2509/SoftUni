import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex03ALLCAPITALS {
    public static void main(String[] args) throws IOException {
        String path ="04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

        FileReader fileReader=new FileReader(path);
        int bytes= fileReader.read();
        while (bytes!=-1){
            char symbol=(char)bytes;
            if(Character.isLetter(symbol)){
                String s = String.valueOf(symbol);
                System.out.print(s.toUpperCase());
            }else {
                System.out.print(symbol);
            }

            bytes= fileReader.read();
        }
    }
}
