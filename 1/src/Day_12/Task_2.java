package Day_12;

import java.util.ArrayList;
import java.util.List;

public class Task_2 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= 30; i++) {
            if (i % 2 == 0) {
                numbers.add(i);
            }
        }
        for (int i = 300; i <= 350; i++) {
            if (i % 2 == 0) {
                numbers.add(i);
            }
        }

        System.out.println(numbers);
    }
}
