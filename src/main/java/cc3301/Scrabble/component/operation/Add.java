package cc3301.Scrabble.component.operation;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.dtypes.iType;
import cc3301.Scrabble.operations.iSummable;

// Scrabble's Node Addition.
// Node that allows the iComponent addition.
public class Add extends AbstractNode {
    public Add(iComponent left, iComponent right) {
        super(left, right);
    }

    @Override
    // operate method on Add:
    // Transforms both node branches assuming it can be casted into an iSummable object.
    // Then it performs the addition between them.
    // To note, that it only allows the Scrabble's iType operations. (ie. SBinary + SFloat will return null)
    // Returns in a new iComponent the result.
    public iComponent operate() {
        iSummable left_op = (iSummable) getLeft().operate();
        iSummable right_op = (iSummable) getRight().operate();
        return (iComponent) left_op.add(right_op);
    }
}
