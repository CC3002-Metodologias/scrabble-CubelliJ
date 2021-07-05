package cc3301.Scrabble.dtypes.number.flt;

import cc3301.Scrabble.dtypes.number.AbstractNumber;
import cc3301.Scrabble.dtypes.number.interger.SBinary;
import cc3301.Scrabble.dtypes.number.interger.SInt;
import cc3301.Scrabble.dtypes.string.SString;
import cc3301.Scrabble.operations.iNumberOps;
import cc3301.Scrabble.operations.iSummable;

/**
 * SFloat -> Scrabble's float.
 * Floating number type object that stores a java double
 * it inherits the methods from AbstractNumber and implements the Number Operations (iNumberOps).
 *
 * It can be converted to:
 * - Java's String
 * - Scrabble's String
 * - Java's Float (double)
 * - Scrabble's Float
 *
 * It can do the following operations:
 * - add (SFloat, SInt, SBinary)
 * - subtract (SFloat, SInt, SBinary)
 * - multiply (SFloat, SInt, SBinary)
 * - divide (SFloat, SInt, SBinary)
 *
 * Using double dispatch it can do the following (inherited) operations
 * - operationByInt (sum, sub, mult, div)
 * - operationByFloat (sum, sub, mult, div)
 */

public class SFloat extends AbstractNumber{
    private double flt;
    // Constructor
    public SFloat(double flt){
        this.flt = flt;
    }

    // Transforms the stored float value, converts it to a String and stores it in a SString
    @Override
    public SString toSString() {
        String value = String.valueOf(this.flt); // Método de boolean (?)
        return new SString(value);
    }

    // toSBinary method:
    // SFloat can not be converted to SBinary, so it returns null.
    @Override
    public SBinary toSBinary() {
        return null;
    }

    // Returns itself
    @Override
    public SFloat toSFloat() {
        return this;
    }

    // toSInt method:
    // SFloat can not be converted to SInt, so it returns null.
    @Override
    public SInt toSInt() {
        return null;
    }

    // Returns the stored value
    @Override
    public double toFloat() {
        return this.flt;
    }

    // Number operation add,
    // returns the sum between the stored value and another iNumber value
    public SFloat add(iSummable operand) {
        return operand.addFloat(this);
    }

    // Number operation subtract, returns the subtraction
    // between the stored value and another iNumber value
    @Override
    public SFloat subtract(iNumberOps operand) {
        return operand.subtractFloat(this);
    }

    // Number operation multiply, returns the multiplication
    // between the stored value and another iNumber value
    @Override
    public SFloat multiply(iNumberOps operand) {
        return operand.multiplyFloat(this);
    }

    // Number operation multiply, returns the multiplication
    // between the stored value and another iNumber value
    @Override
    public SFloat divide(iNumberOps operand) {
        return operand.divideFloat(this);
    }

    // SFloat can't be added by Binary, so it returns null. (double dispatch)
    @Override
    public SBinary addBinary(SBinary addend) {
        return null;
    }

    // SFloat can't subtract a SBinary, so it returns null. (double dispatch)
    @Override
    public SBinary subtractBinary(SBinary subtract) {
        return null;
    }

    // SFloat can't multiply a SBinary, so it returns null. (double dispatch)
    @Override
    public SBinary multiplyBinary(SBinary product) {
        return null;
    }

    // SFloat can't divide a SBinary, so it returns null. (double dispatch)
    @Override
    public SBinary divideBinary(SBinary dividend) {
        return null;
    }

    /** SInteger double dispatch operations,
     * the SFloat double dispatch methods are inherited and not overwritten
     */

    // added by integer. (double dispatch)
    @Override
    public iSummable addInt(SInt addend) {
        double addend_val = addend.toFloat();
        double int_val = this.toFloat();
        double new_int_val = addend_val + int_val; // val = bin + int
        return new SFloat(new_int_val); // SInt(Val)
    }

    // subtracted by integer. (double dispatch)
    @Override
    public iNumberOps subtractInt(SInt subtract) {
        double addend_val = subtract.toFloat();
        double int_val = this.toFloat();
        double new_int_val = addend_val - int_val; // val = bin + int
        return new SFloat(new_int_val); // SInt(Val)
    }

    // multiplied by integer. (double dispatch)
    @Override
    public iNumberOps multiplyInt(SInt product) {
        double addend_val = product.toFloat();
        double int_val = this.toFloat();
        double new_int_val = addend_val * int_val; // val = bin * int
        return new SFloat(new_int_val); // SInt(Val)
    }

    // divided by integer. (double dispatch)
    @Override
    public iNumberOps divideInt(SInt dividend) {
        double addend_val = dividend.toFloat();
        double int_val = this.toFloat();
        double new_int_val = addend_val / int_val; // val = bin / int
        return new SFloat(new_int_val); // SInt(Val)
    }

    // Key for flyweight comparison between iType classes, generating a String like key
    // that enables to calculate a hashcode.
    @Override
    public String getKey(){
        return "SFloat" + this.toString();
    }
}
