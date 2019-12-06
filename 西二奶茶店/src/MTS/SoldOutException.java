package MTS;

public class SoldOutException extends Exception {
    public SoldOutException(){}
    Ingredient ingredientneeded;
    public SoldOutException(String message){
        super(message);
    }
}
