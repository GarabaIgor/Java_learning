package Day_6;

import java.time.Year;

public class Task_1 {
    public static void main(String[] args) {
        Car bmw = new Car();
        bmw.setColor("Red");
        bmw.setProductionDate(Year.parse("2007"));
        bmw.setModel("M3");
        bmw.info();
        System.out.println(bmw.yearDifference(2000));

        Motorbike bike = new Motorbike(Year.parse("2008"), "Red", "Suzuki");
        bike.info();
        System.out.println(bike.yearDifference(2000));
    }
}

class Car {
    public Year getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Year productionDate) {
        this.productionDate = productionDate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void info() {
        System.out.println("Это автомобиль");
    }

    public Year yearDifference(long year) {
        return productionDate.minusYears(year);
    }

    private Year productionDate;
    private String color;
    private String model;
}
class Motorbike {

    public Motorbike(Year productionDate, String color, String model) {
        this.productionDate = productionDate;
        this.color = color;
        this.model = model;
    }

    public Year getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Year productionDate) {
        this.productionDate = productionDate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void info() {
        System.out.println("Это мотоцикл");
    }

    public Year yearDifference(long year) {
        return productionDate.minusYears(year);
    }

    private Year productionDate;
    private String color;
    private String model;
}