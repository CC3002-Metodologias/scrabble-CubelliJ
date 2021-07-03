package cc3301.Scrabble.component.instruction;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.dtypes.bool.SBool;

public class While implements iComponent {

    private iComponent cond, whileTrue;
    public While(iComponent cond, iComponent whileTrue){
        this.cond = cond;
        this.whileTrue = whileTrue;
    }

    @Override
    public iComponent operate() {
        SBool conditional = (SBool) (this.cond.operate());
        if (conditional.toBool()){
            this.whileTrue.operate();
            return this.operate();
        }
        return this.whileTrue;
    }
}
