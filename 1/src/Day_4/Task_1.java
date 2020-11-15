package Day_4;

import com.sun.tools.javac.Main;

import java.util.Arrays;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        System.out.print("Введите размероность массива: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int greaterThan8Cnt = 0;
        int greaterThan1Cnt = 0;
        int evenNumbersCnt = 0;
        int oddNumbersCnt = 0;
        int elementsSum = 0;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (n + 1));
            if (arr[i] > 8) {
                greaterThan8Cnt++;
            }
            if (arr[i] > 1){
                greaterThan1Cnt++;
            }
            if (arr[i] % 2 == 0) {
                evenNumbersCnt++;
            }
            if (arr[i] % 2 != 0){
                oddNumbersCnt++;
            }
            elementsSum += arr[i];
        }

        System.out.println(Arrays.toString(arr));
        System.out.println("Длина массива: " + arr.length);
        System.out.println("Чисел больше 8: " + greaterThan8Cnt);
        System.out.println("Чисел больше 1: " + greaterThan1Cnt);
        System.out.println("Чётных чисел: " + evenNumbersCnt);
        System.out.println("Нечётных чисел: " + oddNumbersCnt);
        System.out.println("Сумма всех элементов: " + elementsSum);
    }

}
