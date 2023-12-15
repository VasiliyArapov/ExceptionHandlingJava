package exceptions;

public class IncorrectPhoneNumber extends RuntimeException{
    public IncorrectPhoneNumber(){
        super("Incorrect phone number.");
    }
}
