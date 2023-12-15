package exceptions;

import java.time.DateTimeException;

public class IncorrectBirthDay extends DateTimeException {
    public IncorrectBirthDay(String message) {
        super(message);
    }
}
