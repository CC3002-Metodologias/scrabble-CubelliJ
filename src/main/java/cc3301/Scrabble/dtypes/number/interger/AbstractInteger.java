package cc3301.Scrabble.dtypes.number.interger;

import cc3301.Scrabble.dtypes.number.AbstractNumber;
import cc3301.Scrabble.operations.iBinaryOps;
import cc3301.Scrabble.operations.iNumberOps;

/**
 * AbstractInteger defines the methods for the Integer type Scrabble Classes
 */
public abstract class AbstractInteger extends AbstractNumber implements iBinaryOps {

    // Transformation from any Scrabble integer to SInt
    public abstract SInt toSInt();

    // Transformation from any Scrabble integer to java's integer
    public int toInt(){
        return this.toSInt().toInt();
    }

    // Transforms any Scrabble integer to SBinary
    public abstract SBinary toSBinary();

    // Transforms any Scrabble integer to a binary type String.
    public String toBinary(){
        return this.toSBinary().toBinary();
    }

    // Double dispatch, summed by SInteger
    @Override
    public iNumberOps addInt(SInt addend) {
        int addend_val = addend.toInt();
        int int_val = this.toInt();
        int new_int_val = addend_val + int_val; // val = bin + int
        return new SInt(new_int_val); // SInt(Val)
    }

    // Double dispatch, subtracted by SInteger
    @Override
    public iNumberOps subtractInt(SInt subtract) {
        int addend_val = subtract.toInt();
        int int_val = this.toInt();
        int new_int_val = addend_val - int_val; // val = bin + int
        return new SInt(new_int_val); // SInt(Val)
    }

    // Double dispatch, multiply by SInteger
    @Override
    public iNumberOps multiplyInt(SInt product) {
        int addend_val = product.toInt();
        int int_val = this.toInt();
        int new_int_val = addend_val * int_val; // val = bin * int
        return new SInt(new_int_val); // SInt(Val)
    }

    // Double dispatch, division by SInteger
    @Override
    public iNumberOps divideInt(SInt dividend) {
        int addend_val = dividend.toInt();
        int int_val = this.toInt();
        int new_int_val = addend_val / int_val; // val = bin / int
        return new SInt(new_int_val); // SInt(Val)
    }

    // Double dispatch, Integer summed by Binary
    public SBinary addBinary(SBinary addend) {
        int int_addend = addend.toInt();
        int added = this.toInt();
        SInt res = new SInt(int_addend+added);
        return res.toSBinary();
    }

    // Double dispatch, Binary - IntegerType
    public SBinary subtractBinary(SBinary subtract) {
        int int_subtract = subtract.toInt();
        int subtracted = this.toInt();
        SInt res = new SInt(int_subtract-subtracted);
        return res.toSBinary();
    }

    // Double dispatch, Binary * IntegerType
    public SBinary multiplyBinary(SBinary product) {
        int int_product = product.toInt();
        int multiplied = this.toInt();
        SInt res = new SInt(int_product*multiplied);
        return res.toSBinary();
    }

    // Double dispatch, Binary / IntegerType
    public SBinary divideBinary(SBinary dividend) {
        int int_dividend = dividend.toInt();
        int quocient = this.toInt();
        SInt res = new SInt(int_dividend/quocient);
        return res.toSBinary();
    }
}
