package Day_12.Task_5;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Task_5 {
    public static void main(String[] args) {
        List<MusicArtist> members_1 = new ArrayList<>();
        members_1.add(new MusicArtist("Ivan", 42));
        members_1.add(new MusicArtist("Igor", 31));
        MusicBand b1 = new MusicBand("na-na", Year.parse("2000"), members_1);
        b1.addNewMember(new MusicArtist("Vasya", 18));
        b1.printMembers();

        List<MusicArtist> members_2 = new ArrayList<>();
        members_2.add(new MusicArtist("Petya", 25));
        MusicBand b2 = new MusicBand("bi-2", Year.parse("1980"), members_2);

        b2.printMembers();

        MusicBand.transferMembers(b1, b2);
        b1.printMembers();
        b2.printMembers();
    }
}
