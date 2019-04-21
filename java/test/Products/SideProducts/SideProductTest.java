import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * SideProductTest Class.
 *
 * @author Ghazwan S. M.
 * @since 2019.04.19
 */
public class SideProductTest {
    private SideProduct sideProduct;

    @Before
    public void setUp() {
        sideProduct = new SideProduct();
    }

    @Test
    public void testGetProductValue() {
        final int expected = 0;

        assertEquals(sideProduct.getProductValue(), expected);
    }

    @Test
    public void testGetPortion() {
        final int expected = 0;

        assertEquals(sideProduct.getPortion(), expected);
    }

    @Test
    public void testGetExpireValue() {
        final int expected = 0;

        assertEquals(sideProduct.getExpireValue(), expected);
    }

    @Test
    public void testSetExpireValue() {
        final int expected = 0;

        assertEquals(sideProduct.setExpireValue(), expected);
    }

    @Test
    public void testIsExpire() {
        final boolean expected = true;

        assertEquals(sideProduct.isExpire(), expected);
    }
}