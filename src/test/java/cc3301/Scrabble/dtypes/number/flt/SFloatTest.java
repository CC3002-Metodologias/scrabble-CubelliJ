package cc3301.Scrabble.dtypes.number.flt;

import cc3301.Scrabble.dtypes.number.interger.SBinary;
import cc3301.Scrabble.dtypes.number.interger.SInt;
import cc3301.Scrabble.dtypes.string.SString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SFloatTest {
    SFloat f1;
    SFloat f2;
    SFloat f3;
    SInt i1;
    SBinary b1;
    SFloat f4;
    SFloat f5;
    SString s1;
    @BeforeEach
    void setUp() {
        f1 = new SFloat(3.23);
        f2 = new SFloat(10.0);
        i1 = new SInt(-4);
        b1 = new SBinary("01001010"); // b1 = 74_{10}
        s1 = new SString("Se agrega un string a ");
    }

    @Test
    void test_toFloat() {
        assertEquals(f1.toFloat(), 3.23);
    }

    @Test
    void test_toString() {
        assertEquals(f1.toString(), "3.23");
    }

    @Test
    void test_toSString() {
        // Given that the generated objects will be in different memory locations,
        // the class type and the contents will be compared.
        assertEquals(f1.toSString().getClass(), new SString("3.23").getClass());
        assertEquals(f1.toSString().toString(), new SString("3.23").toString());
    }

    @Test
    void test_toSFloat() {
        assertEquals(f1.toSFloat(), f1);
    }

    //Double dispatch SString adds SFloat:
    @Test
    void addedString() {
        SString s3 = f1.addedString(s1);
        assertEquals(s3.toString(), "Se agrega un string a 3.23");
    }

    //Double dispatch SInt operates with SFloat:
    @Test
    void test_addedbyInt(){
        f4 = (SFloat) f1.addInt(i1);
        assertEquals(f4.toFloat(), f1.toFloat()+i1.toInt());
    }

    @Test
    void test_subtractedbyInt(){
        f4 = (SFloat) f1.subtractInt(i1);
        assertEquals(f4.toFloat(), i1.toInt()-f1.toFloat());
    }

    @Test
    void test_multipliedbyInt(){
        f4 = (SFloat) f1.multiplyInt(i1);
        assertEquals(f4.toFloat(), i1.toInt()*f1.toFloat());
    }

    @Test
    void test_dividedbyInt(){
        f4 = (SFloat) f1.divideInt(i1);
        assertEquals(f4.toFloat(), i1.toInt()/f1.toFloat());
    }

    // Double dispatch SFloat operating with SFloat
    @Test
    void test_addedbyFloat(){
        f4 = f1.addFloat(f2);
        assertEquals(f4.toFloat(), f2.toFloat()+f1.toFloat());
    }

    @Test
    void test_subtractedbyFloat(){
        f4 = f1.subtractFloat(f2);
        assertEquals(f4.toFloat(), f2.toFloat()-f1.toFloat());
    }

    @Test
    void test_multipliedbyFloat(){
        f4 = f1.multiplyFloat(f2);
        assertEquals(f4.toFloat(), f2.toFloat()*f1.toFloat());
    }

    @Test
    void test_dividedbyFloat(){
        f4 = f1.divideFloat(f2);
        assertEquals(f4.toFloat(), f2.toFloat()/f1.toFloat());
    }

    // Operation with other Stypes
    @Test
    void test_add(){
        f3 = f2.add(f1);
        f4 = f1.add(i1);
        f5 = f1.add(b1);
        assertEquals(f3.toFloat(), f1.toFloat()+f2.toFloat()); // SFloat + SFloat
        assertEquals(f4.toFloat(), f1.toFloat()+i1.toFloat()); // SFloat + SInt
        assertEquals(f5.toFloat(), f1.toFloat()+b1.toFloat()); // SFloat + SBinary
    }

    @Test
    void test_sub(){
        f3 = f2.subtract(f1);
        f4 = f1.subtract(i1);
        f5 = f1.subtract(b1);
        assertEquals(f3.toFloat(), f2.toFloat()-f1.toFloat()); // SFloat - SFloat
        assertEquals(f4.toFloat(), f1.toFloat()-i1.toFloat()); // SFloat - SInt
        assertEquals(f5.toFloat(), f1.toFloat()-b1.toFloat()); // SFloat - SBinary
    }

    @Test
    void test_mult(){
        f3 = f2.multiply(f1);
        f4 = f1.multiply(i1);
        f5 = f1.multiply(b1);
        assertEquals(f3.toFloat(), f2.toFloat()*f1.toFloat()); // SFloat * SFloat
        assertEquals(f4.toFloat(), f1.toFloat()*i1.toFloat()); // SFloat * SInt
        assertEquals(f5.toFloat(), f1.toFloat()*b1.toFloat()); // SFloat * SBinary
    }

    @Test
    void test_div(){
        f3 = f2.divide(f1);
        f4 = f1.divide(i1);
        f5 = f1.divide(b1);
        assertEquals(f3.toFloat(), f2.toFloat()/f1.toFloat()); // SFloat / SFloat
        assertEquals(f4.toFloat(), f1.toFloat()/i1.toFloat()); // SFloat / SInt
        assertEquals(f5.toFloat(), f1.toFloat()/b1.toFloat()); // SFloat / SBinary
    }
}