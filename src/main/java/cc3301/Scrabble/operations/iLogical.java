package cc3301.Scrabble.operations;

import cc3301.Scrabble.dtypes.bool.SBool;
import cc3301.Scrabble.dtypes.iType;
import cc3301.Scrabble.dtypes.number.interger.SBinary;

public interface iLogical extends iType {

    iLogical or(iLogical operand);
    iLogical and(iLogical operand);

    iLogical orbyBinary(SBinary bool);
    iLogical andbyBinary(SBinary bool);

    iLogical orbyBool(SBool bool);
    iLogical andbyBool(SBool bool);

    iLogical negate();
}
