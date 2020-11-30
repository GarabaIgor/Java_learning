package Day_12.Task_4;

import java.time.Year;

public class Task_4 {
    public static void main(String[] args) {
        MusicBand b1 = new MusicBand("na-na", Year.parse("2000"), "Ivan Ivanov,Vasyliy Petrov");
        b1.printMembers();

        MusicBand b2 = new MusicBand("bi-2", Year.parse("2000"), "Alex Alex, Petya Petya");
        b2.printMembers();

        MusicBand.transferMembers(b1, b2);
        b1.printMembers();
        b2.printMembers();
    }
}
