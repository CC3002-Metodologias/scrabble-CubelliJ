package cc3301.Scrabble.component;

public class AbstractNode implements iComponent{
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

    @Override
    public iComponent operate() {
        iComponent left_op = this.left.operate();
        iComponent right_op = this.right.operate();
        return null;
    }
}
