package Day_18;

public class Task_1 {
    public static void main(String[] args) {
        int[] numbers = {1, 10, 1241, 50402, -50, 249, 10215, 665, 2295, 7, 311};
        System.out.println(recSum(numbers, 0));

    }
    private static int recSum(int[] arr, int ind) {
        if (ind == arr.length - 1) {
            return arr[ind];
        }
        return arr[ind] + recSum(arr, ++ind);
    }
}

