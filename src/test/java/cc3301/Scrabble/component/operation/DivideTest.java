package cc3301.Scrabble.component.operation;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.dtypes.number.interger.SBinary;
import cc3301.Scrabble.dtypes.number.interger.SInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideTest {
    iComponent div_tree;
    @BeforeEach
    void setUp() {
        div_tree = new Divide( new SInt(25), new SBinary("0101")); // 25 / 5 = 5
    }

    @Test
    void testTree() {
        SInt result = (SInt) div_tree.operate();
        assertEquals(25/5, result.toInt());
    }
}