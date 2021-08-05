package cc3301.Scrabble.component.comparator;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.dtypes.bool.SBool;
import cc3301.Scrabble.dtypes.iType;

public class Equal extends AbstractComparator{
    public Equal(iComponent left, iComponent right) {
        super(left, right);
    }

    @Override
    public iComponent operate() {
        iType a = (iType) getLeft().operate();
        iType b = (iType) getRight().operate();
        int result = a.compareTo(b);
        SBool bool = new SBool((result==0));
        return bool;
    }
}
