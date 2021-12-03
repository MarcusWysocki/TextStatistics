import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void letterCount() {
    }

    @Test
    void shavePunctuation() {
        Main main = new Main();

        assertEquals(main.shavePunctuation("sin!"), 3, "This should pass.");
        assertEquals(main.shavePunctuation("!!!sin"), 3, "This should pass.");
        //assertEquals(main.shavePunctuation("sin!!!"), 6, "This should fail.");
        assertEquals(main.shavePunctuation("----YES----"), 3, "This should pass");
        assertEquals(main.shavePunctuation("!.,[{]!--YES-..,!!!!!!!---"), 3, "This should pass");
        assertEquals(main.shavePunctuation("---!!!s-.,.[]i-----n!!!!!!!!"), 3, "This should pass");
        assertEquals(main.shavePunctuation(";:-,.?!*{}[]<>+="), 0, "This should pass");
        assertEquals(main.shavePunctuation("\"Wowza\""), 5, "This should pass");
        assertEquals(main.shavePunctuation("yes"), 3, "This should pass");
    }

    @Test
    void getMaxLength() {
    }
}