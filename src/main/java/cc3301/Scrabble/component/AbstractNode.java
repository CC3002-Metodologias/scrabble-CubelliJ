package cc3301.Scrabble.component;

import cc3301.Scrabble.dtypes.bool.SBool;
import cc3301.Scrabble.dtypes.iType;
import cc3301.Scrabble.dtypes.string.SString;
import cc3301.Scrabble.operations.iNumberOps;
import cc3301.Scrabble.operations.iSummable;

public abstract class AbstractNode implements iComponent{
    private iComponent left;
    private iComponent right;

    public AbstractNode(iComponent left, iComponent right){
        this.left = left;
        this.right = right;
    }

    public iComponent getLeft() {
        return left;
    }

    public iComponent getRight() {
        return right;
    }

    public iComponent toSBinary(){
        return (iComponent) ((iNumberOps) this.operate()).toSBinary();
    }

    public iComponent toSInt(){
        return (iComponent) ((iNumberOps) this.operate()).toSInt();
    }

    public iComponent toSFloat(){
        return (iComponent) ((iNumberOps) this.operate()).toSFloat();
    }

    public iComponent toSString(){
        return (iComponent) ((iSummable) this.operate()).toSString();
    }

    public iComponent toSBool(){
        return (iComponent) ((SBool) this.operate()).toSBool();
    }
}
