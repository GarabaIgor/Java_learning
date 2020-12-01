package Day_14.Task_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        List<String> parsedResult = null;
        try {
            parsedResult = parseFileToStringList();
            System.out.println(parsedResult);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (NegativeAgeException e) {
            System.out.println(e.getMessage());
        }

    }
    public static List<String> parseFileToStringList() throws FileNotFoundException, NegativeAgeException {
        String separator = File.separator;
        String path = "src" + separator + "Day_14" + separator +"Task_2" + separator + "people.txt";
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        List<String> result = new ArrayList<>();
        String curLine = "";

        while (scanner.hasNextLine()) {
            curLine = scanner.nextLine();

            if (Integer.parseInt(curLine.split(" ")[1]) < 0) {
                throw new NegativeAgeException("Некорректный входной файл");
            }
            result.add(curLine);
        }
        return result;
    }
}
