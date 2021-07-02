package cc3301.Scrabble.dtypes;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.dtypes.string.SString;

/**
 * iType defines the operations inherited by every single type,
 * in this case, the String transformation.
 */
public interface iType extends iComponent {
    @Override
    String toString(); // Java type
    SString toSString(); // Scrabble type
}
