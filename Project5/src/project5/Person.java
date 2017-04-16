package project5;

/**
 * Contains information about a person
 * 
 * @author Truman Heberle trumanh
 * @version 4.15.2017
 */
public class Person {
    private int identity;
    private String date;
    private HobbyEnum hobby;
    private MajorEnum major;
    private RegionEnum region;
    private String[] answers;

    /**
     * Creates a new Person Object
     * 
     * @param id The person's id
     * @param dateS The person's date
     * @param hobbyS The person's hobby (String)
     * @param majorS The person's major (String)
     * @param regionS The person's region (String)
     * @param answersS The person's list of answers
     */
    public Person(int id, String dateS, String hobbyS, String majorS, String regionS, String[] answersS) {
        identity = id;
        date = dateS;
        hobby = this.setHobby(hobbyS);
        major = this.setMajor(majorS);
        region = this.setRegion(regionS);
        answers = answersS;
    }
    
    /**
     * Gets the person's id
     * 
     * @return The person's id
     */
    public int getId() {
        return identity;
    }
    
    /**
     * Gets the person's date
     * 
     * @return The person's date
     */
    public String getDate() {
        return date;
    }
    
    /**
     * Gets the person's hobby
     * 
     * @return The person's hobby
     */
    public HobbyEnum getHobby() {
        return hobby;
    }
    
    /**
     * Gets the person's major
     * 
     * @return The person's major
     */
    public MajorEnum getMajor() {
        return major;
    }
    
    /**
     * Gets the person's region
     * @return The person's region
     */
    public RegionEnum getRegion() {
        return region;
    }
    
    /**
     * Gets the person's response to a song by song number
     * @param songNum The song's reference number
     * @return The person's response
     */
    public String getAnswer(int songNum) {
        return answers[songNum];
    }

    /**
     * Sets the hobby based on an input String
     * 
     * @param hobbyString The String used to compare
     * @return The corresponding HobbyEnum
     */
    private HobbyEnum setHobby(String hobbyString) {
        switch (hobbyString.toLowerCase()) {
        case "reading":
            return HobbyEnum.READ;
        case "sports":
            return HobbyEnum.SPORTS;
        case "music":
            return HobbyEnum.MUSIC;
        case "art":
            return HobbyEnum.ART;
        default:
            return null;
        }
    }
    
    /**
     * Sets the major based on an input String
     * 
     * @param majorString The String used to compare
     * @return The corresponding MajorEnum
     */
    private MajorEnum setMajor(String majorString) {
        switch (majorString.toLowerCase()) {
        case "computer science":
            return MajorEnum.COMPUTER_SCIENCE;
        case "math or cmda":
            return MajorEnum.MATH_CMDA;
        case "other engineering":
            return MajorEnum.OTHER_ENGINEERING;
        case "other":
            return MajorEnum.OTHER;
        default:
            return null;
        }
    }
    
    /**
     * Sets the hobby based on an input String
     * 
     * @param hobbyString The String used to compare
     * @return The corresponding HobbyEnum
     */
    private RegionEnum setRegion(String regionString) {
        switch (regionString.toLowerCase()) {
        case "southeast":
            return RegionEnum.SOUTH_EAST_US;
        case "northeast":
            return RegionEnum.NORTH_EAST_US;
        case "united states (other than southeast or northwest)":
            return RegionEnum.OTHER_US;
        case "outside of united states":
            return RegionEnum.OUTSIDE_US;
        default:
            return null;
        }
    }
}
