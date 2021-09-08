package cc3301.Scrabble.component.operation;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.component.variable.Var;
import cc3301.Scrabble.component.variable.VarFactory;
import cc3301.Scrabble.dtypes.iType;
import cc3301.Scrabble.dtypes.number.flt.SFloat;
import cc3301.Scrabble.dtypes.number.interger.SBinary;
import cc3301.Scrabble.dtypes.number.interger.SInt;
import cc3301.Scrabble.dtypes.string.SString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddTest {
    Var add_tree;
    iComponent bool_tree;
    iComponent int_tree;
    iComponent float_tree;
    iComponent string_tree;
    iComponent add_tree2;
    VarFactory factory;
    @BeforeEach
    void setUp() {
        factory = new VarFactory();
        add_tree = factory.createVar("a", new Add(factory.createVar("a", new SInt(25)), factory.createVar("b", new SBinary("0101")))); // 25 + 5
        bool_tree = new Add( new SInt(25), new SBinary("0101")).toSBinary(); // 25 + 5
        add_tree2 = new Add(new Add( new SInt(25), new SBinary("0101")).toSBinary(), new Subtract(new SInt(23), new SBinary("011"))); // 25 - 5
    }

    @Test
    void testTree() {
        SInt result = (SInt) add_tree.operate();
        Var var2 = factory.createVar("a", null);
        assertEquals(var2.get_value(), result);
        assertEquals(25 + 5, result.toInt());
    }

    @Test
    void testBinary() {
        SBinary result = (SBinary) bool_tree.operate();
        assertEquals(25 + 5, result.toInt());
    }

    @Test
    void compositeTree() {
        SBinary result = (SBinary) add_tree2.operate();
        assertEquals((25 + 5) + (23 - 3), result.toInt());
    }

    @Test
    void toSInt() {
        int_tree = new Add( new SInt(25), new SBinary("0101")).toSInt();
        SInt result = (SInt) int_tree.operate();
        assertEquals(30, result.toInt());
    }

    @Test
    void toSFloat() {
        float_tree = new Add( new SInt(25), new SBinary("0101")).toSFloat();
        SFloat result = (SFloat) float_tree.operate();
        assertEquals(30.0, result.toFloat());
    }

    @Test
    void toSString() {
        string_tree = new Add( new SInt(25), new SBinary("0101")).toSString();
        SString result = (SString) string_tree.operate();
        assertEquals("30", result.toString());
    }

}