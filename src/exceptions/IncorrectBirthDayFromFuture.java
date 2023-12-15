package exceptions;

public class IncorrectBirthDayFromFuture extends RuntimeException{
    public IncorrectBirthDayFromFuture(){
        super("Are you fom future?");
    }
}
