package cc3301.Scrabble.component.instruction;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.dtypes.bool.SBool;

public class If implements iComponent {
    private iComponent cond, ifTrue, ifFalse;
    public If(iComponent cond, iComponent ifTrue, iComponent ifFalse){
        this.cond = cond;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }

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
