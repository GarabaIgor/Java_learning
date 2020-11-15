package Day_4;

import java.util.Arrays;

public class Task_3 {
    public static void main(String[] args) {
        int maxVal = 50;
        int m = 12;
        int n = 8;
        int rowSum = 0;
        int maxRowSum = 0;
        int maxRowInd = 0;
        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = (int) (Math.random() * (maxVal+1));
                rowSum += arr[i][j];
            }
            if (rowSum >= maxRowSum) {
                maxRowSum = rowSum;
                maxRowInd = i;
            }
            rowSum = 0;
        }

//        for (int i = 0; i < m; i++) {
//            int s = 0;
//            for (int j = 0; j < n; j++) {
//                System.out.print(arr[i][j] + " ");
//                s += arr[i][j];
//            }
//            System.out.print("  = "+ s);
//            System.out.print("\n");
//        }

        System.out.println("Индекс максимальной строки: " + maxRowInd);
    }
}
