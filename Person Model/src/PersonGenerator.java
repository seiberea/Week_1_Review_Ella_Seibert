import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        ArrayList<String> records = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        do {

            String id = SafeInput.getNonZeroLenString(sc, "Please enter an ID");
            String firstName = SafeInput.getNonZeroLenString(sc, "Please enter a first name");
            String lastName = SafeInput.getNonZeroLenString(sc, "Please enter a last name");
            String title = SafeInput.getNonZeroLenString(sc, "Please enter a title");
            int yob = SafeInput.getInt(sc, "Please enter the year of birth");



            String line = id + ", " + firstName + ", " + lastName + ", " + title + ", " + yob;
            records.add(line);


        } while (SafeInput.getYNConfirm(sc, "Do you want to add another person?"));

        try {
            FileWriter writer = new FileWriter("PersonTestData.txt");
            for (String line: records) {
                writer.write(line + "\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
