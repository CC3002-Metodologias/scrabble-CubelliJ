package cc3301.Scrabble.component.operation;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.dtypes.iType;
import cc3301.Scrabble.operations.iNumberOps;

// Scrabble's Node Multiplication.
// Node that allows the iComponent multiplication.
public class Multiply extends AbstractNode {
    public Multiply(iComponent left, iComponent right) {
        super(left, right);
    }

    // operate method on Multiply:
    // Transforms both node branches assuming it can be casted into an iNumberOps object.
    // Then it performs the multiplication between them.
    // To note, that it only allows the Scrabble's iType operations. (ie. SBinary / SFloat will return null)
    // Returns the result in a new iComponent.
    @Override
    public iComponent operate() {
        iNumberOps left_op = (iNumberOps) getLeft().operate();
        iNumberOps right_op = (iNumberOps) getRight().operate();
        return (iComponent) left_op.multiply(right_op);
    }
}
