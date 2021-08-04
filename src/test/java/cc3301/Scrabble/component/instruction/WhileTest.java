package cc3301.Scrabble.component.instruction;

import cc3301.Scrabble.component.operation.Add;
import cc3301.Scrabble.component.variable.VarFactory;
import cc3301.Scrabble.dtypes.bool.SBool;
import cc3301.Scrabble.dtypes.number.interger.SInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhileTest {
    VarFactory factory;
    If if_test;
    If if_test2;
    @BeforeEach
    void setUp() {
        factory = new VarFactory();
        factory.createVar("a", new SInt(1));
        factory.createVar("b", new SInt(2));
        factory.createVar("c", new SInt(22));
        factory.createVar("x", new SBool(true));
        new While(factory.get("x"),
                            factory.createVar("b", new If(factory.get("x"),
                                                                new Add(factory.get("a"), factory.get("a")),
                                                                new Add(factory.get("a"), factory.get("b")))
                            )
        );

    }

    @Test
    void testOperate() {
    }

    @Test
    void testVisit() {
    }
}