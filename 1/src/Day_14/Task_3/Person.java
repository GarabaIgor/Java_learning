package Day_14.Task_3;

import Day_14.Task_2.NegativeAgeException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static List<Person> parseFileToObjList() throws FileNotFoundException, NegativeAgeException {
        String separator = File.separator;
        String path = "src" + separator + "Day_14" + separator +"Task_2" + separator + "people.txt";
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        List<Person> result = new ArrayList<>();
        String curLine = "";
        String[] splittedLine = new String[2];

        while (scanner.hasNextLine()) {
            curLine = scanner.nextLine();
            splittedLine = curLine.split(" ");

            if (Integer.parseInt(splittedLine[1]) < 0) {
                throw new NegativeAgeException("Некорректный входной файл");
            }
            result.add(new Person(splittedLine[0], Integer.parseInt(splittedLine[1])));
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
