package cc3301.Scrabble.component.comparator;

import cc3301.Scrabble.component.operation.Add;
import cc3301.Scrabble.component.variable.VarFactory;
import cc3301.Scrabble.dtypes.number.interger.SInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LessThanTest {
    LessThan l1;
    LessThan l2;
    VarFactory f;
    LessThan l3;
    LessThan l4;
    LessThan l5;
    @BeforeEach
    void setUp() {
        l1 = new LessThan(new SInt(23), new SInt(24));
        l2 = new LessThan(new SInt(100), new SInt(100));
        f = new VarFactory();
        f.createVar("a", new SInt(2));
        f.createVar("b", new SInt(1));
        f.createVar("c", new SInt(4));
        f.createVar("a", new Add(f.get("a"), f.get("b")));
        l3 = new LessThan(f.get("a"), f.get("c"));

    }

    @Test
    void getLeft() {
        assertEquals(l1.getLeft().toString(), "23");
    }

    @Test
    void getRight() {
        assertEquals(l1.getRight().toString(), "24");
    }

    @Test
    void operate() {
        assertEquals(l1.operate().toString(), "true");
        assertEquals(l2.operate().toString(), "false");
        assertEquals(l3.operate().toString(), "true");
        f.createVar("a", new Add(f.get("a"), f.get("b")));
        assertEquals(l3.operate().toString(), "false"); // Mutable!!!! Yas
        f.createVar("a", new Add(f.get("a"), f.get("b")));
        assertEquals(l3.operate().toString(), "false"); // Mutable!!!! Yas
    }
}