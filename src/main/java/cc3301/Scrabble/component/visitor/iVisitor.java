package cc3301.Scrabble.component.visitor;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.dtypes.iType;

// iVisitor, the interface that allows the instructions
// If and While to "visit" the other iComponent nodes c:
public interface iVisitor {
    iType visitVariable(iComponent visit);
    iType visitOperation(iComponent visit);
    iType visitType(iComponent visit);

}
