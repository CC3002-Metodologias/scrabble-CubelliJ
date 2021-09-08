package cc3301.Scrabble.component.operation;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.dtypes.bool.SBool;
import cc3301.Scrabble.dtypes.iType;
import cc3301.Scrabble.dtypes.string.SString;
import cc3301.Scrabble.operations.iNumberOps;
import cc3301.Scrabble.operations.iSummable;

// Scrabble's Abstract Node,
// sets the ground type transformations for the distinct operations that inherits it.
public abstract class AbstractNode implements iComponent {
    private iComponent left;
    private iComponent right;

    // Constructor
    public AbstractNode(iComponent left, iComponent right){
        this.left = left;
        this.right = right;
    }

    // Left branch getter
    public iComponent getLeft() {
        return left;
    }

    // Right branch getter
    public iComponent getRight() {
        return right;
    }

    // toSBinary method
    // transforms the result of the branch to a SBinary object, returning it casted as an iComponent.
    public iComponent toSBinary(){
        return (iComponent) ((iNumberOps) this.operate()).toSBinary();
    }

    // toSInt method
    // transforms the result of the branch to a SInt object, returning it casted as an iComponent.
    public iComponent toSInt(){
        return (iComponent) ((iNumberOps) this.operate()).toSInt();
    }

    // toSFloat method
    // transforms the result of the branch to a SFloat object, returning it casted as an iComponent.
    public iComponent toSFloat(){
        return (iComponent) ((iNumberOps) this.operate()).toSFloat();
    }

    // toSString method
    // transforms the result of the branch to a SString object, returning it casted as an iComponent.
    public iComponent toSString(){
        return (iComponent) ((iSummable) this.operate()).toSString();
    }

    // toSBool method
    // transforms the result of the branch to a toSBool object, returning it casted as an iComponent.
    public iComponent toSBool(){
        return (iComponent) ((SBool) this.operate()).toSBool();
    }
}
