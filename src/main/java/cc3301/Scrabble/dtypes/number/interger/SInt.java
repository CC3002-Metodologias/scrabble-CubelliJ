package cc3301.Scrabble.dtypes.number.interger;

import cc3301.Scrabble.dtypes.number.flt.SFloat;
import cc3301.Scrabble.dtypes.string.SString;
import cc3301.Scrabble.operations.iNumberOps;
import cc3301.Scrabble.operations.iSummable;

/**
 * SInt -> Scrabble's Integer
 * Numerical type object storing a java integer value.
 * it inherits methods from AbstractInteger (given that it is one),
 *
 * It can be converted to:
 * - Java's String
 * - Scrabble's String
 * - Java's Float
 * - Scrabble's Float
 * - Java's Integer
 * - Itself
 * - Java's String (toBinary)
 * - Scrabble's Binary
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
 * - operationByBinary (sum, sub, mult, div)
 */

public class SInt extends AbstractInteger{
    private final int integer;
    public SInt(int integer){
        this.integer = integer;
    }

    // Transforms the stored value to a Java String, and stores it in a SString object
    @Override
    public SString toSString() {
        String value = String.valueOf(this.integer);
        return new SString(value);
    }

    // Transforms the stored value to a Java double, and stores it in a SFloat object
    @Override
    public SFloat toSFloat() {
        return new SFloat(this.integer);
    }

    // Returns the stored value
    @Override
    public int toInt() {
        return this.integer;
    }

    // Transforms the stored value to a Java integer, and stores it in a SInt object
    @Override
    public SInt toSInt() {
        return this;
    }

    // Transforms the value to a binary-type String
    @Override
    public String toBinary(){
        int integer2 = this.integer;
        int abs = Math.abs(integer2);
        String b = positiveIntToBinary(abs);
        if (integer2<0){
            b = twosComplement(b);
        }

        return b;
    }

    // SInt add,
    // returns the sum between the stored value and another number type value
    @Override
    public iSummable add(iSummable operand) {
        return operand.addInt(this);
    }

    // SInt subtract,
    // returns the subtraction between the stored value and another number type value
    @Override
    public iNumberOps subtract(iNumberOps subtracting) {
        return subtracting.subtractInt(this);
    }

    // SInt multiply,
    // returns the product between the stored value and another number type value
    @Override
    public iNumberOps multiply(iNumberOps operand) {
        return operand.multiplyInt(this);
    }

    // SInt divide,
    // returns the division between the stored value and another number type value
    @Override
    public iNumberOps divide(iNumberOps operand) {
        return operand.divideInt(this);
    }

    // Auxiliary method for positive integer to binary transformations
    private String positiveIntToBinary(int number){
        String bin = "";
        int num = number;
        int rem;
        while (num != 0){
            rem = num%2;
            num = num/2;
            bin = rem + bin;
        }
        return 0+bin;
    }

    // Auxiliary method for integer to binary transformations
    private String twosComplement(String unsigned_binary){
        int n = unsigned_binary.length();
        String neg_binary;

        // Changing ones with zeros.
        neg_binary = unsigned_binary;

        neg_binary = neg_binary.replace('0', 'x');
        neg_binary = neg_binary.replace('1', '0');
        neg_binary = neg_binary.replace('x', '1');

        neg_binary = '1' + neg_binary;

        int i;

        char[] bin = neg_binary.toCharArray();

        for (i = n; i>=0; i--){
            if (bin[i] == '1'){
                bin[i] = '0';
            }
            else{
                bin[i] = '1';
                break;
            }
        }

        String final_bin = "";
        for (i = 0; i != n+1; i++){
            final_bin += bin[i];
        }

        return final_bin;
    }

    // Transforms SInt to SBinary
    @Override
    public SBinary toSBinary() {
        return new SBinary(this.toBinary());
    }

    // Key for flyweight comparison between iType classes, generating a String like key
    // that enables to calculate a hashcode.
    @Override
    public String getKey(){
        return "SInt" + this.toString();
    }
}
