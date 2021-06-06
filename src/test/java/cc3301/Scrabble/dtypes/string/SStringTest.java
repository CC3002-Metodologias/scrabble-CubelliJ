package cc3301.Scrabble.dtypes.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SStringTest {
    SString s1 = new SString("Test string");
    SString s2;
    @Test
    void test_toString() {
        assertEquals(s1.toString().getClass(),String.class);
        assertEquals(s1.toString(), "Test string");
    }

    @Test
    void test_toSString() {
        s2 = s1.toSString();
        assertEquals(s2.toString(), "Test string");
    }
}