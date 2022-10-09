import java.io.*;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

public class Ex09SerializeCustomObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cube cube =new Cube("green",15.3,12.4,3);

        ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream("serializable.txt"));
        objectOutputStream.writeObject(cube);
        objectOutputStream.close();

        ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("serializable.txt"));
        Cube cube1=(Cube) objectInputStream.readObject();
        System.out.println(cube1);


    }
}
