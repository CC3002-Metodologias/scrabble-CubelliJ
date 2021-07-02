package cc3301.Scrabble.operations;

import cc3301.Scrabble.dtypes.number.flt.SFloat;
import cc3301.Scrabble.dtypes.number.interger.SBinary;
import cc3301.Scrabble.dtypes.number.interger.SInt;

public interface iNumberOps {

    SBinary toSBinary();
    SFloat toSFloat();
    SInt toSInt();

    iNumberOps subtract(iNumberOps subtracting);
    iNumberOps multiply(iNumberOps multiplier);
    iNumberOps divide(iNumberOps divider);

    SBinary subtractBinary(SBinary subtract);
    SBinary multiplyBinary(SBinary product);
    SBinary divideBinary(SBinary dividend);

    SFloat subtractFloat(SFloat subtract);
    SFloat multiplyFloat(SFloat product);
    SFloat divideFloat(SFloat dividend);

    iNumberOps subtractInt(SInt subtract);
    iNumberOps multiplyInt(SInt product);
    iNumberOps divideInt(SInt dividend);

}
