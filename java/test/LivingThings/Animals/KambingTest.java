import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.*;
/**
 * KambingTest Class.
 *
 * @author Ghazwan S. M.
 * @since 2019.04.19
 */
public class KambingTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Kambing kambing;
    private Renderable r;

    
    public void setUp() {
        r.render();
        kambing = new Kambing(0, 0, r);
        System.setOut(new PrintStream(outContent));
    }

    
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testTalk() {
        final String expected = "MBEKKKK Mbekkk";

        kambing.talk();

        assertEquals(outContent.toString(), expected);
    }

    @Test
    public void testGetChar() {
        final char expected = 'K';

        assertEquals(kambing.getChar(), expected);
    }

    @Test
    public void testGetCountProduct() {
        final int expected = 0;

        assertEquals((int) kambing.getCountProduct(), expected);
    }

    @Test
    public void testGetProduct() {
        final int expected = 0;

        assertEquals((int) kambing.getCountProduct(), expected);
    }

    @Test
    public void testPrint() {
        final String expected = "kambing 0 Full : 5 pos : 0 0";

        kambing.print();

        assertEquals(outContent.toString(), expected);
    }
}