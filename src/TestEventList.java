
import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;

/**
 * JUnit test class for EventList class.
 * 
 * @author Akela Do-Ho
 */
public class TestEventList {
        @Test
        public void testAddEvent() {
                Event eventOne = new Event("User_1", "Event Juan", "Juan's House",
                                LocalDateTime.parse("08-05-2021 14:00", Event.eventFormatter));
                Event eventTwo = new Event("User_2", "Party", "Apple Gate",
                                LocalDateTime.parse("01-04-2021 15:00", Event.eventFormatter));

                EventList main = new EventList();
                main.addEvent(eventOne);
                int sizing = main.getSize();
                main.addEvent(eventTwo);

                assertEquals(sizing + 1, main.getSize());
        }

        @Test
        public void testDeleteEvent() {
                Event eventOne = new Event("User_1", "Event Juan", "Juan's House",
                                LocalDateTime.parse("08-05-2021 14:00", Event.eventFormatter));
                Event eventTwo = new Event("User_2", "Party", "Apple Gate",
                                LocalDateTime.parse("01-04-2021 15:00", Event.eventFormatter));

                EventList main = new EventList();
                main.addEvent(eventOne);
                main.addEvent(eventTwo);
                int sizing = main.getSize();
                main.deleteEvent(eventOne);

                assertEquals(sizing - 1, main.getSize());
        }

        @Test
        public void testDisplayEvents() {
                Event eventOne = new Event("User_1", "Event Juan", "Juan's House",
                                LocalDateTime.parse("08-05-2021 14:00", Event.eventFormatter));
                Event eventTwo = new Event("User_2", "Party", "Apple Gate",
                                LocalDateTime.parse("01-04-2021 15:00", Event.eventFormatter));

                EventList main = new EventList();
                main.addEvent(eventOne);
                main.addEvent(eventTwo);
                main.displayEvents();
                EventList test = main;
                test.displayEvents();

                assertEquals(test, main);
        }
}