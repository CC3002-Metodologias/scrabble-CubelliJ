package cc3301.Scrabble.dtypes.number.interger;

import cc3301.Scrabble.dtypes.number.flt.SFloat;
import cc3301.Scrabble.dtypes.string.SString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SIntTest {
    SInt int1;
    SInt int2;
    SBinary b1;
    SFloat f1;
    SInt int3;
    SInt int4;
    SFloat f2;
    SString s1;
    @BeforeEach
    void setUp() {
        int1 = new SInt(3);
        int2 = new SInt(-3);
        b1 = new SBinary("0100"); // 4
        f1 = new SFloat(1.092e3);
        s1 = new SString("Se agrega un string a ");
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

    //Double dispatch String adds int:
    @Test
    void addedString() {
        SString s3 = int1.addedString(s1);
        assertEquals(s3.toString(), "Se agrega un string a 3");
    }

    //Double dispatch SBinary operates with SInt:
    @Test
    void addedBin() {
        SBinary bin4 = int1.addBinary(b1);
        assertEquals(bin4.toInt(), 4+3);
    }

    @Test
    void subBin() {
        SBinary bin4 = int1.subtractBinary(b1);
        assertEquals(bin4.toInt(), 4-3);
    }

    @Test
    void multBin() {
        SBinary bin4 = int1.multiplyBinary(b1);
        assertEquals(bin4.toInt(), 4*3);
    }

    @Test
    void divideBin() {
        SBinary bin4 = int1.divideBinary(b1);
        assertEquals(bin4.toInt(), 4/3); // 1
    }

    //Double dispatch SInt operates with SInt:
    @Test
    void addedInt() {
        SInt int4 = (SInt) int2.addInt(int1);
        assertEquals(int4.toInt(), 3+(-3));
    }

    @Test
    void subInt() {
        SInt int4 = (SInt) int2.subtractInt(int1);
        assertEquals(int4.toInt(), 3-(-3));
    }

    @Test
    void multInt() {
        SInt int4 = (SInt) int2.multiplyInt(int1);
        assertEquals(int4.toInt(), 3*(-3));
    }

    @Test
    void divideInt() {
        SInt int4 = (SInt) int2.divideInt(int1);
        assertEquals(int4.toInt(), 3/(-3)); // = -1
    }

    //Double dispatch SInt operates with SFloat:
    @Test
    void addedFloat() {
        SFloat f4 = int2.addFloat(f1);
        assertEquals(f4.toFloat(), 1.092e3+(-3));
    }

    @Test
    void subFloat() {
        SFloat f4 = int2.subtractFloat(f1);
        assertEquals(f4.toFloat(), 1.092e3-(-3));
    }

    @Test
    void multFloat() {
        SFloat f4 = int2.multiplyFloat(f1);
        assertEquals(f4.toFloat(), 1.092e3*(-3));
    }

    @Test
    void divideFloat() {
        SFloat f4 = int2.divideFloat(f1);
        assertEquals(f4.toFloat(), 1.092e3/(-3));
    }

    @Test
    void testadd() {
        int3 = (SInt) int1.add(b1);
        int4 = (SInt) int2.add(int1);
        f2 = (SFloat) int1.add(f1);
        assertEquals(int3.toInt(), int1.toInt()+b1.toInt());
        assertEquals(int4.toInt(), int2.toInt()+int1.toInt());
        assertEquals(f2.toFloat(), int1.toFloat()+f1.toFloat());
    }

    @Test
    void testsub() {
        int3 = (SInt) int1.subtract(b1);
        int4 = (SInt) int2.subtract(int1);
        f2 = (SFloat) int1.subtract(f1);
        assertEquals(int3.toInt(), int1.toInt()-b1.toInt());
        assertEquals(int4.toInt(), int2.toInt()-int1.toInt());
        assertEquals(f2.toFloat(), int1.toFloat()-f1.toFloat());
    }

    @Test
    void testmult() {
        int3 = (SInt) int1.multiply(b1);
        int4 = (SInt) int2.multiply(int1);
        f2 = (SFloat) int1.multiply(f1);
        assertEquals(int3.toInt(), int1.toInt()*b1.toInt());
        assertEquals(int4.toInt(), int2.toInt()*int1.toInt());
        assertEquals(f2.toFloat(), int1.toFloat()*f1.toFloat());
    }

    @Test
    void testdiv() {
        int3 = (SInt) int1.divide(b1);
        int4 = (SInt) int2.divide(int1);
        f2 = (SFloat) int1.divide(f1);
        assertEquals(int3.toInt(), int1.toInt()/b1.toInt());
        assertEquals(int4.toInt(), int2.toInt()/int1.toInt());
        assertEquals(f2.toFloat(), int1.toFloat()/f1.toFloat());
    }
}