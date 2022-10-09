import java.io.*;
import java.util.Currency;

public class Ex11SerializeCustomObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Course course=new Course("Java",250);
        ObjectOutputStream output =new ObjectOutputStream(new FileOutputStream("src/course.ser"));
        ObjectInputStream input=new ObjectInputStream(new FileInputStream("src/course.ser"));


        output.writeObject(course);

        Course courseFromFile=(Course) input.readObject();
        System.out.println(courseFromFile);
    }
}
