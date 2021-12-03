import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void letterCount() {
        Main main = new Main();

        assertTrue(main.letterCount(""), "This should pass");
        assertTrue(main.letterCount("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"), "This should pass");

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
        assertEquals(main.shavePunctuation(""), 0, "This should pass");
    }

    @Test
    void getMaxLength() {
        Main main = new Main();
        int[] test1 = {2,2,3,4};
        int[] test2 = {2,2,2,2};
        int[] test3 = {};
        int[] test4 = {-2,-3,-4,-1};

        main.getMaxLength(test1);
        assertEquals(main.maxLengthsList.size(), 1, "This should pass");

        main.getMaxLength(test2);
        assertEquals(main.maxLengthsList.size(), 4, "This should pass");

        main.getMaxLength(test3);
        assertEquals(main.maxLengthsList.size(), 0, "This should pass");

        main.getMaxLength(test4);
        assertEquals(main.maxLengthsList.size(), 1, "This should fail. Max is zero by default " +
                "so negative numbers are completely ignored. You can't have negative letters in a word.");
    }
}