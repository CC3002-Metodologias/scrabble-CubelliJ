package cc3301.Scrabble.dtypes.number.interger;

import cc3301.Scrabble.dtypes.number.flt.SFloat;
import cc3301.Scrabble.dtypes.string.SString;

public class SInt extends AbstractInteger{
    private int integer;
    public SInt(int integer){
        this.integer = integer;
    }

    @Override
    public SString toSString() {
        String value = String.valueOf(this.integer);
        return new SString(value);
    }

    @Override
    public SFloat toSFloat() {
        return new SFloat(this.integer);
    }

    @Override
    public SInt toSInt() {
        return this;
    }

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

    @Override
    public int toInt() {
        return this.integer;
    }

    @Override
    public SBinary toSBinary() {
        return new SBinary(this.toBinary());
    }
}
