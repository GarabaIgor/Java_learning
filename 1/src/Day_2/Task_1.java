package Day_2;

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Введите кол-во этажей: ");
        int floorsCount = s.nextInt();

//      Ноль тоже отношу к ошибке
        if (floorsCount <= 0) {
            System.out.println("Ошибка ввода");
        }
        else if (floorsCount >= 1 && floorsCount <= 4) {
            System.out.println("Малоэтажный дом");
        }
        else if (floorsCount >= 5 && floorsCount <= 8) {
            System.out.println("Среднеэтажный дом");
        }
        else {
            System.out.println("Многоэтажный дом");
        }
    }
}
