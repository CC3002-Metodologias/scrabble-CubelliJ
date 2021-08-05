package cc3301.Scrabble.component.comparator;

import cc3301.Scrabble.component.operation.Add;
import cc3301.Scrabble.component.variable.VarFactory;
import cc3301.Scrabble.dtypes.number.interger.SInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreaterThanTest {
    GreaterThan g1;
    GreaterThan g2;
    VarFactory f;
    GreaterThan g3;
    GreaterThan g4;
    GreaterThan g5;
    GreaterThan g6;
    @BeforeEach
    void setUp() {
        g1 = new GreaterThan(new SInt(23), new SInt(24));
        g2 = new GreaterThan(new SInt(100), new SInt(100));
        f = new VarFactory();
        f.createVar("a", new SInt(2));
        f.createVar("b", new SInt(1));
        f.createVar("c", new SInt(4));
        f.createVar("a", new Add(f.get("a"), f.get("b")));
        g3 = new GreaterThan(f.get("a"), f.get("c"));
        g6 = new GreaterThan(new SInt(102), new SInt(101));

    }

    @Test
    void getLeft() {
        assertEquals(g1.getLeft().toString(), "23");
    }

    @Test
    void getRight() {
        assertEquals(g1.getRight().toString(), "24");
    }

    @Test
    void operate() {
        assertEquals(g1.operate().toString(), "false");
        assertEquals(g2.operate().toString(), "false");
        assertEquals(g3.operate().toString(), "false");
        assertEquals(g6.operate().toString(), "true");
        f.createVar("a", new Add(f.get("a"), f.get("b")));
        assertEquals(g3.operate().toString(), "false"); // Mutable!!!! Yas
        f.createVar("a", new Add(f.get("a"), f.get("b")));
        assertEquals(g3.operate().toString(), "true"); // Mutable!!!! Yas
        f.createVar("a", new Add(f.get("a"), f.get("b")));
        assertEquals(g3.operate().toString(), "true"); // Mutable!!!! Yas
    }
}