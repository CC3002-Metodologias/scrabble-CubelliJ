package cc3301.Scrabble.operations;

import cc3301.Scrabble.dtypes.number.flt.SFloat;
import cc3301.Scrabble.dtypes.number.interger.SInt;

public interface iNumberOps {
    // Float double dispatch
    SFloat addFloat(SFloat addend);
    SFloat subtractFloat(SFloat subtract);
    SFloat multiplyFloat(SFloat product);
    SFloat divideFloat(SFloat dividend);

    // Int double dispatch
    iNumberOps addInt(SInt addend);
    iNumberOps subtractInt(SInt subtract);
    iNumberOps multiplyInt(SInt product);
    iNumberOps divideInt(SInt dividend);
}
