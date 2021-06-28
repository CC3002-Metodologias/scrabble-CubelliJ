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
    SString s1;
    @BeforeEach
    void setUp() {
        testSBool = new SBool(true);
        ftestSBool = new SBool(false);
        bin1 = new SBinary("10110101");
        s1 = new SString("Se agrega un string a ");
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

    //Double dispatch String adds bool:
    @Test
    void addedString() {
        SString s3 = testSBool.addedString(s1);
        assertEquals(s3.toString(), "Se agrega un string a true");
    }

    @Test
    void or() {
        assertEquals(testSBool.or(bin1).toBinary(), "11111111");
        assertEquals(ftestSBool.or(bin1).toBinary(), "10110101");
        assertEquals(testSBool.or(testSBool).toBool(), true); // T or T
        assertEquals(testSBool.or(ftestSBool).toBool(), true); // T or F
        assertEquals(ftestSBool.or(testSBool).toBool(), true); // F or T
        assertEquals(ftestSBool.or(ftestSBool).toBool(), false); // F or F
    }

    @Test
    void and() {
        assertEquals(testSBool.and(bin1).toBinary(), "10110101");
        assertEquals(ftestSBool.and(bin1).toBinary(), "00000000");
        assertEquals(testSBool.and(testSBool).toBool(), true); // T and T
        assertEquals(testSBool.and(ftestSBool).toBool(), false); // T and F
        assertEquals(ftestSBool.and(testSBool).toBool(), false); // F and T
        assertEquals(ftestSBool.and(ftestSBool).toBool(), false); // F and F
    }

    @Test
    void orbyBool() {
        SBool b1 = (SBool) testSBool.orbyBool(ftestSBool);
        SBool b2 = (SBool) ftestSBool.orbyBool(ftestSBool);
        assertEquals(b1.toBool(), true);
        assertEquals(b2.toBool(), false);
    }

    @Test
    void andbyBool() {
        SBool b1 = (SBool) testSBool.andbyBool(testSBool);
        SBool b2 = (SBool) testSBool.andbyBool(ftestSBool);
        assertEquals(b1.toBool(), true);
        assertEquals(b2.toBool(), false);
    }

    @Test
    void orbyBinary() {
        SBinary bin3 = testSBool.orbyBinary(bin1);
        SBinary bin4 = ftestSBool.orbyBinary(bin1);
        assertEquals(bin3.toBinary(), "11111111");
        assertEquals(bin4.toBinary(), "10110101");
    }

    @Test
    void andbyBinary() {
        SBinary bin3 = testSBool.andbyBinary(bin1);
        SBinary bin4 = ftestSBool.andbyBinary(bin1);
        assertEquals(bin3.toBinary(), "10110101");
        assertEquals(bin4.toBinary(), "00000000");
    }
}