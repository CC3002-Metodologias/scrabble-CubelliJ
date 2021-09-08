package cc3301.Scrabble.component.instruction;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.component.visitor.iVisitor;
import cc3301.Scrabble.dtypes.bool.SBool;
import cc3301.Scrabble.dtypes.iType;


// Class If, decides between two action paths depending on a condition.
// If true, it runs the ifTrue iComponent, else, it runs the ifFalse iComponent.
public class If implements iComponent {
    private iComponent cond, ifTrue, ifFalse;
    public If(iComponent cond, iComponent ifTrue, iComponent ifFalse){
        this.cond = cond;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }

    //

    // Operate runs the conditional path, and then given the results it runs either the true path or the false path.
    @Override
    public iComponent operate() {
        SBool conditional = (SBool) (this.cond.operate()); // We'll assume that a conditional will be used on the if statement.
        if (conditional.toBool()){
            return this.ifTrue.operate();
        }
        else{
            return this.ifFalse.operate();
        }
    }

}
