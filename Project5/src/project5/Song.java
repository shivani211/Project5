package project5;

/**
 * Contains information about a song
 * 
 * @author Truman Heberle trumanh
 * @version 4.15.2017
 */
public class Song {
    private String title;
    private String artist;
    private int year;
    private String genre;
    private HobbyTracker hobbyTracker;
    //private MajorTracker majorTracker;
    //private RegionTracker regionTracker;
    
    public Song(String title1, String artist1, int year1, String genre1) {
        title = title1;
        artist = artist1;
        year = year1;
        genre = genre1;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getArtist() {
        return artist;
    }
    
    public int getYear() {
        return year;
    }
    
    public String getGenre() {
        return genre;
    }
}
