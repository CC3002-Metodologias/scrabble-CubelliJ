package cl.uchile.dcc.scrabble.logical;

import cl.uchile.dcc.scrabble.iType;

public abstract class Logical<Log> implements iType {

    public abstract Log conjlog();

    public abstract Log dislog();

}
