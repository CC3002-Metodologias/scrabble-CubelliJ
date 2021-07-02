package cc3301.Scrabble.component.operation;

import cc3301.Scrabble.component.AbstractNode;
import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.operations.iSummable;

public class Add extends AbstractNode {
    public Add(iComponent left, iComponent right) {
        super(left, right);
    }

    @Override
    public iComponent operate() {
        iSummable left_op = (iSummable) getLeft().operate();
        iSummable right_op = (iSummable) getRight().operate();
        return (iComponent) left_op.add(right_op);
    }
}
