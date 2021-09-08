package cc3301.Scrabble.component.operation;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.dtypes.bool.SBool;
import cc3301.Scrabble.dtypes.number.interger.SBinary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NegateTest {
    iComponent n1;
    iComponent n2;

    @BeforeEach
    void setUp() {
        n1 = new Negate(new SBinary("0101")); // "1111"
        n2 = new Negate(new SBool(false)); // "0101"
    }

    @Test
    void testTree() {
        SBinary r1 = (SBinary) n1.operate();
        SBool r2 = (SBool) n2.operate();
        assertEquals("1010", r1.toBinary());
        assertEquals(true, r2.toBool());
    }
}