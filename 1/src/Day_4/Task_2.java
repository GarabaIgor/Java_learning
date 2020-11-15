package Day_4;

import java.util.Arrays;

public class Task_2 {
    public static void main(String[] args) {
        int n = 100;
        int maxVal = 10000;
        int maxElement = 0;
        int minElement = Integer.MAX_VALUE;
        int zeroEndedElementsCnt = 0;
        int zeroEndedElementsSum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (maxVal + 1));
        }

        for (int element: arr) {
            if (element > maxElement) {
                maxElement = element;
            }
            if (element < minElement) {
                minElement = element;
            }
            if (element % 10 == 0) {
                zeroEndedElementsCnt++;
                zeroEndedElementsSum += element;
            }
        }
//        System.out.println(Arrays.toString(arr));
        System.out.println("Наибольший элемент: " + maxElement);
        System.out.println("Наименьший элемент: " + minElement);
        System.out.println("Кол-во элементов, оканчивающихся на ноль: " + zeroEndedElementsCnt);
        System.out.println("Сумма элементов, оканчивающихся на ноль: " + zeroEndedElementsSum);
    }
}
