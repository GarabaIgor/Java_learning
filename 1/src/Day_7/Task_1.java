package Day_7;

import java.time.Year;

public class Task_1 {
    public static void main(String[] args) {
        Airplane plane1 = new Airplane("Boeng", Year.parse("2000"), 106, 1000);
        Airplane plane2 = new Airplane("Сухой", Year.parse("2007"), 106, 10000);
        Airplane.compareAirplanes(plane1, plane2);
    }
}

class Airplane {
    public static void compareAirplanes(Airplane first, Airplane second) {
        if (first.length > second.length) {
            System.out.println("Первый самолёт длиннее");
        }
        else if (first.length < second.length) {
            System.out.println("Второй самолёт длиннее");
        }
        else {
            System.out.println("Самолёты одинаковой длины");
        }
    }

    public String getProducer() {
        return producer;
    }

    public Airplane(String producer, Year year, double length, double weight) {
        this.producer = producer;
        this.year = year;
        this.length = length;
        this.weight = weight;
        this.fuel = 0;
    }

    public void fillUp(double fuelAmount) {
        fuel += fuelAmount;
    }

    public void info() {
        System.out.printf("Изготовитель: %s, год выпуска: %s, длина: %.2f, вес: %.2f, количество топлива в баке: %.2f", producer, year.toString(), length, weight, fuel);
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    private String producer;
    private Year year;
    private double length;
    private double weight;
    private double fuel;
}