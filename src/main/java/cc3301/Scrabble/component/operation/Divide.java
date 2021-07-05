package cc3301.Scrabble.component.operation;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.dtypes.iType;
import cc3301.Scrabble.operations.iNumberOps;

// Scrabble's Node Division.
// Node that allows the iComponent division.
public class Divide extends AbstractNode {
    public Divide(iComponent left, iComponent right) {
        super(left, right);
    }

    // operate method on Divide:
    // Transforms both node branches assuming it can be casted into an iNumberOps object.
    // Then it performs the division between them.
    // To note, that it only allows the Scrabble's iType operations. (ie. SInt - SFloat will return null)
    // Returns in a new iComponent the result.
    @Override
    public iComponent operate() {
        iNumberOps left_op = (iNumberOps) getLeft().operate();
        iNumberOps right_op = (iNumberOps) getRight().operate();
        return (iComponent) left_op.divide(right_op);
    }
}
