package cc3301.Scrabble.dtypes.number.flt;

import cc3301.Scrabble.dtypes.number.AbstractNumber;
import cc3301.Scrabble.dtypes.string.SString;

public class SFloat extends AbstractNumber {
    private double flt;
    // Constructor
    public SFloat(double flt){
        this.flt = flt;
    }

    @Override
    public SString toSString() {
        String value = String.valueOf(this.flt); // Método de boolean (?)
        return new SString(value);
    }

    @Override
    public SFloat toSFloat() {
        return this;
    }

    @Override
    public double toFloat() {
        return this.flt;
    }
}
