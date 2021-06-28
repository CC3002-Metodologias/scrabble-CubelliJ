package cc3301.Scrabble.dtypes.number.interger;

import cc3301.Scrabble.dtypes.bool.SBool;
import cc3301.Scrabble.dtypes.number.flt.SFloat;
import cc3301.Scrabble.dtypes.string.SString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SBinaryTest {
    SBinary bin1;
    SBinary bin2;
    SInt i1;
    SFloat f1;
    SFloat f2;
    SBinary bin3;
    SBinary bin4;
    SBool boolT;
    SBool boolF;
    SString s1;
    @BeforeEach
    void setUp() {
        bin1 = new SBinary("11101110"); // -18
        bin2 = new SBinary("01111111"); // 127
        i1 = new SInt(32);
        boolT = new SBool(true);
        boolF = new SBool(false);
        s1 = new SString("Se agrega un string a ");
        f1 = new SFloat(32.4);
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

    //Double dispatch SBinary operates with SBinary:
    @Test
    void addedBin() {
        SBinary bin4 = bin1.addBinary(bin2);
        assertEquals(bin4.toInt(), 127+(-18));
    }

    @Test
    void subBin() {
        SBinary bin4 = bin1.subtractBinary(bin2);
        assertEquals(bin4.toInt(), 127-(-18));
    }

    @Test
    void multBin() {
        SBinary bin4 = bin1.multiplyBinary(bin2);
        assertEquals(bin4.toInt(), 127*(-18));
    }

    @Test
    void divideBin() {
        SBinary bin4 = bin1.divideBinary(bin2);
        assertEquals(bin4.toInt(), 127/(-18));
    }

    //Double dispatch SInt operates with SBinary:
    @Test
    void addedInt() {
        SInt int4 = (SInt) bin1.addInt(i1);
        assertEquals(int4.toInt(), 32+-18);
    }

    @Test
    void subInt() {
        SInt int4 = (SInt) bin1.subtractInt(i1);
        assertEquals(int4.toInt(), 32-(-18));
    }

    @Test
    void multInt() {
        SInt int4 = (SInt) bin1.multiplyInt(i1);
        assertEquals(int4.toInt(), 32*(-18));
    }

    @Test
    void divideInt() {
        SInt int4 = (SInt) bin1.divideInt(i1);
        assertEquals(int4.toInt(), 32/(-18));
    }

    //Double dispatch SFloat operates with SBinary:
    @Test
    void addedFloat() {
        SFloat f3 = bin1.addFloat(f1);
        assertEquals(f3.toFloat(), 32.4+(-18));
    }

    @Test
    void subFloat() {
        SFloat f3 = bin1.subtractFloat(f1);
        assertEquals(f3.toFloat(), 32.4-(-18));
    }

    @Test
    void multFloat() {
        SFloat f3 = bin1.multiplyFloat(f1);
        assertEquals(f3.toFloat(), 32.4*(-18));
    }

    @Test
    void divideFloat() {
        SFloat f3 = bin1.divideFloat(f1);
        assertEquals(f3.toFloat(), 32.4/(-18));
    }

    //Double dispatch String adds binary:
    @Test
    void addedString() {
        SString s3 = bin1.addedString(s1);
        assertEquals(s3.toString(), "Se agrega un string a 11101110");
    }

    // Operation with other Stypes
    @Test
    void add() {
        bin3 = bin1.add(bin2);
        bin4 = bin1.add(i1);
        assertEquals(bin3.toInt(), -18+127);
        assertEquals(bin4.toInt(), -18+32);
    }

    @Test
    void subtract() {
        bin3 = bin1.subtract(bin2);
        bin4 = bin1.subtract(i1);
        assertEquals(bin3.toInt(), -18-127);
        assertEquals(bin4.toInt(), -18-32);
    }

    @Test
    void multiply() {
        bin3 = bin1.multiply(bin2);
        bin4 = bin1.multiply(i1);
        assertEquals(bin3.toInt(), -18*127);
        assertEquals(bin4.toInt(), -18*32);
    }

    @Test
    void divide() { // Integer division ie. 3/2 != 1.5 -> 3/2 = 1
        bin3 = bin2.divide(bin1); // -127/18 = -7
        bin4 = bin1.divide(i1); // -18/32 = 0
        assertEquals(bin3.toInt(), -7);
        assertEquals(bin4.toInt(), 0);
    }

    @Test
    void or() { // SBinary or only permitted with SBool
        bin3 = bin1.or(boolT);
        bin4 = bin1.or(boolF);
        assertEquals(bin3.toBinary(), "11111111");
        assertEquals(bin4.toBinary(), "11101110");
    }

    @Test
    void and() { // SBinary and only permitted with SBool
        bin3 = bin1.and(boolT);
        bin4 = bin1.and(boolF);
        assertEquals(bin3.toBinary(), "11101110");
        assertEquals(bin4.toBinary(), "00000000");
    }

    @Test
    void orbyBool() {
        bin3 = bin1.orbyBool(boolT);
        bin4 = bin1.orbyBool(boolF);
        assertEquals(bin3.toBinary(), "11111111");
        assertEquals(bin4.toBinary(), "11101110");
    }

    @Test
    void andbyBool() {
        bin3 = bin1.andbyBool(boolT);
        bin4 = bin1.andbyBool(boolF);
        assertEquals(bin3.toBinary(), "11101110");
        assertEquals(bin4.toBinary(), "00000000");
    }
}