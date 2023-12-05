    import java.io.IOException;
    import java.io.File;
    import java.io.FileWriter;
    import java.io.BufferedWriter;
    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            // int choice;
            String user, file_name = "scoreboard.txt", file_header = "test";
            
            // FileHandler.resetBoard(file_name, file_header);
            // FileHandler.initScoreboard(file_name, file_header);

            System.out.print("name: ");
            user = sc.nextLine();
            User player = new User(user);
            String toAppend = player.getName() + " - " + player.getScore();
            FileHandler.appendToFile(file_name, toAppend);
        }
    }