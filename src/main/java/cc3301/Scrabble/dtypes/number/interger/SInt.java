package cc3301.Scrabble.dtypes.number.interger;

import cc3301.Scrabble.dtypes.number.flt.SFloat;
import cc3301.Scrabble.dtypes.string.SString;

public class SInt extends AbstractInteger{
    private int integer;
    public SInt(int integer){
        this.integer = integer;
    }

    @Override
    public SString toSString() {
        return null;
    }

    @Override
    public SFloat toSFloat() {
        return new SFloat(this.integer);
    }

    @Override
    public SInt toSInt() {
        return this;
    }

    @Override
    public String toBinary(){
        return null;
    }

    @Override
    public int toInt() {
        return this.integer;
    }

    @Override
    public SBinary toSBinary() {
        return new SBinary(this.toBinary());
    }
}
