package cc3301.Scrabble.component.instruction;

import cc3301.Scrabble.component.comparator.Equal;
import cc3301.Scrabble.component.comparator.LessThan;
import cc3301.Scrabble.component.iComparator;
import cc3301.Scrabble.component.operation.Add;
import cc3301.Scrabble.component.variable.VarFactory;
import cc3301.Scrabble.dtypes.bool.SBool;
import cc3301.Scrabble.dtypes.number.interger.SInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhileTest {
    VarFactory factory;
    While aWhile;
    LessThan condition;
    @BeforeEach
    void setUp() {
        factory = new VarFactory();
        factory.createVar("a", new SInt(1));
        factory.createVar("b", new SInt(2));
        factory.createVar("c", new SInt(5));
        factory.createVar("x", new SBool(true));
        condition = new LessThan(factory.get("b"), factory.get("c"));
        aWhile = new While(condition,
                            factory.createVar("b", new Add(factory.get("b"), factory.get("a")))
        );

    }

    @Test
    void testOperate() {
        assertEquals(factory.get("a").get_value().toString(), "1");
        assertEquals(factory.get("b").get_value().toString(), "2");
        assertEquals(factory.get("c").get_value().toString(), "5");
        aWhile.operate();
        assertEquals(factory.get("a").get_value().toString(), "1");
        assertEquals("4", factory.get("b").get_value().toString());

    }

}