package exceptions;

public class IncorrectGender extends RuntimeException{
    public IncorrectGender(String notAGender){
        super(notAGender + " - is not a gender. (Use 'f' for female and 'm' fo male)");
    }
}
