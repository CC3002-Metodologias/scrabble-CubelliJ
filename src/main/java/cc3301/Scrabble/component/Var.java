package cc3301.Scrabble.component;

import cc3301.Scrabble.dtypes.iType;

public class Var implements iComponent{
    private final String var_name;
    private iType value;

    public Var(String var_name, iType value){
        this.var_name = var_name;
        this.value = value;
    }

    public String getVar_name() {
        return var_name;
    }

    public void setValue(iType value) {
        this.value = value;
    }

    @Override
    public iComponent operate() {
        return value;
    }
}
