package exceptions;

public class IncorrectBirthDayOld extends RuntimeException{
    public IncorrectBirthDayOld(){
        super("It is not possible to be so old!");
    }
}
