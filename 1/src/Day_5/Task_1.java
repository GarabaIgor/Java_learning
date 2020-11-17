package Day_5;

import java.time.Year;

public class Task_1 {
    public static void main(String[] args) {
        Car bmw = new Car();
        bmw.setColor("Red");
        bmw.setProductionDate(Year.parse("2007"));
        bmw.setModel("M3");
        System.out.println("Модель: " + bmw.getModel());
        System.out.println("Цвет: " + bmw.getColor());
        System.out.println("Дата выпуска: " + bmw.getProductionDate());
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

    private Year productionDate;
    private String color;
    private String model;
}
