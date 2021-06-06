package cc3301.Scrabble.dtypes.bool;

import cc3301.Scrabble.dtypes.string.SString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SBoolTest {
    SBool testSBool;
    SString resSString;
    @BeforeEach
    void setUp() {
        testSBool = new SBool(true);
    }

    @Test
    void test_toBool(){
        assertEquals(testSBool.toBool(), true);
    }

    @Test
    void test_toSBool(){
        assertEquals(testSBool.toSBool().getClass(), SBool.class);
    }

    @Test
    void test_toString() {
        assertEquals(testSBool.toString(), "true");
    }

    @Test
    void test_toSString() {
        assertEquals(testSBool.toSString().getClass(), SString.class); // Veamos que cree un SString.
        resSString = testSBool.toSString();
        assertEquals(resSString.toString(), "true");
    }


}