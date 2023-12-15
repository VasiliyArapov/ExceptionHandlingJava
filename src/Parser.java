import exceptions.*;
import model.PersonInfo;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.util.Scanner;

public class Parser {
    public String allInfo;
    public String[] components;
    public String firstName;
    public String secondName;
    public String fathersName;
    public String birthDayString;
    public String phoneNumberString;
    public String gender;
    public Scanner scanner;
    public PersonInfo personInfo;

    int amountOfComponents;
    int rightAmountOfComponents;

    public Parser() {
        scanner = new Scanner(System.in);
        rightAmountOfComponents = 6;
    }

    public String addInfo(){
        System.out.println("Input your info using this format:\nFirstName SecondName FathersName dd.mm.yyyy 89091234123 f/m");
        return allInfo = scanner.nextLine();
    }

    public String[] parsInfo(String info){
        components = info.split(" ");
        amountOfComponents = components.length;
        if (amountOfComponents != rightAmountOfComponents){
            throw new AmountOfComponents(rightAmountOfComponents, amountOfComponents);
        } else {
            return components;
        }
    }

    public String[] parsBirthDay(String info){
        components = info.split("\\.");
        rightAmountOfComponents = 3;
        amountOfComponents = components.length;
        if (amountOfComponents != rightAmountOfComponents){
            System.out.println("In date:");
            throw new AmountOfComponents(rightAmountOfComponents, amountOfComponents);
        } else {
            return components;
        }
    }

    public void countAge(int yearOfBorn){
        Temporal t = LocalDate.now();
        int tempYear = (int) t.get(ChronoField.YEAR);
        int age = tempYear - yearOfBorn;
        if (age > 150){
            throw new IncorrectBirthDayOld();
        }
    }

    public long parsPhoneNumber(String info){
        long phoneNumber = Long.parseLong(info);
        if (phoneNumber < 0){
            throw new IncorrectPhoneNumber();
        }
        return phoneNumber;
    }

    public int lengthPhoneNumber(String info){
        int length = info.length();
        if (length != 11){
            throw new IncorrectPhoneNumberLength(length);
        }
        return length;
    }

    public void checkGender(String gender){
        if (!gender.equals("f") && !gender.equals("m")){
            throw new IncorrectGender(gender);
        }
    }

    public void setComponents(String[] components) {
        this.components = components;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public void setBirthDayString(String birthDayString) {
        this.birthDayString = birthDayString;
    }

    public void setPhoneNumberString(String phoneNumberString) {
        this.phoneNumberString = phoneNumberString;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
