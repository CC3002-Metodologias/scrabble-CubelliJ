package cc3301.Scrabble.dtypes;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.dtypes.bool.SBool;
import cc3301.Scrabble.dtypes.string.SString;

/**
 * iType defines the operations inherited by every single type,
 * in this case, the String transformation.
 */
public interface iType extends iComponent, Comparable<iType> {
    @Override
    // iType to String conversion method
    String toString(); // Java type

    // iType to Scrabble's String conversion method
    SString toSString(); // Scrabble type

    // Key for flyweight comparison between iType classes, generating a String like key
    // that enables to calculate a hashcode.
    String getKey();

    @Override
    int compareTo(iType other);
}
