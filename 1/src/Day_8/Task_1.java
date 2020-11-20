package Day_8;

public class Task_1 {
    public static void main(String[] args) {
        System.out.println("Конкатенация String: ");
        System.out.println("Cold string: " + measureString());
        System.out.println("Warm string: " + measureString());
        System.out.println("Конкатенация StingBuilder: ");
        System.out.println("Warm string: " + measureStringBuilder());
    }

    public static long measureString() {
        long st, en;
        st = System.nanoTime();
        String s1 = "";
        for (int i = 0; i <= 20000; i++) {
            s1 += i + " ";
        }
        en = System.nanoTime();
        return en - st;
    }
    public static long measureStringBuilder() {
        long st, en;
        st = System.nanoTime();
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i <= 20000; i++) {
            s2.append(i).append(" ");
        }
        en = System.nanoTime();
        return en - st;
    }
}
