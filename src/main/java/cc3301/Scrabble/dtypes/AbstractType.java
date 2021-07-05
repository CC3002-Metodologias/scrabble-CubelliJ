package cc3301.Scrabble.dtypes;

import cc3301.Scrabble.dtypes.bool.SBool;
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

    // Allows the introduction of STypes into the Node operation world.
    @Override
    public iType operate(){
        return this;
    }

    // compareTo method
    // Lets compare two iType objects by comparing their values as strings.
    // It'll be overridden when we get to the numbers.
    @Override
    public int compareTo(iType other){
        String s1 = this.toString();
        String s2 = other.toString();
        return s1.compareTo(s2);
    }
}
