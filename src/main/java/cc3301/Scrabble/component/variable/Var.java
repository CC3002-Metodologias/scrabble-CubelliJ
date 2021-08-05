package cc3301.Scrabble.component.variable;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.dtypes.iType;

// Var:
// Scrabble's Node/Leaf encapsulate that allows to save the STypes in a variable
// It consists on a variable name and it's contents.
public class Var implements iComponent, Comparable<iType>{
    private final String var_name;
    private iComponent function;
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

    @Override
    public int compareTo(iType component) {
        return this.get_value().compareTo(component);
    }

    public iComponent getFunction() {
        return function;
    }

    public void setFunction(iComponent function) {
        this.function = function;
    }

    public VarFactory getFactory() {
        return factory;
    }

    public void setFactory(VarFactory factory) {
        this.factory = factory;
    }
}
