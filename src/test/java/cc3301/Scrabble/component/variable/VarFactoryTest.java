package cc3301.Scrabble.component.variable;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.component.operation.Add;
import cc3301.Scrabble.dtypes.iType;
import cc3301.Scrabble.dtypes.number.interger.SInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VarFactoryTest {
    VarFactory factory;
    Var a;
    Var b;
    Var c;
    Var d;
    Var e;
    iComponent c1;
    iComponent c2;
    iType t1;
    iType t2;
    @BeforeEach
    void setUp() {
        factory = new VarFactory();
        a = factory.createVar("a", new SInt(23));
        b = factory.createVar("b", new SInt(23));
        e = factory.get("b");
    }

    @Test
    void createValue() {
        c1 = new Add(new SInt(21), new SInt(0));
        c2 = new Add(new SInt(18), new SInt(3));
        t1 = factory.createValue(c1);
        t2 = factory.createValue(c2);
        assertEquals(t1, t2);
    }

    @Test
    void createVar() {
        assertEquals(a.operate(), b.operate());
        assertEquals(e.operate(), b.operate());
        c = factory.createVar("a", new SInt(46));
        d = factory.createVar("d", new SInt(46));
        assertEquals(a.operate(), c.operate());
        assertEquals(c.operate(), d.operate());
        assertNotEquals(a.operate(), b.operate());
        assertNotEquals(c.operate(), b.operate());
    }
}