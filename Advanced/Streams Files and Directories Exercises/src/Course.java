import java.io.Serializable;

public class Course implements Serializable {
    String name;
    int numberOfStudents;

    public Course(String name, int numberOfStudents) {
        this.name = name;
        this.numberOfStudents = numberOfStudents;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", numberOfStudents=" + numberOfStudents +
                '}';
    }
}
