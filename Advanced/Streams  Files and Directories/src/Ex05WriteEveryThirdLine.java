import java.io.*;

public class Ex05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String path ="C:\\Users\\ion computers\\Desktop\\SoftUni\\Advanced\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

     FileInputStream inputStream=new FileInputStream(path);
     BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));

     String line=reader.readLine();
     int lineCounter=1;
     while (line!=null){
         if(lineCounter%3==0){
             System.out.println(line);
         }

         line= reader.readLine();
         lineCounter++;

     }
    }
}
