package cc3301.Scrabble.component.operation;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.dtypes.bool.SBool;
import cc3301.Scrabble.dtypes.number.interger.SBinary;
import cc3301.Scrabble.dtypes.number.interger.SInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AndTest {
    iComponent and_tree_1;
    iComponent and_tree_2;

    @BeforeEach
    void setUp() {
        and_tree_1 = new And( new SBool(true), new SBinary("0101")); // "0101"
        and_tree_2 = new And( new SBinary("0101"), new SBool(false)); // "0101"
    }

    @Test
    void testTree() {
        SBinary result1 = (SBinary) and_tree_1.operate();
        SBinary result2 = (SBinary) and_tree_2.operate();
        assertEquals("0101", result1.toBinary());
        assertEquals("0000", result2.toBinary());
    }
}