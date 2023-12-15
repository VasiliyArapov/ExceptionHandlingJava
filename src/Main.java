import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String input;
        input = "asdas asdsa 5345 23 asd";
        String[] splitedInput = input.split(" ");
        System.out.println(splitedInput[0]);

        Scanner scanner = new Scanner(System.in);
        String allInfo;
        System.out.println("Input your info in this format:\n FirstName SecondName FathersName dd.mm.yyyy 89091234123 f/m");
        allInfo = scanner.nextLine();
        String[] components = allInfo.split(" ");
        int amountOfComponents = components.length;
        String firstName = components[0];
        String secondName = components[1];
        String fathersName = components[2];
        String birthDayComponent = components[3];
        String phoneNumberComponent = components[4];
        String gender = components[5];

        System.out.println(birthDayComponent);

        String[] birthDayComponents = birthDayComponent.split("\\.");
        System.out.println(birthDayComponents[0]);
        System.out.println(birthDayComponents[1]);
        System.out.println(birthDayComponents[2]);

        int day = Integer.parseInt(birthDayComponents[0]);
        int month = Integer.parseInt(birthDayComponents[1]);
        int year = Integer.parseInt(birthDayComponents[2]);
        LocalDate birthDay = LocalDate.of(year, month, day);

        long phoneNumber = Long.parseLong(phoneNumberComponent);

        BufferedWriter writer = new BufferedWriter(new FileWriter(firstName, true));
        writer.append("\n");
        writer.append(allInfo);
        writer.close();

        Temporal t = LocalDate.now();
        System.out.println(t.get(ChronoField.YEAR));
        int tempYear = (int) t.get(ChronoField.YEAR);
        System.out.println(tempYear - year);
    }
}