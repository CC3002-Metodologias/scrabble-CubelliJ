package cc3301.Scrabble.component.instruction;

import cc3301.Scrabble.component.comparator.Equal;
import cc3301.Scrabble.component.comparator.LessThan;
import cc3301.Scrabble.component.iComparator;
import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.component.variable.Var;
import cc3301.Scrabble.component.variable.VarFactory;
import cc3301.Scrabble.dtypes.bool.SBool;

// Scrabble's while loop for AST tree operations.
// While the condition is true, it runs the whileTrue sub tree repetitively.
// When the condition is false, it passes the whileTrue sub tree to the node.
public class While {

    // Constructor method
    private iComparator cond;
    private iComponent whileTrue;
    public While(iComparator cond, iComponent whileTrue){
        this.cond = cond;
        this.whileTrue = whileTrue;
    }

    // operate method,
    // Runs continuously a function while the condition remains true.
    // The condition is an iComparator object, and the whileTrue condition is
    // always a variable that is performing a determined function.
    public void operate() {
        SBool conditional = (SBool) this.cond.operate();
        if (conditional.toBool()){
            VarFactory factory = ((Var) whileTrue).getFactory();
            factory.runVal(((Var) whileTrue).get_name());
            this.operate();
        }
    }


}
