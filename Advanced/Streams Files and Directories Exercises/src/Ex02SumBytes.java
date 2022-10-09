import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex02SumBytes {
    public static void main(String[] args) throws IOException {
        String path ="04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        BufferedReader bufferedReader=new BufferedReader(new FileReader(path));
        String line = bufferedReader.readLine();
        int sum=0;
        while (line!=null){
            for(int i=0;i<line.length();i++){
                sum+=line.charAt(i);
            }
            line = bufferedReader.readLine();
        }
        System.out.println(sum);
        bufferedReader.close();
    }
}
