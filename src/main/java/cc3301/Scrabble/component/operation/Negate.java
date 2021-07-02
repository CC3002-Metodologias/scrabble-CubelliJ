package cc3301.Scrabble.component.operation;

import cc3301.Scrabble.component.AbstractNode;
import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.dtypes.string.SString;
import cc3301.Scrabble.operations.iLogical;

public class Negate extends AbstractNode {
    public Negate(iComponent left) {
        super(left, null);
    }

    @Override
    public iComponent operate() {
        iLogical left_op = (iLogical) getLeft().operate();
        return (iComponent) left_op.negate();
    }
}
