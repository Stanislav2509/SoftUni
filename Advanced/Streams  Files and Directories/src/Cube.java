import java.io.Serializable;

public class Cube  implements Serializable {
    String color;
    double width;
    double height;
    double depth;

    public Cube(String color, double width, double height, double depth) {
        this.color = color;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "Cube{" +
                "color='" + color + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", depth=" + depth +
                '}';
    }
}
