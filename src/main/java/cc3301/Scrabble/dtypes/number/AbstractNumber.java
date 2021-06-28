package cc3301.Scrabble.dtypes.number;

import cc3301.Scrabble.dtypes.AbstractType;
import cc3301.Scrabble.dtypes.number.flt.SFloat;
import cc3301.Scrabble.dtypes.number.interger.SInt;
import cc3301.Scrabble.dtypes.string.SString;
import cc3301.Scrabble.operations.iNumberOps;

/**
 * AbstractNumber defines the set and methods for all the number classes.
 */
public abstract class AbstractNumber extends AbstractType implements iNumberOps {

    // to String Transformation
    @Override
    public abstract SString toSString();

    // Number to Float transformations.
    public abstract SFloat toSFloat();
    public double toFloat(){
        return this.toSFloat().toFloat();
    }

    // Operation by Integer. (double dispatch)
    public abstract iNumberOps addInt(SInt addend);
    public abstract iNumberOps subtractInt(SInt subtractant);
    public abstract iNumberOps multiplyInt(SInt operand);
    public abstract iNumberOps divideInt(SInt dividend);

    // added by float. (double dispatch)
    @Override
    public SFloat addFloat(SFloat addend) {
        double float_addend = addend.toFloat();
        double added = this.toFloat();
        return new SFloat(float_addend+added);
    }

    // subtracted by float. (double dispatch)
    @Override
    public SFloat subtractFloat(SFloat subtract) {
        double float_subtract = subtract.toFloat();
        double subtracted = this.toFloat();
        return new SFloat(float_subtract-subtracted);
    }

    // multiplied by float. (double dispatch)
    @Override
    public SFloat multiplyFloat(SFloat product) {
        double float_product = product.toFloat();
        double operand = this.toFloat();
        return new SFloat(float_product*operand);
    }

    // divided by float. (double dispatch)
    @Override
    public SFloat divideFloat(SFloat dividend) {
        double float_dividend = dividend.toFloat();
        double divisor = this.toFloat();
        return new SFloat(float_dividend/divisor);
    }

}
