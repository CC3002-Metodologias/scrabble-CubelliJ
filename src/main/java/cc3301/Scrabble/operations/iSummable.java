package cc3301.Scrabble.operations;

import cc3301.Scrabble.dtypes.iType;
import cc3301.Scrabble.dtypes.number.flt.SFloat;
import cc3301.Scrabble.dtypes.number.interger.SBinary;
import cc3301.Scrabble.dtypes.number.interger.SInt;
import cc3301.Scrabble.dtypes.string.SString;

public interface iSummable extends iType {
    // Double dispatch add
    iSummable add(iSummable summable);

    SString addedString(SString string);

    SBinary addBinary(SBinary addend);

    SFloat addFloat(SFloat addend);

    // Int double dispatch
    iSummable addInt(SInt addend);

}
