package cc3301.Scrabble.component.instruction;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.component.operation.Add;
import cc3301.Scrabble.component.variable.Var;
import cc3301.Scrabble.component.variable.VarFactory;
import cc3301.Scrabble.dtypes.bool.SBool;
import cc3301.Scrabble.dtypes.number.interger.SInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IfTest {
    VarFactory factory;
    Var if_test;
    iComponent if_test2;
    @BeforeEach
    void setUp() {
        factory = new VarFactory();
        factory.createVar("a", new SInt(32));
        factory.createVar("b", new SInt(22));
        factory.createVar("x", new SBool(true));
        factory.createVar("true", new SInt(54));
        factory.createVar("false", new SInt(64));
        /*if_test = factory.createVar("c",
                    new If(factory.createVar("x", null),
                        new Add(factory.createVar("a", null),
                                factory.createVar("b", null)), // true: a+b
                        new Add(factory.createVar("a", null),
                                factory.createVar("a", null)))); // false: 2a

         */
    }
    /*
    @Test
    void operate() {
        assertEquals(if_test.operate(), factory.createVar("true", null).operate());
        factory.createVar("x", new SBool(false));
        if_test = factory.createVar("c",
                    new If(factory.get("x"),
                        new Add(factory.get("a"),
                                factory.get("b")), // true: a+b
                        new Add(factory.get("a"),
                                factory.get("a")))); // false: 2a
        assertEquals(if_test.operate(), factory.createVar("false", null).operate());


    }

    @Test
    void test2(){
        if_test2 = new If(factory.createVar("x", null),
                new Add(factory.createVar("a", null),
                        factory.createVar("b", null)), // true: a+b
                new Add(factory.createVar("a", null),
                        factory.createVar("a", null)));
        iComponent result = if_test2.operate();
        factory.createVar("x", new SBool(false));
        iComponent result2 = if_test2.operate();
        assertEquals(factory.createValue(result.operate()), factory.createVar("true", null).operate());
        assertEquals(factory.createValue(result2.operate()), factory.createVar("false", null).operate());
    }

     */
}