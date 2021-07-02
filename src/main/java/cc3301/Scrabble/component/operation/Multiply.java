package cc3301.Scrabble.component.operation;

import cc3301.Scrabble.component.AbstractNode;
import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.operations.iNumberOps;

public class Multiply extends AbstractNode {
    public Multiply(iComponent left, iComponent right) {
        super(left, right);
    }

    @Override
    public iComponent operate() {
        iNumberOps left_op = (iNumberOps) getLeft().operate();
        iNumberOps right_op = (iNumberOps) getRight().operate();
        return (iComponent) left_op.multiply(right_op);
    }
}
