package Day_12.Task_5;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MusicBand {
    private String name;
    private Year year;
    private List<MusicArtist> members;

    public MusicBand(String name, Year year, List<MusicArtist> members) {
        this.name = name;
        this.year = year;
        this.members = members;
    }

    public static void transferMembers(MusicBand band1, MusicBand band2) {
        while (band1.members.size() > 0) {
            int lastInd = band1.members.size() - 1;
            band2.members.add(band1.members.get(lastInd));
            band1.members.remove(lastInd);
        }
    }

    public void addNewMember(MusicArtist member) {
        members.add(member);
    }

    public void printMembers() {
        System.out.println("All members: " + members);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public List<MusicArtist> getMembers() {
        return members;
    }

    public void setMembers(List<MusicArtist> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "MusicBand{" +
                "name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
