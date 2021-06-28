package cc3301.Scrabble.operations;

import cc3301.Scrabble.dtypes.number.interger.SBinary;

public interface iBinaryOps {
    SBinary addBinary(SBinary addend);
    SBinary subtractBinary(SBinary subtract);
    SBinary multiplyBinary(SBinary product);
    SBinary divideBinary(SBinary dividend);
}
