import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class Ex04CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String path ="04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        Set<Character> vowels= Set.of('a','e','i','o','u');
        Set<Character> punctuations= Set.of('!',',','?','.');

        int vowelsCounter=0;
        int punctuationCounter=0;
        int consonantsCounter=0;

        FileReader reader=new FileReader(path);
        int bytes= reader.read();
        while (bytes!=-1){
            char symbol=(char)bytes;
            if(vowels.contains(symbol)){
                vowelsCounter++;

            }else if(punctuations.contains(symbol)){
                punctuationCounter++;

            }else if(!Character.isWhitespace(symbol)){
                consonantsCounter++;
            }
            bytes= reader.read();
        }
        PrintWriter writer=new PrintWriter(new FileWriter("output.txt"));


        writer.println("Vowels: "+vowelsCounter);
        writer.println("Consonants: "+consonantsCounter);
        writer.println("Punctuation: "+punctuationCounter);
        writer.close();
    }
}
