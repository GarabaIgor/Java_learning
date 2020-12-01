package Day_14.Task_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        String separator = File.separator;
        String path = "src" + separator + "Day_14" + separator + "Task_1" + separator + "Numbers.txt";
        File numbersFile = new File(path);
        try {
            printSumDigits(numbersFile);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (CntGreaterThan10Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("After catch handling");
    }
    public static void printSumDigits(File file) throws FileNotFoundException, CntGreaterThan10Exception {
        int sum = 0;
        int cnt = 0;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            sum += scanner.nextInt();
            cnt++;
        }
        scanner.close();
        if (cnt != 10) {
            throw new CntGreaterThan10Exception("Некорректный входной файл");
        }
        System.out.println("Сумма чисел: " + sum);
    }
}
