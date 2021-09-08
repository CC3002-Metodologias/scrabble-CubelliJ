package cc3301.Scrabble.component.visitor;

import cc3301.Scrabble.component.iComponent;

// iVisitor, the interface that allows the instructions
// If and While to "visit" the other iComponent nodes c:
public interface iVisitor {
    void visit(iComponent visit);

}
