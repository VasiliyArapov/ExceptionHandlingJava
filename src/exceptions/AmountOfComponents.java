package exceptions;

public class AmountOfComponents extends RuntimeException{
    public AmountOfComponents(int rightAmountOfComponents, int amountOfComponents){
        super("There must be " + rightAmountOfComponents + " components, but your input has " + amountOfComponents + " components.");
    }
}
