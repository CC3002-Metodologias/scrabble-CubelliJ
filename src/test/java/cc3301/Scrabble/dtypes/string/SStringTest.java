package cc3301.Scrabble.dtypes.string;

import cc3301.Scrabble.dtypes.bool.SBool;
import cc3301.Scrabble.dtypes.number.flt.SFloat;
import cc3301.Scrabble.dtypes.number.interger.SBinary;
import cc3301.Scrabble.dtypes.number.interger.SInt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SStringTest {
    SString s1 = new SString("Test string ");
    SString s2 = new SString("summed with another one");
    SBool b1 = new SBool(true);
    SInt i1 = new SInt(42);
    SBinary bin1 = new SBinary("1001010");
    SFloat f1 = new SFloat(3.1416);
    @Test
    void test_toString() {
        assertEquals(s1.toString().getClass(),String.class);
        assertEquals(s1.toString(), "Test string ");
    }

    @Test
    void test_toSString() {
        s2 = s1.toSString();
        assertEquals(s2.getClass(),SString.class);
        assertEquals(s2.toString(), "Test string ");
    }

    @Test
    void addedString() {
        SString s3 = s1.addedString(s2);
        assertEquals(s3.toString(), "summed with another oneTest string ");
    }

    @Test
    void add() {
        SString s3 = s1.add(s2);
        assertEquals(s3.toString(), "Test string summed with another one");
        SString s4 = s1.add(b1);
        assertEquals(s4.toString(), "Test string true");
        SString s5 = s1.add(i1);
        assertEquals(s5.toString(), "Test string 42");
        SString s6 = s1.add(bin1);
        assertEquals(s6.toString(), "Test string 1001010");
        SString s7 = s1.add(f1);
        assertEquals(s7.toString(), "Test string 3.1416");
    }
}