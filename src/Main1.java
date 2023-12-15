import exceptions.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;

public class Main1 {
    public static void main(String[] args) {
        Parser parser = new Parser();
        String allInfo = parser.addInfo();
        try {
            String[] checkComponents = parser.parsInfo(allInfo);
        } catch (AmountOfComponents e){
            System.out.println(e.getMessage());
        }
        String[] components = parser.parsInfo(allInfo);
        String firstName = components[0];
        String secondName = components[1];
        String fathersName = components[2];
        String birthDayComponent = components[3];
        String phoneNumberComponent = components[4];
        String gender = components[5];

        try {
            String[] checkBirthDayComponents = parser.parsBirthDay(birthDayComponent);
        } catch (AmountOfComponents e){
            System.out.println(e.getMessage());
        }

        String[] birthDayComponents = parser.parsBirthDay(birthDayComponent);

        int day = Integer.parseInt(birthDayComponents[0]);
        int month = Integer.parseInt(birthDayComponents[1]);
        int year = Integer.parseInt(birthDayComponents[2]);

        try {
            LocalDate checkBirthDay = LocalDate.of(year, month, day);
        }catch (DateTimeException e){
            System.out.println(e.getMessage());
        }

        try {
            parser.countAge(year);
        } catch (IncorrectBirthDayOld e){
            System.out.println(e.getMessage());
        }

//        LocalDate birthDay = LocalDate.of(year, month, day);

        try {
            long phoneNumber = parser.parsPhoneNumber(phoneNumberComponent);
            int phoneNumberLength = parser.lengthPhoneNumber(phoneNumberComponent);
        } catch (NumberFormatException | IncorrectPhoneNumber | IncorrectPhoneNumberLength e) {
            System.out.println(e.getMessage());
        }

        try {
            parser.checkGender(gender);
        } catch (IncorrectGender e){
            System.out.println(e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(secondName, true))){
            writer.append("\n");
            writer.append(allInfo);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
