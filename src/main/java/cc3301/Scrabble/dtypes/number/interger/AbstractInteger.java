package cc3301.Scrabble.dtypes.number.interger;

import cc3301.Scrabble.dtypes.number.AbstractNumber;

public abstract class AbstractInteger extends AbstractNumber {

    public abstract SInt toSInt();

    public int toInt(){
        return this.toSInt().toInt();
    }

    public abstract SBinary toSBinary();

    // This method will be created just to be consistent.
    public String toBinary(){
        return this.toSBinary().toBinary();
    }
}
