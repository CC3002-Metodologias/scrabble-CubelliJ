package cc3301.Scrabble.operations;

import cc3301.Scrabble.dtypes.iType;
import cc3301.Scrabble.dtypes.string.SString;

public interface iSummable extends iType {
    // Double dispatch add
    SString addedString(SString string);
}
