package cc3301.Scrabble.component.variable;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.dtypes.iType;

// Var:
// Scrabble's Node/Leaf encapsulate that allows to save the STypes in a variable
// It consists on a variable name and it's contents.
public class Var implements iComponent, Comparable<iType>{
    private final String var_name;
    private iComponent function; // Stored function for while implementation
    private iType value;
    private VarFactory factory; // Reference factory.

    // Constructor: Takes the variable name as an String and the stored value as an iType.
    public Var(String var_name, iType value){
        this.var_name = var_name;
        this.value = value;
    }

    // get_name:
    // Var getter for the variable name.
    public String get_name() {
        return this.var_name;
    }

    // get_value:
    // Var getter for the variable's value.
    public iType get_value() {
        return this.value;
    }

    // Value Setter.
    public void setValue(iType value) {
        this.value = value;
    }

    // operate method:
    // Given that Var acts as a pseudo leaf, it returns its contents when called.
    @Override
    public iComponent operate() {
        return value.operate();
    }

    // compareTo method,
    // Inherited from the Comparable interface, it enables the comparison between the
    // iType object stored in the variable and another iType object. Depending on the relation
    // between the variables, it returns -1 (less than), 0 (equal) or 1 (greater than).
    @Override
    public int compareTo(iType component) {
        return this.get_value().compareTo(component);
    }

    // Stored function getter
    public iComponent getFunction() {
        return function;
    }

    // Stored function setter
    public void setFunction(iComponent function) {
        this.function = function;
    }

    // Stored factory reference getter
    public VarFactory getFactory() {
        return factory;
    }

    // Stored factory reference setter
    public void setFactory(VarFactory factory) {
        this.factory = factory;
    }
}
