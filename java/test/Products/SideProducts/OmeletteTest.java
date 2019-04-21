import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * OmeletteTest Class.
 *
 * @author Ghazwan S. M.
 * @since 2019.04.19
 */
public class OmeletteTest {
    private Omelette omelette;

    
    public void setUp() {
        omelette = new Omelette(5);
    }

    @Test
    public void testGetProductValue() {
        final int expected = 6;

        assertEquals(omelette.getProductValue(), expected);
    }

    @Test
    public void testGetPortion() {
        final int expected = 5;

        assertEquals(omelette.getPortion(), expected);
    }

    @Test
    public void testGetExpireValue() {
        final int expected = 5;

        assertEquals(omelette.getExpireValue(), expected);
    }

    @Test
    public void testSetExpireValue() {
        final int expected = 4;
        omelette.setExpireValue();
        assertEquals(omelette.getExpireValue(), expected);
    }

    @Test
    public void testIsExpire() {
        final boolean expected = false;

        assertEquals(omelette.isExpire(), expected);
    }
}