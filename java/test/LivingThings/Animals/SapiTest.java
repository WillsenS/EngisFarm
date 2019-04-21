import static org.junit.Assert.assertEquals;
import java.io.*;
import org.junit.Test;

/**
 * SapiTest Class.
 *
 * @author Ghazwan S. M.
 * @since 2019.04.19
 */
public class SapiTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Sapi sapi;
    private Renderable r;

    
    public void setUp() {
        r.render();
        sapi = new Sapi(0, 0, r);
        System.setOut(new PrintStream(outContent));
    }

    
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testTalk() {
        final String expected = "MOO MOO";

        sapi.talk();

        assertEquals(outContent.toString(), expected);
    }

    @Test
    public void testGetChar() {
        final char expected = 'S';

        assertEquals(sapi.getChar(), expected);
    }

    @Test
    public void testGetCountProduct() {
        final int expected = 0;

        assertEquals((int) sapi.getCountProduct(), expected);
    }

    @Test
    public void testGetProduct() {
        final int expected = 0;

        assertEquals((int) sapi.getCountProduct(), expected);
    }

    @Test
    public void testPrint() {
        final String expected = "sapi 0 Full : 5 pos : 0 0";

        sapi.print();

        assertEquals(outContent.toString(), expected);
    }
}