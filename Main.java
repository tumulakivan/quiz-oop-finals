import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        int total;
        String user, file_name = "scoreboard.txt", file_header = "test";
        ThreadSleeper ts = new ThreadSleeper();
        
        ts.initMenu();
        
        System.out.print("Select difficulty: ");
        choice = sc.nextInt();
        sc.nextLine();
        System.out.print("What's your name? ");
        user = sc.nextLine();
        System.out.println();
        
        // FileHandler.resetBoard(file_name, file_header);
        // FileHandler.initScoreboard(file_name, file_header);

        /* 
        System.out.print("name: ");
        user = sc.nextLine();
        User player = new User(user);
        String toAppend = player.getName() + " - " + player.getScore();
        FileHandler.appendToFile(file_name, toAppend);
        */

        ModerateQuiz mod = new ModerateQuiz();
        mod.startQuiz();
    }
}

/*
    * Your program must be able to enter the player name, the player can then select easy, moderate or difficult mode. Create 20 questions for each mode relevant to java, the player only needs to answer 10 questions. The player has 3 lives, for each incorrect answer the player life will be deducted by 1, if life is 0, it means game over. If the player completed the calculate the total score. Apply the OOP concepts and validation (exceptions). Display the top scorers and save and retrieved it through a text file.
    */