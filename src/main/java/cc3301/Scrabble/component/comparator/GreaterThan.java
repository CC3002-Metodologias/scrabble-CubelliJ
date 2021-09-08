package cc3301.Scrabble.component.comparator;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.dtypes.bool.SBool;
import cc3301.Scrabble.dtypes.iType;

// GreaterThan class, node type class enables
// the comparison between two iType objects
public class GreaterThan extends AbstractComparator{
    public GreaterThan(iComponent left, iComponent right) {
        super(left, right);
    }

    // operate method
    // Using the compareTo method from the Comparable interface
    // and returns true if the first iType object is greaterThan the second one.
    @Override
    public iComponent operate() {
        iType a = (iType) getLeft().operate();
        iType b = (iType) getRight().operate();
        int result = a.compareTo(b);
        SBool bool = new SBool((result==1));
        return bool;
    }

}
