import java.io.*;
import java.util.Set;

public class Ex03CopyBytes {
    public static void main(String[] args) throws IOException {
        String path ="C:\\Users\\ion computers\\Desktop\\SoftUni\\Advanced\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        Set<Integer> specialSymbol=Set.of(10,32,13);

        FileOutputStream fileOutputStream= new FileOutputStream("output.txt");
        FileInputStream fileInputStream =new FileInputStream(path);
        PrintWriter printer=new PrintWriter(fileOutputStream);

        int bytes=fileInputStream.read();

        while (bytes!=-1){


            boolean isDelimiter=specialSymbol.contains(bytes);
            if(isDelimiter){
                printer.print((char) (bytes));
            }else {
                printer.print((bytes));
            }

            bytes=fileInputStream.read();
        }
    }
}
