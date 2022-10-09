import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Ex06WordCount {
    public static void main(String[] args) throws IOException {
        String pathWords="04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt";
        String pathText="04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt";

        Scanner wordToSearch=new Scanner(new FileReader(pathWords));
        List<String> words= Arrays.stream(wordToSearch.nextLine().split(" ")).collect(Collectors.toList());

        LinkedHashMap<String,Integer> map=new LinkedHashMap<>();
        for (String word : words) {
            map.putIfAbsent(word,0);
        }

        Scanner fileScanner=new Scanner(new FileReader(pathText));
        String word=fileScanner.next();
        while (fileScanner.hasNext()){
            if(map.containsKey(word)){
                int count=map.get(word);
                map.put(word,count+1);
            }
            word=fileScanner.next();
        }

        PrintWriter pw =new PrintWriter(new FileWriter("result.txt"));
        map.entrySet()
                        .stream()
                .sorted((f,s)->s.getValue() - f.getValue())
                .forEach(entry->pw.printf("%s - %d%n",entry.getKey(),entry.getValue()));

        wordToSearch.close();
        fileScanner.close();
        pw.close();
    }
}
