package cc3301.Scrabble.component.comparator;

import cc3301.Scrabble.component.iComparator;
import cc3301.Scrabble.component.iComponent;

// Scrabble's Abstract Comparator,
// sets the standard constructor and the methods needed for the comparison type classes.
public abstract class AbstractComparator implements iComparator {
    private iComponent left;
    private iComponent right;

    // Constructor
    public AbstractComparator(iComponent left, iComponent right){
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

}
