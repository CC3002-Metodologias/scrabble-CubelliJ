package cl.uchile.dcc.scrabble.number;

import cl.uchile.dcc.scrabble.string.SString;

public class SFloat {
    private double flt;

    public SFloat(double flt){
        this.flt = flt;
    }

    @Override
    public String toString(){
        String str = String.valueOf(this.flt);
        return str;
    }



}
