package cc3301.Scrabble.dtypes.number;

import cc3301.Scrabble.dtypes.AbstractType;
import cc3301.Scrabble.dtypes.number.flt.SFloat;
import cc3301.Scrabble.dtypes.string.SString;

public abstract class AbstractNumber extends AbstractType {
    @Override
    public abstract SString toSString();

    public abstract SFloat toSFloat();

    public double toFloat(){
        return this.toSFloat().toFloat();
    }

}
