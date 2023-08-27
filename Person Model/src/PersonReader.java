import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonReader {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();
        final int FIELDS_LENGTH = 5;
        String rec = "";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = fileChooser.getSelectedFile();
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(selectedFile.toPath(), CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                int line = 0;
                while (reader.ready()) {
                    rec = reader.readLine();
                    lines.add(rec);
                    line++;
//                    System.out.printf("\nLine %4d %-60s ", line, rec);
                }
                reader.close();
                System.out.println("\n\nData file read!");

                System.out.printf("\n%-8s%-25s%-25s%-6s%6s", "ID#", "Firstname", "Lastname", "Title", "YOB");
                System.out.println("\n======================================================================");

                String[] fields;
                for(String l:lines)
                {
                    fields = l.split(","); // Split the record into the fields

                    if(fields.length == FIELDS_LENGTH)
                    {
                        String id        = fields[0].trim();
                        String firstName = fields[1].trim();
                        String lastName  = fields[2].trim();
                        String title     = fields[3].trim();
                        int yob       = Integer.parseInt(fields[4].trim());
                        System.out.printf("\n%-8s%-25s%-25s%-6s%6d", id, firstName, lastName, title, yob);
                    }
                    else
                    {
                        System.out.println("Found a record that may be corrupt: ");
                        System.out.println(l);
                    }
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
