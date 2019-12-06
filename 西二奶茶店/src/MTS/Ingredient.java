package MTS;

import java.util.Calendar;

public abstract class Ingredient {
    protected String ingreName;
    protected Calendar produceTime;
    protected int life;

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingreName='" + ingreName + '\'' +
                ", produceTime=" + produceTime +
                ", life=" + life +
                '}';
    }
}
