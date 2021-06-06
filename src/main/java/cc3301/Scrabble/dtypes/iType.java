package cc3301.Scrabble.dtypes;

import cc3301.Scrabble.dtypes.string.SString;

public interface iType {
    @Override
    String toString(); // Java type
    SString toSString(); // Scrabble type
}
