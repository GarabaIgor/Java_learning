package Day_5;

import java.time.Year;

public class Task_2 {
    public static void main(String[] args) {
        Motorbike bike = new Motorbike(Year.parse("2008"), "Red", "Suzuki");
        System.out.println("Модель: " + bike.getModel());
        System.out.println("Цвет: " + bike.getColor());
        System.out.println("Дата выпуска: " + bike.getProductionDate());
    }
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

    private Year productionDate;
    private String color;
    private String model;
}