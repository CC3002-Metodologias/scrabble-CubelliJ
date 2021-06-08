package cc3301.Scrabble.dtypes.number.interger;

import cc3301.Scrabble.dtypes.bool.SBool;
import cc3301.Scrabble.dtypes.number.flt.SFloat;
import cc3301.Scrabble.dtypes.string.SString;
import cc3301.Scrabble.operations.iLogical;

public class SBinary extends AbstractInteger implements iLogical{
    private String binary;
    public SBinary(String binary){
        this.binary = binary;
    }

    @Override
    public SBinary toSBinary() {
        return this;
    }

    @Override
    public String toBinary(){
        return this.binary;
    }

    @Override
    public SString toSString() {
        return new SString(this.binary);
    }

    @Override
    public SFloat toSFloat() {
        return this.toSInt().toSFloat();
    }

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

    private int negativeBinaryToInt(String binary) {
        int n = binary.length() - 1;
        int w = -bitToInt(binary.charAt(0)) * (int) Math.pow(2, n); for (int i = n, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * (binary.charAt(i) == '1' ? 1 : 0); }
        return w;
    }

    private int positiveBinToInt(String binary) {
        int w = 0;
        for (int i = binary.length() - 1, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * bitToInt(binary.charAt(i));
        }
        return w;
    }

    private int bitToInt(char bit) { return bit == '0' ? 0 : 1;
    }

    @Override
    public SInt toSInt() {
        return new SInt(this.toInt());
    }

    public SBinary or(SBool bool){
        return (SBinary) bool.orbyBinary(this);
    }

    public SBinary and(SBool bool){
        return (SBinary) bool.andbyBinary(this);
    }

    public SBinary or(SBinary binary){
        return binary.orbyBinary(this);
    }

    public SBinary and(SBinary binary){
        return binary.andbyBinary(this);
    }

    @Override
    public SBinary orbyBool(SBool bool) {
        return this.or(bool);
    }

    @Override
    public SBinary andbyBool(SBool bool) {
        return this.and(bool);
    }

    @Override
    public SBinary orbyBinary(SBinary binary) {
        return null;
    }

    @Override
    public SBinary andbyBinary(SBinary binary) {
        return null;
    }

}
