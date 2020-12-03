package Day_16.Task_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.chrono.IsoEra;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        String separator = File.separator;
        String filePath = "src" + separator + "Day_16" + separator + "Task_1" + separator + "Numbers.txt";
        File file = new File(filePath);

        try {
            printResult(file);
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка чтения файла!");
        }

    }
    public static void printResult(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        double sum = 0;
        int cnt = 0;
        while (scanner.hasNextInt()) {
            sum += scanner.nextInt();
            cnt++;
        }
        scanner.close();
        double result = sum / cnt;
        double roundedResult = Math.round(result * 100) / 100.0;

        System.out.println("Result: " + result);
        System.out.println("Rounded result: " + roundedResult);
    }
}
