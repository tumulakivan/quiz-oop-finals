package Finals;

import java.io.*;

public class FileHandler {
    public static void initScoreboard(String path, String text) {
        File check_file = new File(path);

        if(!check_file.exists()) {
            try (BufferedWriter header = new BufferedWriter(new FileWriter(path))) {
                header.write(text);
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File already exists: " + path);
        }
    }

    public static void appendToFile(String path, String text) {
        try(FileWriter user_details = new FileWriter(path, true)) {
            user_details.write(System.lineSeparator() + text);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}