package cc3301.Scrabble.component;

import cc3301.Scrabble.dtypes.number.interger.SInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VarTest {
    Var var;
    SInt i1;
    SInt i2;
    @BeforeEach
    void setUp() {
        i1 = new SInt(23);
        i2 = new SInt(12);
        var = new Var("x", i1);
    }

    @Test
    void getVar_name() {
        assertEquals("x", var.getVar_name());
    }

    @Test
    void setValue() {
        var.setValue(i2);
        assertEquals(i2, var.operate());
    }

    @Test
    void operate() {
        assertEquals(i1, var.operate());
    }
}