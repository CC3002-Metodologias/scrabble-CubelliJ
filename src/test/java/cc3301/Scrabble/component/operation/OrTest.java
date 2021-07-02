package cc3301.Scrabble.component.operation;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.dtypes.bool.SBool;
import cc3301.Scrabble.dtypes.number.interger.SBinary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrTest {
    iComponent or_tree_1;
    iComponent or_tree_2;

    @BeforeEach
    void setUp() {
        or_tree_1 = new Or( new SBool(true), new SBinary("0101")); // "1111"
        or_tree_2 = new Or( new SBinary("0101"), new SBool(false)); // "0101"
    }

    @Test
    void testTree() {
        SBinary result1 = (SBinary) or_tree_1.operate();
        SBinary result2 = (SBinary) or_tree_2.operate();
        assertEquals("1111", result1.toBinary());
        assertEquals("0101", result2.toBinary());
    }
}