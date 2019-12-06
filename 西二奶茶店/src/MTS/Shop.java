package MTS;

public interface Shop {
    void stock(Ingredient ingredient);
    void sell(String mName,String iName)throws SoldOutException;
}
