import exceptions.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;

public class Main2 {
    public static void main(String[] args) {
        Parser parser = new Parser();
        String allInfo = parser.addInfo();
        try {
            String[] checkComponents = parser.parsInfo(allInfo);
            String[] components = parser.parsInfo(allInfo);
            String firstName = components[0];
            String secondName = components[1];
            String fathersName = components[2];
            String birthDayComponent = components[3];
            String phoneNumberComponent = components[4];
            String gender = components[5];
            String[] checkBirthDayComponents = parser.parsBirthDay(birthDayComponent);
            String[] birthDayComponents = parser.parsBirthDay(birthDayComponent);
            int day = Integer.parseInt(birthDayComponents[0]);
            int month = Integer.parseInt(birthDayComponents[1]);
            int year = Integer.parseInt(birthDayComponents[2]);
            LocalDate checkBirthDay = LocalDate.of(year, month, day);
            parser.countAge(year);
            long phoneNumber = parser.parsPhoneNumber(phoneNumberComponent);
            int phoneNumberLength = parser.lengthPhoneNumber(phoneNumberComponent);
            parser.checkGender(gender);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(secondName, true))){
                writer.append("\n");
                writer.append(allInfo);
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        } catch (AmountOfComponents | DateTimeException | IncorrectBirthDayOld | NumberFormatException |
                 IncorrectPhoneNumber | IncorrectPhoneNumberLength | IncorrectGender e){
            System.out.println(e.getMessage());
        }

    }
}
