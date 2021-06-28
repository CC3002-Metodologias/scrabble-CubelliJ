package cc3301.Scrabble.dtypes.bool;

import cc3301.Scrabble.dtypes.AbstractType;
import cc3301.Scrabble.dtypes.number.interger.SBinary;
import cc3301.Scrabble.dtypes.string.SString;
import cc3301.Scrabble.operations.iLogical;

/**
 * SBool -> Scrabble's boolean
 * Boolean type object storing a java boolean,
 * it inherits the methods from AbstractType and iLogical
 * and has the following operations,
 *
 * It can be converted to:
 *  - Java's boolean
 *  - Itself (Scrabble Boolean)
 *  - Java's String
 *  - Scrabble's String
 *
 *  It can do the following operations:
 *  - or (SBool, SBinary)
 *  - and (SBool, SBinary)
 *
 *  Using double dispatch it can be operated by:
 *  - addedbyString; inherited
 *      (In which it's converted to a String and
 *      added to the end of the String that summed it)
 *  - orbyBinary
 *  - andbyBinary
 *  - orbyBool
 *  - andbyBinary
 **/

public class SBool extends AbstractType implements iLogical {
    private final boolean bool;

    // SBool Constructor, it stores a boolean value.
    public SBool(boolean bool){
        this.bool = bool;
    }

    // toBool returns the java boolean stored.
    public boolean toBool(){
        return this.bool;
    }

    // toSBool returns a new SBool with the original value.
    public SBool toSBool(){ // For consistency, it's actually unnecesary, might erase later.
        return new SBool(this.toBool());
    }

    // toSSting returns a new SString object with the boolean value transformed into a String.
    @Override
    public SString toSString() {
        String value = String.valueOf(this.bool); // Método de boolean (?)
        return new SString(value);
    }

    // I overloaded the following methods:

    // Logical or, with other Sbool.
    public SBool or(SBool bool){
        return (SBool) bool.orbyBool(this);
    }

    // Logical and, with other Sbool.
    public SBool and(SBool bool){
        return (SBool) bool.andbyBool(this);
    }

    // Logical or, with SBinary.
    public SBinary or(SBinary binary){
        return binary.orbyBool(this);
    }

    // Logical and, with SBinary.
    public SBinary and(SBinary binary){
        return binary.andbyBool(this);
    }

    // Double dispatch logical or by SBool
    @Override
    public iLogical orbyBool(SBool bool) {
        return new SBool(this.toBool()||bool.toBool());
    }

    // Double dispatch logical and by SBool
    @Override
    public iLogical andbyBool(SBool bool) {
        return new SBool(this.toBool()&&bool.toBool());
    }

    // Double dispatch logical or by SBinary (exclusive to SBool, NOT applicable to SBinary)
    public SBinary orbyBinary(SBinary binary) {
        if (this.toBool()){
            int n;
            String str = "1";
            String end = "";
            for (n = binary.toBinary().length(); n!=0; n--){
                end += str;
            }
            return new SBinary(end);
        }
        return new SBinary(binary.toBinary());
    }

    // Double dispatch logical and by SBinary (exclusive to SBool, NOT applicable to SBinary)
    public SBinary andbyBinary(SBinary binary) {
        if (!this.toBool()){
            int n;
            String str = "0";
            String end = "";
            for (n = binary.toBinary().length(); n!=0; n--){
                end += str;
            }
            return new SBinary(end);
        }
        return new SBinary(binary.toBinary());
    }
}
