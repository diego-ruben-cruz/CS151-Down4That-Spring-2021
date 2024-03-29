import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

/**
 * The building block of Down4That, uses Vote and LocalDateTime classes.
 * 
 * @author DCruz
 */
public class Event implements Comparable<Event> {
    private String authorID;
    private String eventName;
    private String eventLocation;
    private LocalDateTime loggedTime;
    private ArrayList<Vote> eventVotes;

    // Useful formatter for taking in a date/time. Can be used outside of this
    // class.
    protected static DateTimeFormatter eventFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    /**
     * Creates an event object with LocalDateTime implementation.
     * 
     * @param inputID       input string for associated user ID.
     * @param inputString   input string for event name.
     * @param inputLocation input string for event location.
     * @param inputDateTime input string for event date and time.
     */
    public Event(String inputID, String inputString, String inputLocation, LocalDateTime inputDateTime) {
        authorID = inputID;
        eventName = inputString;
        eventLocation = inputLocation;
        loggedTime = inputDateTime;
        eventVotes = new ArrayList<Vote>();
    }

    /**
     * Fetches the ID of the user that created the event.
     * 
     * @return the User ID belonging to the creator of the event.
     */
    public String getAuthorID() {
        return this.authorID;
    }

    /**
     * Fetches the event name.
     * 
     * @return A string representing the event name.
     */
    public String getName() {
        return this.eventName;
    }

    /**
     * Sets the event name to a new value.
     * 
     * @param newName The new name for the event.
     */
    public void setName(String newName) {
        this.eventName = newName;
    }

    /**
     * Fetches the location of the event
     * 
     * @return A string representing the event location.
     */
    public String getLocation() {
        return this.eventLocation;
    }

    /**
     * Sets the event location to a new value.
     * 
     * @param newLocation The new location for the event
     */
    public void setLocation(String newLocation) {
        this.eventLocation = newLocation;
    }

    /**
     * Returns the date and time of the event to an easily recognizable String
     * format via LocalDateTime implemenation.
     * 
     * @return The date and time of the event.
     */
    public String getEventDateTime() {
        return this.loggedTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.MEDIUM));
        // The default detail level for displaying the event time is medium, but this
        // does not have to be the case, it be adjusted as desired.

    }

    /**
     * Sets a new Date-Time for the event object. Do we want to have separate
     * methods that also alter the date specifically, and the time specifically?
     * 
     * @param newDateTime The new Date-Time for the event.
     */
    public void setEventDateTime(LocalDateTime newDateTime) {
        loggedTime = newDateTime;
    }

    /**
     * Adds a vote to the arraylist associated with the event.
     * 
     * @param toBeAdded The vote object that is meant to be added.
     */
    public void addVote(Vote toBeAdded) {
        eventVotes.add(toBeAdded);
    }

    /**
     * Removes a vote object from the arraylist of votes based on the associated
     * UserID.
     * 
     * @param inputID The user ID of reference for which to remove the vote.
     */
    public void removeVoteByID(String inputID) {
        int index = 0;
        for (Vote v : eventVotes) {
            if (v.getAuthorID().equals(inputID)) {
                eventVotes.remove(index);
                break;
            }
            index++;
        }
    }

    /**
     * Removes a certain vote by its index in the arraylist.
     * 
     * @param indexToRemove The index that belongs to the vote that is supposed to
     *                      be removed.
     */
    public void removeVoteByIndex(int indexToRemove) {
        eventVotes.remove(indexToRemove);
    }

    /**
     * Gets the total number of votes associated with the event
     * 
     * @return The total number of votes
     */
    public int getTotalVotes() {
        return eventVotes.size();
    }

    /**
     * Compares an event to another event. Compares by date-time first, then name,
     * then location.
     * 
     * @return The result of the comparison.
     */
    @Override
    public int compareTo(Event other) {
        if (this.loggedTime.compareTo(other.loggedTime) == 0) {
            if (this.getName().compareTo(other.getName()) == 0) {
                return this.getLocation().compareTo(other.getLocation());
            } else {
                return this.getName().compareTo(other.getName());
            }
        } else {
            return this.loggedTime.compareTo(other.loggedTime);
        }
    }

    /**
     * Compares an event to some instance of an object for deep equality.
     * 
     * @param other The object that this one is getting compared to.
     * @return returns a boolean that is the result of checking for deep equals.
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Event) {
            return this.compareTo((Event) other) == 0;
        } else {
            return false;
        }
        /**
         * Dev Note 05 May 2021
         * 
         * Not sure if it is worth comparing the Arraylist of votes or by UserID, since
         * that does not have too much to do with what really makes an event the same as
         * another in our criteria. That is, what makes an event too similar to another
         * happens at a higher level of abstraction.
         * 
         * The most important thing is to check that the compareTo is too similar. That
         * is def the ground we all can agree on.
         * 
         * - Diego
         */
    }

    /**
     * Returns a hashcode unique to an Event object.
     * 
     * @return the hashcode of the current Event object.
     */
    @Override
    public int hashCode() {
        return this.getAuthorID().hashCode() + this.getName().hashCode() + this.getLocation().hashCode()
                + this.getEventDateTime().hashCode();
    }
}