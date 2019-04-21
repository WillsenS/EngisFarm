import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * CellTest Class.
 *
 * @author Ghazwan S. M.
 * @since 2019.04.19
 */
public class CellTest {
    private Cell cell;

    public void setUp() {
        cell = new Cell();
    }

    @Test
    public void testGetSizeX() {
        final int expected = 15;

        assertEquals(cell.getSizeX(), expected);
    }

    @Test
    public void testGetSizeY() {
        final int expected = 15;

        assertEquals(cell.getSizeY(), expected);
    }

    @Test
    public void testGetElement() {
        final char expected = ' ';

        assertEquals(cell.getElement(0, 0), expected);
    }

    @Test
    public void testGetTypeLand() {
        final char expected = 'o';

        assertEquals(cell.getTypeLand(0, 0), expected);
    }

    @Test
    public void testGetRumput() {
        final char expected = '*';

        assertEquals(cell.getRumput(0, 0), expected);
    }

    @Test
    public void testSetSizeX() {
        final int expected = 10;

        cell.setSizeX(10);

        assertEquals(cell.getSizeX(), expected);
    }

    @Test
    public void testSetSizeY() {
        final int expected = 10;

        cell.setSizeY(10);

        assertEquals(cell.getSizeY(), expected);
    }

    @Test
    public void testSetElement() {
        final char expected = 'A';

        cell.setElement(0, 0, 'A');

        assertEquals(cell.getElement(0, 0), expected);
    }

    @Test
    public void testSetRumput() {
        final char expected = '*';

        cell.setRumput(0, 0);

        assertEquals(cell.getRumput(0, 0), expected);
    }

    @Test
    public void testKosongRumput() {
        final char expected = ' ';

        cell.setRumput(0, 0);

        assertEquals(cell.getRumput(0, 0), expected);
    }

    @Test
    public void testIsEmptyCell() {
        final boolean expected = true;

        assertEquals(cell.isEmptyCell(0, 0), expected);
    }
}