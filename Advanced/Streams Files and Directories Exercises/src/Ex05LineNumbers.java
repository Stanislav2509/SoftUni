import java.io.*;

public class Ex05LineNumbers {
    public static void main(String[] args) throws IOException {
        String path="04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt";
        BufferedReader br=new BufferedReader(new FileReader(path));
        String line =br.readLine();
        int counter=0;
        PrintWriter pw=new PrintWriter(new FileWriter("output.txt"));
        while (line!=null){
            counter++;

            pw.println(counter+". "+line);
            line =br.readLine();
        }
        br.close();
        pw.close();
    }
}
