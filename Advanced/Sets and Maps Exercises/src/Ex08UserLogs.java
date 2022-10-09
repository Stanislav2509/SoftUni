import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Ex08UserLogs {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String ,Integer>> logs=new TreeMap<>();
        String input= scanner.nextLine();
        while (!input.equals("end")){
            String ip=input.split(" ")[0].substring(3);
            String user=input.split(" ")[2].substring(5);

            logs.putIfAbsent(user,new LinkedHashMap<>());

            if(!logs.get(user).containsKey(ip)){
                logs.get(user).put(ip,1);
            }else {
                int curCount=logs.get(user).get(ip)+1;
                logs.get(user).put(ip,curCount);
            }


            input= scanner.nextLine();
        }


        for(var entry:logs.entrySet()){
            String user = entry.getKey();
            System.out.println(user+": ");
            StringBuilder result = new StringBuilder();
            for(var ip:entry.getValue().entrySet()){
                result.append(String.format("%s => %d, ",ip.getKey(),ip.getValue()));

            }
            String rs=result.substring(0,result.length()-2);
            System.out.println(rs+".");

        }

    }
}
