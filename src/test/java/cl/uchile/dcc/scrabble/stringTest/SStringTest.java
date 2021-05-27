package cl.uchile.dcc.scrabble.stringTest;

import cl.uchile.dcc.scrabble.string.SString;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class SStringTest {
    private SString testSString;

    @Before
    void setUp(){
        testSString = new SString("Hola, me llamo Joaquin");
    }

    @Test
    void basicTest(){
        assert(SString.toString() == "Hola, me llamo Joaquin");
    }
}
