package cc3301.Scrabble.component.comparator;

import cc3301.Scrabble.component.operation.Add;
import cc3301.Scrabble.component.variable.VarFactory;
import cc3301.Scrabble.dtypes.number.interger.SInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EqualTest {
    Equal e1;
    Equal e2;
    VarFactory f;
    Equal e3;
    Equal e4;
    Equal e5;
    @BeforeEach
    void setUp() {
        e1 = new Equal(new SInt(23), new SInt(24));
        e2 = new Equal(new SInt(100), new SInt(100));
        f = new VarFactory();
        f.createVar("a", new SInt(2));
        f.createVar("b", new SInt(1));
        f.createVar("c", new SInt(4));
        f.createVar("a", new Add(f.get("a"), f.get("b")));
        e3 = new Equal(f.get("a"), f.get("c"));

    }

    @Test
    void getLeft() {
        assertEquals(e1.getLeft().toString(), "23");
    }

    @Test
    void getRight() {
        assertEquals(e1.getRight().toString(), "24");
    }

    @Test
    void operate() {
        assertEquals(e1.operate().toString(), "false");
        assertEquals(e2.operate().toString(), "true");
        assertEquals(e3.operate().toString(), "false");
        f.createVar("a", new Add(f.get("a"), f.get("b")));
        assertEquals(e3.operate().toString(), "true"); // Mutable!!!! Yas
    }
}