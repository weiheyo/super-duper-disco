package MTS;

import java.util.Calendar;

public class Bubble extends Ingredient {
    @Override
    public String toString() {
        return "Bubble{" +
                "ingreName='" + ingreName + '\'' +
                ", produceTime=" + produceTime +
                ", life=" + life +
                '}';
    }
    public Bubble(String ingreName, Calendar produceTime,int life){//构造方法初始化
        this.ingreName = ingreName;
        this.produceTime = produceTime;
        this.life=life;
    }
}
