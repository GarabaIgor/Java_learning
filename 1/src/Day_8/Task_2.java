package Day_8;

import java.time.Year;

public class Task_2 {
    public static void main(String[] args) {
        Airplane a = new Airplane("Boeng", Year.parse("2010"), 100, 1000);
        System.out.println(a);
    }
}
class Airplane {
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

    public String toString() {
        return String.format("Изготовитель: %s, год выпуска: %s, длина: %.2f, вес: %.2f, количество топлива в баке: %.2f", producer, year.toString(), length, weight, fuel);
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