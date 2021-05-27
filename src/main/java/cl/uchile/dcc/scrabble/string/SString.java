package cl.uchile.dcc.scrabble.string;

import cl.uchile.dcc.scrabble.iType;

public class SString implements iType {
    private String string;

    public SString(String string){
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }

    @Override
    public iType add(iType other) {
        return new SString(this.string + other.toString());
    }

}
