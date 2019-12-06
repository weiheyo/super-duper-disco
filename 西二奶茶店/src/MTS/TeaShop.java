package MTS;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TeaShop implements Shop{
    public List<Coconut> coconuts;
    public List<Bubble> bubbles;
    public TeaShop(){//构造初始化先进它几个过期货！
        this.coconuts = new ArrayList<>();
        this.bubbles = new ArrayList<>();
        Calendar day = Calendar.getInstance();
        day.set(2019,Calendar.OCTOBER,30);
        Coconut c = new Coconut("coconut",day,5);
        coconuts.add(c);
        Bubble b = new Bubble("bubble",day,7);
        bubbles.add(b);
    }


    private void addingredient(Coconut coconut){//添加配料的私有方法
        coconuts.add(coconut);
    }
    private void addingredient(Bubble bubble){
        bubbles.add(bubble);
    }


    @Override
    public void stock(Ingredient ingredient) {//进货
        if(ingredient instanceof Bubble){
            addingredient((Bubble)ingredient);//调用添加配料的方法
        }else if(ingredient instanceof Coconut){
            addingredient((Coconut)ingredient);
        }
    }

    @Override
    public void sell(String mName, String iName) throws SoldOutException {//卖
        if(iName=="Bubble"){//加bubble
            MilkTea m = new MilkTea(mName);
            if(bubbles.size()!=0){//判断是否有货，没货就进货
                m.ingredient = bubbles.get(0);
                long daymili=(Calendar.getInstance().getTimeInMillis()-m.ingredient.produceTime.getTimeInMillis())/(1000*60*60*24);
                if(daymili<m.ingredient.life){//判断是否过期
                    System.out.println("客官，您的加了"+m.ingredient.ingreName+"的"+m.milkName+"拿好喽！");
                    bubbles.remove(0);
                }else{
                    bubbles.remove(0);
                    System.out.println("配料过期哩！再试试哟！");
                }
            }else{
                Ingredient bubble = new Bubble("bubble",Calendar.getInstance(),7);
                stock(bubble);
                stock(bubble);
                throw new SoldOutException("配料没有哩！现在进了点货喔,再试试咩！");
            }
        }else if(iName=="Coconut"){//加coconut
            MilkTea m = new MilkTea(mName);
            if(coconuts.size()!=0){//判断是否有货，没货就进货
                m.ingredient = coconuts.get(0);
                long daymili=(Calendar.getInstance().getTimeInMillis()-m.ingredient.produceTime.getTimeInMillis())/(1000*60*60*24);
                if(daymili<m.ingredient.life){//判断是否过期
                    System.out.println("客官，您的加了"+m.ingredient.ingreName+"的"+m.milkName+"拿好喽！");
                    coconuts.remove(0);
                }else{
                    coconuts.remove(0);
                    System.out.println("配料过期哩！再试试哟！");
                }
            }else {
                Ingredient coconut = new Coconut("coconut",Calendar.getInstance(),7);
                stock(coconut);
                stock(coconut);//进两次货
                throw new SoldOutException("配料没有哩！现在进了点货喔，再试试咩！");
            }
        }
    }
}
