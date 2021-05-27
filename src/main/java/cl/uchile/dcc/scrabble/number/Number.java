package cl.uchile.dcc.scrabble.number;

import cl.uchile.dcc.scrabble.iType;

public abstract class Number<Num> implements iType {

    public abstract double toFloat();

    public abstract Num resta();

    public abstract Num div();

    public abstract Num mul();



}
