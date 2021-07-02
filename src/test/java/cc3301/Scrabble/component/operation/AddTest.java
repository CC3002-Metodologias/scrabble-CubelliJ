package cc3301.Scrabble.component.operation;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.dtypes.number.interger.SBinary;
import cc3301.Scrabble.dtypes.number.interger.SInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddTest {
    iComponent add_tree;
    iComponent bool_tree;
    iComponent add_tree2;
    @BeforeEach
    void setUp() {
        add_tree = new Add( new SInt(25), new SBinary("0101")); // 25 + 5
        bool_tree = new Add( new SInt(25), new SBinary("0101")).toSBinary(); // 25 + 5
        add_tree2 = new Add(new Add( new SInt(25), new SBinary("0101")).toSBinary(), new Subtract(new SInt(23), new SBinary("011"))); // 25 - 5
    }

    @Test
    void testTree() {
        SInt result = (SInt) add_tree.operate();
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
}