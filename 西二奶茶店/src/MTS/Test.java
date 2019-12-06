package MTS;

import java.util.Calendar;

public class Test {
    public static void main(String[] args) {
        TeaShop t = new TeaShop();
        try{//第一次是过期
            t.sell("奶茶1","Coconut");
        }catch(SoldOutException e){
            System.out.println(e);
        }
        try{//第二次是没货
            t.sell("奶茶2","Coconut");
        }catch(SoldOutException e){
            System.out.println(e);
        }
        try{//第三次有货啦！！
            t.sell("奶茶3","Coconut");
        }catch(SoldOutException e){
            System.out.println(e);
        }
        //同样用Bubble试三次
        try{
            t.sell("奶茶1","Bubble");
        }catch(SoldOutException e){
            System.out.println(e);
        }
        try{
            t.sell("奶茶2","Bubble");
        }catch(SoldOutException e){
            System.out.println(e);
        }
        try{
            t.sell("奶茶3","Bubble");
        }catch(SoldOutException e){
            System.out.println(e);
        }

    }
}
