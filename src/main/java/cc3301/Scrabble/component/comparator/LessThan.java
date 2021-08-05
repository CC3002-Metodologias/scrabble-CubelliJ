package cc3301.Scrabble.component.comparator;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.dtypes.bool.SBool;
import cc3301.Scrabble.dtypes.iType;

public class LessThan extends AbstractComparator{
    public LessThan(iComponent left, iComponent right) {
        super(left, right);
    }

    @Override
    public iComponent operate() {
        iType a = (iType) getLeft().operate();
        iType b = (iType) getRight().operate();
        int result = a.compareTo(b);
        SBool bool = new SBool((result==-1));
        return bool;
    }
}
