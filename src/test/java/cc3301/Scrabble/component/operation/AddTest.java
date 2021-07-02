package cc3301.Scrabble.component.operation;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.dtypes.number.interger.SBinary;
import cc3301.Scrabble.dtypes.number.interger.SInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddTest {
    iComponent add_tree;
    @BeforeEach
    void setUp() {
            add_tree = new Add( new SInt(25), new SBinary("0101")); // 25 - 5
    }

    @Test
    void testTree() {
        SInt result = (SInt) add_tree.operate();
        assertEquals(25 + 5, result.toInt());
    }
}