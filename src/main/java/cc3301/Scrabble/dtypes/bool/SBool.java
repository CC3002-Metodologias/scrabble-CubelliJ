package cc3301.Scrabble.dtypes.bool;

import cc3301.Scrabble.dtypes.AbstractType;
import cc3301.Scrabble.dtypes.number.interger.SBinary;
import cc3301.Scrabble.dtypes.string.SString;
import cc3301.Scrabble.operations.iLogical;

public class SBool extends AbstractType implements iLogical {
    private boolean bool;

    public SBool(boolean bool){
        this.bool = bool;
    }

    public boolean toBool(){ // To the java boolean type.
        return this.bool;
    }

    public SBool toSBool(){ // For consistency, it's actually unnecesary, might erase later.
        return new SBool(this.toBool());
    }

    @Override
    public SString toSString() {
        String value = String.valueOf(this.bool); // Método de boolean (?)
        return new SString(value);
    }

    public SBool or(SBool bool){
        return (SBool) bool.orbyBool(this);
    }

    public SBool and(SBool bool){
        return (SBool) bool.andbyBool(this);
    }

    public SBinary or(SBinary binary){
        return binary.orbyBool(this);
    }

    public SBinary and(SBinary binary){
        return binary.andbyBool(this);
    }

    @Override
    public iLogical orbyBool(SBool bool) {
        return new SBool(this.toBool()||bool.toBool());
    }

    @Override
    public iLogical andbyBool(SBool bool) {
        return new SBool(this.toBool()&&bool.toBool());
    }

    @Override
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

    @Override
    public SBinary andbyBinary(SBinary binary) {
        if (this.toBool()==false){
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
