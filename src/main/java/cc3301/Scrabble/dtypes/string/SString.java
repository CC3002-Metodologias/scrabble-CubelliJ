package cc3301.Scrabble.dtypes.string;

import cc3301.Scrabble.dtypes.AbstractType;

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
}
