package cc3301.Scrabble.component.operation;

import cc3301.Scrabble.component.AbstractNode;
import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.operations.iLogical;

public class And extends AbstractNode {
    public And(iComponent left, iComponent right) {
        super(left, right);
    }

    @Override
    public iComponent operate() {
        iLogical left_op = (iLogical) getLeft().operate();
        iLogical right_op = (iLogical) getRight().operate();
        return (iComponent) left_op.and(right_op);
    }
}
