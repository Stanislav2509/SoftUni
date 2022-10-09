import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ex10SerializeArrayList {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream("list.ser"));
        ObjectInputStream input=new ObjectInputStream(new FileInputStream("list.ser"));

        ArrayList<Double> list=new ArrayList<>();
        list.add(5.4);
        list.add(6.1);
        list.add(7.9);

        output.writeObject(list);

        List<Double> listFromFile=(List) input.readObject();
        for (Double num : listFromFile) {
            System.out.println(num);
        }

    }
}
