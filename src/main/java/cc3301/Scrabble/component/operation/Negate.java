package cc3301.Scrabble.component.operation;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.dtypes.iType;
import cc3301.Scrabble.operations.iLogical;

// Scrabble's Node Negation
// It allows the negation of Logical Type objects.
public class Negate extends AbstractNode {
    public Negate(iComponent left) {
        super(left, null);
    }

    // operate method on Negate:
    // Transforms the unique branch assuming it can be casted into an iLogical object.
    // Then it flips the bits of that object. ie: SBool(true) -> SBool(false).
    // Returns the result in a new iComponent.
    @Override
    public iComponent operate() {
        iLogical left_op = (iLogical) getLeft().operate();
        return (iComponent) left_op.negate();
    }
}
