package cc3301.Scrabble.dtypes;

import cc3301.Scrabble.dtypes.string.SString;
import cc3301.Scrabble.operations.iSummable;

public abstract class AbstractType implements iType, iSummable {
    @Override
    public String toString(){
        SString string = this.toSString();
        return string.toString();
    }

    @Override
    public abstract SString toSString();

    @Override
    public SString addedString(SString string) {
        return new SString(string.toString()+this.toString());
    }
}
