package cc3301.Scrabble.component.instruction;

import cc3301.Scrabble.component.operation.Add;
import cc3301.Scrabble.component.variable.VarFactory;
import cc3301.Scrabble.dtypes.bool.SBool;
import cc3301.Scrabble.dtypes.number.interger.SInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IfTest2 {
    VarFactory factory;
    If if_test;
    @BeforeEach
    void setUp() {
        factory = new VarFactory();
        factory.createVar("a", new SInt(32));
        factory.createVar("b", new SInt(22));
        factory.createVar("x", new SBool(true));
        factory.createVar("a", new If(factory.get("x"),
                                            new Add(factory.get("a"),
                                                    factory.get("b")), // true: a+b
                                            new Add(factory.get("a"),
                                                    factory.get("a"))));
    }

    @Test
    void operate() {
        factory.createVar("x", new SBool(false));
        if_test = new If(factory.get("x"),
                    new Add(factory.get("a"),
                            factory.get("b")), // true: a+b
                    new Add(factory.get("a"),
                            factory.get("a"))); // false: 2a
        factory.createVar("a", if_test).operate(); // 2a
        factory.createVar("x", new SBool(true));
        factory.createVar("a", if_test).operate(); // 2a+b

        assertEquals(factory.get("a").get_value().toString(), "130");
    }

}