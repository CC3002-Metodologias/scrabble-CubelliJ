package cc3301.Scrabble.dtypes.number.flt;

import cc3301.Scrabble.dtypes.string.SString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SFloatTest {
    SFloat f1;
    SFloat f2;
    @BeforeEach
    void setUp() {
        f1 = new SFloat(3.23);
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
}