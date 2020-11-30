package Day_12;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task_1 {
    public static void main(String[] args) {
        List<String> autos = new ArrayList<>(5);
        autos.add("BMW");
        autos.add("Honda");
        autos.add("Toyota");
        autos.add("Audi");
        autos.add("Fiat");
//        autos = Arrays.asList("BMW","Honda","Toyota","Audi","Fiat");
        System.out.println("All autos: " + autos);

        autos.add(2, "Lada");
        System.out.println("After adding lada: " + autos);

        autos.remove(0);
        System.out.println("After removing first: " + autos);
    }
}
