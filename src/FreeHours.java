/**
 * Manages the client's available hours for Events on the GUI.
 * 
 * @deprecated Legacy code when attempting to set up web app implemenation with
 *             browser-based GUI. May be updated to be better suited for a local
 *             java swing GUI implementation.
 * 
 * @author Dylan Mirandilla
 */
public class FreeHours {
    private int[][] timeline;

    /**
     * updateTime will update specific day/hour on timeline
     * 
     * @param day  desired day to udpate
     * @param hour desired hour to update
     */
    public void updateTime(int day, int hour) {
        // this is gonna get figured out
    }

    /**
     * clearDay will clear specific day on timeline with 0 to indiciate it is
     * available
     * 
     * @param day desired day to clear
     */
    public void clearDay(int day) {
        // this will get handled
    }

    /**
     * getAvailableHours will either display available hours or update another data
     * structure with availableHours
     */
    public void getAvailableHours() {
        // this needs more thought, whether we want to output something
        // of an elaborate string into the terminal for early dev, or
        // whether we want to store it somewhere where it will get displayed
        // on the html side of things
    }
}