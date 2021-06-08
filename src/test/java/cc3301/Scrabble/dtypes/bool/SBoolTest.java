package cc3301.Scrabble.dtypes.bool;

import cc3301.Scrabble.dtypes.number.interger.SBinary;
import cc3301.Scrabble.dtypes.string.SString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SBoolTest {
    SBool testSBool;
    SBool ftestSBool;
    SString resSString;
    SBinary bin1;
    @BeforeEach
    void setUp() {
        testSBool = new SBool(true);
        ftestSBool = new SBool(false);
        bin1 = new SBinary("10110101");
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

    @Test
    void or() {
        assertEquals(testSBool.or(bin1).toBinary(), "11111111");
        assertEquals(ftestSBool.or(bin1).toBinary(), "10110101");
    }

    @Test
    void and() {
        assertEquals(testSBool.and(bin1).toBinary(), "10110101");
        assertEquals(ftestSBool.and(bin1).toBinary(), "00000000");
    }

    @Test
    void orbyBool() {
        testSBool.orbyBool(ftestSBool);
    }

    @Test
    void andbyBool() {
    }

    @Test
    void orbyBinary() {
    }

    @Test
    void andbyBinary() {
    }
}