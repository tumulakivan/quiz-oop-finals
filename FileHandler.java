package Finals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

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

    public static void resetBoard(String path, String text) {
        try (BufferedWriter header = new BufferedWriter(new FileWriter(path))) {
            header.write(text);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static int getHighscore(String path) {
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            Pattern pattern = Pattern.compile("Highscore: (\\d+) - .*");

            while((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);

                if(matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public static void updateHighscore(String path, int score, User player) {
        try(BufferedReader reader = new BufferedReader(new FileReader(path));
            BufferedWriter writer = new BufferedWriter(new FileWriter("temp.txt"))) {
                
                String line;
                boolean highscoreUpdated = false;

                while((line = reader.readLine()) != null) {
                    if(line.startsWith("Highscore")) {
                        writer.write("Highscore: " + score + " - " + player.getName());
                        writer.newLine();
                        highscoreUpdated = true;
                    } else {
                        writer.write(line);
                        writer.newLine();
                    }
                }
        } catch(IOException e) {
            e.printStackTrace();
        }

        File originalFile = new File(path);
        File tempFile = new File("temp.txt");
        if(tempFile.renameTo(originalFile)) {
            System.out.println("Highscore updated");
        } else {
            System.err.println("Highscore not updated");
        }
    }
}