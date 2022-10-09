import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayDeque;

public class Ex08GetFolderSize {
    public static void main(String[] args) {
        File folder=new File("04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources");
        ArrayDeque<File> directories=new ArrayDeque<>();
       directories.offer(folder);
        int sum=0;
        while (!directories.isEmpty()){
            File current=directories.poll();
            File[] files=current.listFiles();
            for (File file : files) {
                if(file.isDirectory()){
                    directories.offer(file);
                }else {
                    sum+=file.length();
                }
            }
        }

        System.out.println("Folder size: "+ sum);
    }
}
