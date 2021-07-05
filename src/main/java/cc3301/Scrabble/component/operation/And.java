package cc3301.Scrabble.component.operation;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.dtypes.iType;
import cc3301.Scrabble.operations.iLogical;

// Scrabble's Node logical AND comparison.
// Node that allows the iComponent and comparison.
public class And extends AbstractNode {
    public And(iComponent left, iComponent right) {
        super(left, right);
    }

    @Override
    // operate method on And:
    // Transforms both node branches assuming it can be casted into an iLogical object.
    // Then it performs the logical and operation between them.
    // To note, that it only allows the Scrabble's iLogical operations. (ie. SBinary AND SBinary will return null)
    // Returns in a new iComponent the result.
    public iComponent operate() {
        iLogical left_op = (iLogical) getLeft().operate();
        iLogical right_op = (iLogical) getRight().operate();
        return (iComponent) left_op.and(right_op);
    }
}
