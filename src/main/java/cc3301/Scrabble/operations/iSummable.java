package cc3301.Scrabble.operations;

import cc3301.Scrabble.dtypes.string.SString;

public interface iSummable {
    // Double dispatch add
    SString addedString(SString string);
}
