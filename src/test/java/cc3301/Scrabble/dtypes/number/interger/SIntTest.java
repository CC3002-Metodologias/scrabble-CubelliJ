package cc3301.Scrabble.dtypes.number.interger;

import cc3301.Scrabble.dtypes.number.flt.SFloat;
import cc3301.Scrabble.dtypes.string.SString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SIntTest {
    SInt int1;
    SInt int2;
    @BeforeEach
    void setUp() {
        int1 = new SInt(3);
        int2 = new SInt(-3);
    }

    @Test
    void toInt() {
        assertEquals(int1.toInt(), 3);
        assertEquals(int2.toInt(), -3);
    }

    @Test
    void toBinary() {
        assertEquals(int1.toBinary(), "011");
        assertEquals(int2.toBinary(), "1101");
    }

    @Test
    void toFloat() {
        assertEquals(int1.toFloat(), 3.0);
        assertEquals(int2.toFloat(), -3.0);
    }

    @Test
    void testToString() {
        assertEquals(int1.toString(), "3");
        assertEquals(int2.toString(), "-3");
    }

    @Test
    void toSString() {
        assertEquals(int1.toSString().getClass(), SString.class);
        assertEquals(int1.toSString().toString(), "3");
    }

    @Test
    void toSFloat() {
        assertEquals(int1.toSFloat().getClass(), SFloat.class);
        assertEquals(int1.toSFloat().toFloat(), 3.0);
    }

    @Test
    void toSInt() {
        assertEquals(int1.toSInt(), int1);
    }

    @Test
    void toSBinary() {
        assertEquals(int1.toSBinary().getClass(), SBinary.class);
        assertEquals(int1.toSBinary().toBinary(), "011");
    }
}