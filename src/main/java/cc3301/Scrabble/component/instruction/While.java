package cc3301.Scrabble.component.instruction;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.component.visitor.iVisitor;
import cc3301.Scrabble.dtypes.bool.SBool;
import cc3301.Scrabble.dtypes.iType;

// Scrabble's while loop for AST tree operations.
// While the condition is true, it runs the whileTrue sub tree repetitively.
// When the condition is false, it passes the whileTrue sub tree to the node.
public class While implements iVisitor {

    // Constructor method
    private iComponent cond, whileTrue;
    public While(iComponent cond, iComponent whileTrue){
        this.cond = cond;
        this.whileTrue = whileTrue;
    }

    //@Override
    // operate method
    //
    public iComponent operate() {
        SBool conditional = (SBool) (this.cond.operate());
        if (conditional.toBool()){
            visit(this.whileTrue);
            return this.operate();
        }
        return (iType) this.whileTrue;
    }

    @Override
    public void visit(iComponent tree) {
        tree.operate();
    }

}
