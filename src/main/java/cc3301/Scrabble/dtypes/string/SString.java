package cc3301.Scrabble.dtypes.string;

import cc3301.Scrabble.dtypes.AbstractType;
import cc3301.Scrabble.dtypes.number.flt.SFloat;
import cc3301.Scrabble.dtypes.number.interger.SBinary;
import cc3301.Scrabble.dtypes.number.interger.SInt;
import cc3301.Scrabble.operations.iSummable;

/**
 * SString -> Scrabble's String
 * String type object storing a java String.
 * it inherits methods from AbstractType.
 *
 * It can be converted to:
 * - Java's String
 * - Itself
 *
 * It can do the following operations:
 * - add (with every other type)
 */

public class SString extends AbstractType {
    private final String string;

    public SString(String string){
        this.string = string;
    }

    // toSString Returns Itself
    @Override
    public SString toSString() {
        return this;
    }

    // getter of the String stored
    @Override
    public String toString() {
        return this.string;
    }

    // String addition with all the other STypes,
    // it uses Double dispatch to let the other types handle the operation.
    public SString add(iSummable summand){
        return summand.addedString(this);
    }

    @Override
    public SBinary addBinary(SBinary addend) {
        return null;
    }

    @Override
    public SFloat addFloat(SFloat addend) {
        return null;
    }

    @Override
    public iSummable addInt(SInt addend) {
        return null;
    }

    // Key for flyweight comparison between iType classes, generating a String like key
    // that enables to calculate a hashcode.
    @Override
    public String getKey(){
        return "SString" + this.toString();
    }
}
