package Day_15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) throws FileNotFoundException {
        String separator = File.separator;

        String path = "src" + separator + "Day_15" + separator + "shoes.csv";
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        String currentLine = "";
        StringBuilder resultText = new StringBuilder();

        while(scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            if (Integer.parseInt(currentLine.split(";")[2]) == 0) {
                resultText.append("\n");
                resultText.append(currentLine);
            }
        }
        scanner.close();

        if (resultText.length() > 0) {
            String resultFilePath = "src" + separator + "Day_15" + separator + "missing_shoes.txt";
            PrintWriter pw = new PrintWriter(resultFilePath);
            pw.println(resultText);
            pw.close();
        }

    }
}
