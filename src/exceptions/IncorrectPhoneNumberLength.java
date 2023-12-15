package exceptions;

public class IncorrectPhoneNumberLength extends RuntimeException{
    public IncorrectPhoneNumberLength(int amountOfDigits){
        super("Phone number must have 11 digits, but your number has " + amountOfDigits);
    }
}
