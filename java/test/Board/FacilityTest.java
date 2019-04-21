import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * FacilityTest Class.
 *
 * @author Ghazwan S. M.
 * @since 2019.04.19
 */
public class FacilityTest {
    private Facility facility;

    
    public void setUp() {
        facility = new Facility();
    }

    @Test
    public void testGetWellX() {
        final int expected = 14;

        assertEquals(facility.getWellX(), expected);
    }

    @Test
    public void testGetWellY() {
        final int expected = 11;

        assertEquals(facility.getWellY(), expected);
    }

    @Test
    public void testGetMixerX() {
        final int expected = 14;

        assertEquals(facility.getMixerX(), expected);
    }

    @Test
    public void testGetMixerY() {
        final int expected = 13;

        assertEquals(facility.getMixerY(), expected);
    }

    @Test
    public void testGetTruckX() {
        final int expected = 14;

        assertEquals(facility.getTruckX(), expected);
    }

    @Test
    public void testGetTruckY() {
        final int expected = 14;

        assertEquals(facility.getTruckY(), expected);
    }
}