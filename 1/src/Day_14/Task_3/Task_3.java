package Day_14.Task_3;

import Day_14.Task_2.NegativeAgeException;

import java.io.FileNotFoundException;

public class Task_3 {
    public static void main(String[] args) {
        try {
            System.out.println(Person.parseFileToObjList());
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (NegativeAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
