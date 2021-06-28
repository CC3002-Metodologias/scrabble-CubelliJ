package cc3301.Scrabble.operations;

import cc3301.Scrabble.dtypes.bool.SBool;
import cc3301.Scrabble.dtypes.iType;
import cc3301.Scrabble.dtypes.number.interger.SBinary;

public interface iLogical extends iType {
    iLogical orbyBool(SBool bool);
    iLogical andbyBool(SBool bool);

}
