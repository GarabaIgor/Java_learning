package Day_9.Task_2;

public class TestFigures {
    public static void main(String[] args) {
        Figure[] figures = {
                new Triangle(10, 10, 10, "Red"),
                new Triangle(10, 20, 30, "Green"),
                new Triangle(10, 20, 15, "Red"),
                new Rectangle(5, 10, "Red"),
                new Rectangle(40, 15, "Orange"),
                new Circle(4, "Red"),
                new Circle(10, "Red"),
                new Circle(5, "Blue")
        };

        System.out.println("Суммарный периметр красных фигур: " + calculateRedPerimeter(figures));
        System.out.println("Суммарная площадь красных фигур: " + calculateRedArea(figures));
    }

    public static double calculateRedPerimeter(Figure[] figures) {
        double resultPerimeter = 0;
        for (Figure f : figures) {
            if (f.color.equals("Red")) {
                resultPerimeter += f.perimeter();
            }
        }
        return resultPerimeter;
    }
    public static double calculateRedArea(Figure[] figures) {
        double resultArea = 0;
        for (Figure f : figures) {
            if (f.color.equals("Red")) {
                resultArea += f.area();
            }
        }
        return resultArea;
    }
}

