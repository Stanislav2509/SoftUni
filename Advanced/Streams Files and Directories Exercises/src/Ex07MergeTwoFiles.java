import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Ex07MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String firstPath="04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt";
        String secondPath="04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt";

        Path firstFile= Paths.get(firstPath);
        List<String> firstFileLines= Files.readAllLines(firstFile);

        Path secondFile=Paths.get(secondPath);
        List<String > secondFileLines=Files.readAllLines(secondFile);

        Path output= Paths.get("merges.txt");
        Files.write(output,firstFileLines, StandardOpenOption.APPEND);
        Files.write(output,secondFileLines,StandardOpenOption.APPEND);

//        FileReader fr=new FileReader(firstPath);
//        int bytes=fr.read();
//
//        FileWriter fw=new FileWriter("merges.txt",true);
//
//        while (bytes!=-1){
//            fw.write((char)bytes);
//            bytes=fr.read();
//        }
//        fr.close();
//        fw.write(System.lineSeparator());
//        FileReader reader=new FileReader(secondPath);
//        bytes= reader.read();
//        while (bytes!=-1){
//            fw.write((char)bytes);
//            bytes=reader.read();
//        }
//        reader.close();
//        fw.close();

    }
}
