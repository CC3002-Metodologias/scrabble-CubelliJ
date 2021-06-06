package cc3301.Scrabble.dtypes.number.interger;

import cc3301.Scrabble.dtypes.number.flt.SFloat;
import cc3301.Scrabble.dtypes.string.SString;

public class SBinary extends AbstractInteger {
    private String binary;
    public SBinary(String binary){
        this.binary = binary;
    }

    @Override
    public SBinary toSBinary() {
        return this;
    }

    @Override
    public String toBinary(){
        return this.binary;
    }

    @Override
    public SString toSString() {
        return new SString(this.binary);
    }

    @Override
    public SFloat toSFloat() {
        return this.toSInt().toSFloat();
    }

    @Override
    public int toInt() {
        return 0;
    }

    @Override
    public SInt toSInt() {
        return new SInt(this.toInt());
    }
}
