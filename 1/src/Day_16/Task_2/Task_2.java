package Day_16.Task_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        String separator = File.separator;
        String filePath1 = "src" + separator + "Day_16" + separator + "Task_2" + separator + "file1.txt";
        String filePath2 = "src" + separator + "Day_16" + separator + "Task_2" + separator + "file2.txt";
        try {
            createFile1(filePath1);
            createFile2(filePath1, filePath2);
            printResult(new File(filePath2));
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка чтения файла");
        }
    }

    public static void createFile1(String filePath1) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(filePath1);
        for (int i = 0; i < 1000; i++) {
            pw.print((int) (Math.random() * 1001));
            pw.print(" ");
        }

        pw.close();
    }

    public static void createFile2(String filePath1, String filePath2) throws FileNotFoundException {
        File file1 = new File(filePath1);
        PrintWriter pw = new PrintWriter(filePath2);
        Scanner scanner = new Scanner(file1);
        int cnt = 0;
        int acc = 0;
        double groupSize = 20;
        while (scanner.hasNextInt()) {
            acc += scanner.nextInt();
            cnt++;
            if (cnt % groupSize == 0) {
               pw.print(acc / groupSize + " ");
               acc = 0;
            }
        }
        pw.close();
        scanner.close();
    }

    public static void printResult(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file).useLocale(Locale.US);;
        double acc = 0;
        while (scanner.hasNextDouble()) {
            acc += scanner.nextDouble();
        }
        scanner.close();
        System.out.println((int) acc);
    }
}
