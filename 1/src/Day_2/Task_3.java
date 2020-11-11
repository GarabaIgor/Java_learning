package Day_2;

import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Введите числа: ");
        int a = s.nextInt();
        int b = s.nextInt();
        String result = "";

        if (a >= b) {
            System.out.println("Некорректный ввод");
        }
        else {
            System.out.print("Вывод: ");
            int i = a;
            while (i <= b) {
                i++;
                if (i % 5 == 0 && i % 10 != 0) {
                    result += " " + i;
                }
            }
            if (result.isEmpty()) {
                System.out.print("числа не найдены");
            }
            else {
                System.out.print(result);
            }
        }
    }
}
