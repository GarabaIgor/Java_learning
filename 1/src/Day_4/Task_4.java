package Day_4;

import java.util.Arrays;

public class Task_4 {
    public static void main(String[] args) {
        int n = 100;
        int maxVal = 10000;
        int threeElementsSum = 0;
        int maxThreeElementsSum = 0;
        int maxSumFirstInd = 0;
        int[] arr = new int[n];
//        int[] arr = {1, 456, 1025, 65, 954, 2789, 4, 8742, 1040, 3254};

        for (int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random() * (maxVal + 1));

            if (i >= 1 && i < n-1) {
                threeElementsSum += arr[i - 1] + arr[i] + arr[i + 1];
                if (threeElementsSum > maxThreeElementsSum) {
                    maxThreeElementsSum = threeElementsSum;
                    maxSumFirstInd = i-1;
                }
            }
            threeElementsSum = 0;
        }

//        System.out.println(Arrays.toString(arr));
        System.out.println("Сумма: " + maxThreeElementsSum);
        System.out.println("Индекс первого элемента тройки: " + maxSumFirstInd);
    }
}
