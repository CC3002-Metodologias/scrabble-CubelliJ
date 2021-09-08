package cc3301.Scrabble.component.operation;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.dtypes.iType;
import cc3301.Scrabble.operations.iLogical;

// Scrabble's Node logical OR comparison.
// Node that allows the iComponent or comparison.
public class Or extends AbstractNode {
    public Or(iComponent left, iComponent right) {
        super(left, right);
    }

    @Override
    // operate method on OR:
    // Transforms both node branches assuming it can be casted into an iLogical object.
    // Then it performs the logical OR operation between them.
    // To note, that it only allows the Scrabble's iLogical operations. (ie. SBinary OR SBinary will return null)
    // Returns in a new iComponent the result.
    public iComponent operate() {
        iLogical left_op = (iLogical) getLeft().operate();
        iLogical right_op = (iLogical) getRight().operate();
        return (iComponent) left_op.or(right_op);
    }
}
