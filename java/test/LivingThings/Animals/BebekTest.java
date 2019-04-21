import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.*;
/**
 * BebekTest Class.
 *
 * @author Ghazwan S. M.
 * @since 2019.04.19
 */
public class BebekTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Bebek bebek;
    private Renderable r;

    
    public void setUp() {
        r.render();
        bebek = new Bebek(0, 0, r);
        System.setOut(new PrintStream(outContent));
    }

    
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testTalk() {
        final String expected = "Qwekk qwekk";

        bebek.talk();

        assertEquals(outContent.toString(), expected);
    }

    @Test
    public void testGetChar() {
        final char expected = 'B';

        assertEquals(bebek.getChar(), expected);
    }

    @Test
    public void testGetCountProduct() {
        final int expected = 0;

        assertEquals((int) bebek.getCountProduct(), expected);
    }

    @Test
    public void testGetProduct() {
        final int expected = 0;

        assertEquals((int) bebek.getCountProduct(), expected);
    }

    @Test
    public void testPrint() {
        final String expected = "bebek 0 Full : 5 pos : 0 0";

        bebek.print();

        assertEquals(outContent.toString(), expected);
    }
}