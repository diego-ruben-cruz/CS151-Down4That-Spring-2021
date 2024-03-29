import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test class for Vote class.
 * 
 * @author DCruz
 */
public class TestVote {

    @Test
    public void testGetAuthorID() {
        Vote testVote = new Vote("test_user", false);

        assertEquals("test_user", testVote.getAuthorID());
    }

    @Test
    public void testSwitchValue() {
        Vote testVote = new Vote("test_user", false);
        testVote.switchValue();

        assertEquals(true, testVote.getValue());
    }
}