package cc3301.Scrabble.component;

import cc3301.Scrabble.component.visitor.iVisitor;
import cc3301.Scrabble.dtypes.iType;

// iComponent set's the starting point for all the node-like components.
public interface iComponent {
    // operate allows the tree operations.
    public iComponent operate();
    //iComponent accept(iVisitor);
}
