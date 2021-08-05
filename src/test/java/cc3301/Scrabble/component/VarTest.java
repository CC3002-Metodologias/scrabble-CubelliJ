package cc3301.Scrabble.component;

import cc3301.Scrabble.component.variable.Var;
import cc3301.Scrabble.dtypes.number.interger.SInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VarTest {
    Var var;
    Var var2;
    Var var3;
    SInt i1;
    SInt i2;
    @BeforeEach
    void setUp() {
        i1 = new SInt(23);
        i2 = new SInt(12);
        var = new Var("x", i1);
        var2 = new Var("y", i1);
        var3 = new Var("z", i2);
    }

    @Test
    void get_name() {
        assertEquals("x", var.get_name());
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

    @Test
    void compareTo() {
        assertEquals(0, var.compareTo(var2.get_value()));
        assertEquals(1, var.compareTo(var3.get_value()));
        assertEquals(-1, var3.compareTo(var.get_value()));
    }
}