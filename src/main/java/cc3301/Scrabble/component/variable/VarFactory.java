package cc3301.Scrabble.component.variable;

import cc3301.Scrabble.component.iComponent;
import cc3301.Scrabble.component.operation.Add;
import cc3301.Scrabble.dtypes.iType;

import java.util.Hashtable;

// VarFactory:
// Flyweight implementation of the commom variable.
// It acts as a factory allowing the creation of variables,
// and stores its values in a hashtable so they are not duplicated.
// It also stores the variable in a hashtable with it's name as the key.
// So the variable can be retrieved when it's asked by it's name.
public class VarFactory {
    private Hashtable<String, iType> iType_hashtable = new Hashtable<>();
    private Hashtable<String, Var> Var_hashtable = new Hashtable<>();

    // Create value method.
    // Given that most of the time an iComponent is to be operated inside a Variable,
    // it first is computated, giving birth to a new SType value.
    // When that happens;
    // It searches if a certain iType value is already on a table.
    // If true, it returns the iType stored in the table.
    // Else, it stores the unknown iType in the hashtable and returns it.
    public iType createValue(iComponent val) {
        iType value = null;
        if (val != null) {
            value = (iType) val.operate();
            iType hash_value = iType_hashtable.get(value.getKey());
            if (hash_value == null) {
                iType_hashtable.put(value.getKey(), value);
            } else {
                value = hash_value;
            }
        }
        return value;
    }

    // createVar method:
    // Creates a variable given its variable name and it's value.
    // If the variable has been created and the value is not none,
    // it returns the value stored in the hash table.
    // In case that there's a value in val, it replaces
    // the previous value stored in the variable.
    public Var createVar(String var_name, iComponent val){
        iType value = this.createValue(val);
        Var variable = Var_hashtable.get(var_name);
        if (variable == null) {
            variable = new Var(var_name, value);
            Var_hashtable.put(var_name, variable);
        }
        else{
            if (value != null){
                variable.setValue(value);
            }
        }
        return variable;
    }

    // get allows to retrieve a variable by it's name.
    // while a variable can be retrieved using createVal(val_name, null),
    // it's a shorter implementation.
    public Var get(String var_name){
        return Var_hashtable.get(var_name);
    }


}

