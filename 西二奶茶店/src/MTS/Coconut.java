package MTS;

import java.util.Calendar;

public class Coconut extends Ingredient {
    @Override
    public String toString() {
        return "Coconut{" +
                "ingreName='" + ingreName + '\'' +
                ", produceTime=" + produceTime +
                ", life=" + life +
                '}';
    }
    public Coconut(String ingreName, Calendar produceTime,int life){//构造方法初始化
        this.ingreName = ingreName;
        this.produceTime = produceTime;
        this.life=life;
    }
}
