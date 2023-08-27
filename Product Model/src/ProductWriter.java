import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {
    public static void main(String[] args) {
        ArrayList<String> records = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        do {


            String id = SafeInput.getNonZeroLenString(sc, "Please enter an ID");
            String name = SafeInput.getNonZeroLenString(sc, "Please enter a name");
            String description = SafeInput.getNonZeroLenString(sc, "Please enter a description");
            double cost = SafeInput.getDouble(sc, "Please enter the cost");



            String line = id + ", " + name + ", " + description + ", " + cost;
            records.add(line);


        } while (SafeInput.getYNConfirm(sc, "Do you want to add another product?"));

        try {
            FileWriter writer = new FileWriter("ProductTestData.txt");
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
