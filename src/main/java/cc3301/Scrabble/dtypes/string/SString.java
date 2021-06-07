package cc3301.Scrabble.dtypes.string;

import cc3301.Scrabble.dtypes.AbstractType;
import cc3301.Scrabble.operations.iSummable;

public class SString extends AbstractType {
    private String string;

    public SString(String string){
        this.string = string;
    }

    @Override
    public SString toSString() {
        return this;
    }

    @Override
    public String toString() {
        return this.string;
    }

    public SString add(iSummable summand){
        return summand.addedString(this);
    }
}
