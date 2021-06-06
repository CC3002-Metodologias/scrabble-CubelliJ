package cc3301.Scrabble.dtypes.number.interger;

import cc3301.Scrabble.dtypes.number.flt.SFloat;
import cc3301.Scrabble.dtypes.string.SString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SBinaryTest {
    SBinary bin1;
    SBinary bin2;
    @BeforeEach
    void setUp() {
        bin1 = new SBinary("11101110"); // -18
        bin2 = new SBinary("01111111"); // 127
    }

    @Test
    void toInt() {
        assertEquals(bin1.toInt(), -18);
        assertEquals(bin2.toInt(), 127);
    }

    @Test
    void toBinary() {
        assertEquals(bin1.toBinary(), "11101110");
        assertEquals(bin2.toBinary(), "01111111");
    }

    @Test
    void toFloat() {
        assertEquals(bin1.toFloat(), -18.0); // Is this the representation?
        assertEquals(bin2.toFloat(), 127.0);
    }

    @Test
    void testToString() {
        assertEquals(bin1.toString(), bin1.toBinary());
        assertEquals(bin2.toString(), bin2.toBinary());
    }

    @Test
    void toSBinary() {
        assertEquals(bin1.toSBinary(), bin1);
        assertEquals(bin2.toSBinary(), bin2);
    }

    @Test
    void toSString() {
        assertEquals(bin1.toSString().getClass(), SString.class);
        assertEquals(bin1.toSString().toString(), "11101110");
    }

    @Test
    void toSFloat() {
        assertEquals(bin1.toSFloat().getClass(), SFloat.class);
        assertEquals(bin1.toSFloat().toFloat(), bin1.toFloat());
    }

    @Test
    void toSInt() {
        assertEquals(bin1.toSInt().getClass(), SInt.class);
        assertEquals(bin1.toSInt().toInt(), bin1.toInt());
    }
}