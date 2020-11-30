package Day_12.Task_3;


import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Task_3 {
    public static void main(String[] args) {
        List<MusicBand> bands = new ArrayList<MusicBand>(10);
        int rndNum;
        Year randYear;
        for (int i = 0; i < 20; i++) {
            rndNum = (int)(Math.random() * 40) + 1980;
            randYear = Year.parse(String.valueOf(rndNum));
            bands.add(new MusicBand("Group_" + rndNum, randYear));
        }
        System.out.println("Original bands: " + bands);

        List<MusicBand> youngGroups = groupsAfter2000(bands);

        System.out.println("Bands after 2000: " + youngGroups);
    }

    public static List<MusicBand> groupsAfter2000 (List<MusicBand> bands) {
        List<MusicBand> groupsAfter2000 = new ArrayList<>();
        Year year2000 = Year.parse("2000");
        for (MusicBand band: bands) {
            if (band.getYear().isAfter(year2000)) {
                groupsAfter2000.add(band);
            }
        }
        return groupsAfter2000;
    }
}
