package MTS;

public class MilkTea {
    public String milkName;
    public Ingredient ingredient;
    public MilkTea(){}
    public MilkTea(String milkName){
        this.milkName=milkName;
    }

    @Override
    public String toString() {
        return "MilkTea{" +
                "milkName='" + milkName + '\'' +
                '}';
    }
}
