package Day_9.Task_2;

abstract class Figure {
    String color;

    public abstract double area();

    public abstract double perimeter();

    public Figure(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
