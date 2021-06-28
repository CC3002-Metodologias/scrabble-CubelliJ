package cc3301.Scrabble.dtypes.number.interger;

import cc3301.Scrabble.dtypes.bool.SBool;
import cc3301.Scrabble.dtypes.number.flt.SFloat;
import cc3301.Scrabble.dtypes.string.SString;
import cc3301.Scrabble.operations.iBinaryOps;
import cc3301.Scrabble.operations.iLogical;

/**
 * SBinary -> Scrabble's binary
 * Numerical type object storing a binary-type java string value.
 * it inherits methods from AbstractInteger (given that it is one),
 * and from iLogical (the logical operations).
 *
 * It can be converted to:
 * - Java's String
 * - Scrabble's String
 * - Java's Float
 * - Scrabble's Float
 * - Java's Integer
 * - Scrabble's Integer
 * - Java's String (toBinary)
 * - Itself
 *
 * It can do the following operations:
 * - add (SInt, SBinary)
 * - subtract (SInt, SBinary)
 * - multiply (SInt, SBinary)
 * - divide (SInt, SBinary)
 *
 * Using double dispatch it can do the following (inherited) operations
 * - operationByInt (sum, sub, mult, div)
 * - operationByFloat (sum, sub, mult, div)
 * - operationByBinary (sum, sub, mult, div)
 */

public class SBinary extends AbstractInteger implements iLogical{
    private final String binary;
    public SBinary(String binary){
        this.binary = binary;
    }

    // Returns itself
    @Override
    public SBinary toSBinary() {
        return this;
    }

    // Returns the stored value as a String
    @Override
    public String toBinary(){
        return this.binary;
    }

    // Transforms the stored value, and stores it in a SString
    @Override
    public SString toSString() {
        return new SString(this.binary);
    }

    // Transforms the stored binary number to the Scrabble's floating point number
    @Override
    public SFloat toSFloat() {
        return this.toSInt().toSFloat();
    }

    // Transforms the stored binary number to Scrabble's integer
    @Override
    public SInt toSInt() {
        return new SInt(this.toInt());
    }

    // Transforms the stored binary number to an Integer
    @Override
    public int toInt() {
        String binary;
        binary = this.binary;
        if (bitToInt(binary.charAt(0)) == 0) {
            return positiveBinToInt(binary);
        } else {
            return negativeBinaryToInt(binary);
        }
    }

    // SBinary add,
    // returns the sum between the stored value and another Integer type value
    public SBinary add(iBinaryOps operand) {
        return operand.addBinary(this);
    }

    // SBinary subtract,
    // returns the subtraction between the stored value and another Integer type value
    public SBinary subtract(iBinaryOps operand) {
        return operand.subtractBinary(this);
    }

    // SBinary multiply,
    // returns the product between the stored value and another Integer type value
    public SBinary multiply(iBinaryOps operand) {
        return operand.multiplyBinary(this);
    }

    // SBinary division,
    // returns the integer division result between the stored value and another Integer type value
    public SBinary divide(iBinaryOps operand) {
        return operand.divideBinary(this);
    }

    // Auxiliary method that permitts the conversion of negative Binary numbers to the integer representation
    private int negativeBinaryToInt(String binary) {
        int n = binary.length() - 1;
        int w = -bitToInt(binary.charAt(0)) * (int) Math.pow(2, n); for (int i = n, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * (binary.charAt(i) == '1' ? 1 : 0); }
        return w;
    }

    // Auxiliary method that permitts the conversion of positive Binary numbers to the integer representation
    private int positiveBinToInt(String binary) {
        int w = 0;
        for (int i = binary.length() - 1, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * bitToInt(binary.charAt(i));
        }
        return w;
    }

    // Auxiliary method that flip bits
    private int bitToInt(char bit) { return bit == '0' ? 0 : 1;
    }

    // Logical or
    public SBinary or(SBool bool){
        return bool.orbyBinary(this);
    }

    // Logical and
    public SBinary and(SBool bool){
        return bool.andbyBinary(this);
    }

    // Double dispatch, SBool or SBinary case.
    @Override
    public SBinary orbyBool(SBool bool) {
        if (bool.toBool()){
            int n;
            String str = "1";
            String end = "";
            for (n = this.toBinary().length(); n!=0; n--){
                end += str;
            }
            return new SBinary(end);
        }
        return new SBinary(this.toBinary());
    }

    // Double dispatch, SBool and SBinary case.
    @Override
    public SBinary andbyBool(SBool bool) {
        if (!bool.toBool()){
            int n;
            String str = "0";
            String end = "";
            for (n = this.toBinary().length(); n!=0; n--){
                end += str;
            }
            return new SBinary(end);
        }
        return new SBinary(this.toBinary());
    }

}
