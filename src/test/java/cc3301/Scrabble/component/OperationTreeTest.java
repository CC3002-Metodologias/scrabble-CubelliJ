package cc3301.Scrabble.component;

import cc3301.Scrabble.component.operation.*;
import cc3301.Scrabble.component.variable.VarFactory;
import cc3301.Scrabble.dtypes.number.flt.SFloat;
import cc3301.Scrabble.dtypes.number.interger.SBinary;
import cc3301.Scrabble.dtypes.number.interger.SInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OperationTreeTest {
    iComponent sub_tree;

    @BeforeEach
    void setUp() {
         sub_tree = new Subtract( new SInt(25), new SBinary("0101")); // 25 - 5
    }

    @Test
    void testTree() {
        SInt result = (SInt) sub_tree.operate();
        assertEquals(25 - 5, result.toInt());
    }

    @Test
    void testcomplexTree() {
        VarFactory factory = new VarFactory();
        factory.createVar("x", new SInt(20));
        factory.createVar("y", new SInt(20));
        factory.createVar("z", new SInt(80));




    }


}
