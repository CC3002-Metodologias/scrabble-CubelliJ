package cc3301.Scrabble.dtypes;

import cc3301.Scrabble.dtypes.string.SString;

public abstract class AbstractType implements iType{
    @Override
    public String toString(){
        SString string = this.toSString();
        return string.toString();
    }

    @Override
    public abstract SString toSString();
}
