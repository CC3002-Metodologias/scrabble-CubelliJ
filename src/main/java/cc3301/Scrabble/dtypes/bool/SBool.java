package cc3301.Scrabble.dtypes.bool;

import cc3301.Scrabble.dtypes.AbstractType;
import cc3301.Scrabble.dtypes.string.SString;

public class SBool extends AbstractType {
    private boolean bool;

    public SBool(boolean bool){
        this.bool = bool;
    }

    public boolean toBool(){ // To the java boolean type.
        return this.bool;
    }

    public SBool toSBool(){ // For consistency, it's actually unnecesary, might erase later.
        return new SBool(this.toBool());
    }

    @Override
    public SString toSString() {
        String value = String.valueOf(this.bool); // Método de boolean (?)
        return new SString(value);
    }
}
