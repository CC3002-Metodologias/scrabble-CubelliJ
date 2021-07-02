package cc3301.Scrabble.dtypes;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.dtypes.string.SString;
import cc3301.Scrabble.operations.iSummable;

/**
 * AbstractType extends iType and iSummable
 * Some abstract methods are overriten here, such as addedString (dd) and toString.
 */
public abstract class AbstractType implements iType, iSummable {
    // Transforms the abstractType to a String
    @Override
    public String toString(){
        SString string = this.toSString();
        return string.toString();
    }

    // AbstractType to Scrabble's String
    @Override
    public abstract SString toSString();

    // Double dispatch, SString summed with AbstractType
    @Override
    public SString addedString(SString string) {
        return new SString(string.toString()+this.toString());
    }

    @Override
    public iComponent operate(){
        return this;
    }
}
