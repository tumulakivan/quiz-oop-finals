package Finals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, total, highscore;
        String user, file_name = "scoreboard.txt", file_header = "Quiz Leaderboard";
        ThreadSleeper ts = new ThreadSleeper();
        
        ts.initMenu();
        
        System.out.print("Select difficulty: ");
        choice = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter your name: ");
        user = sc.nextLine();
        System.out.println();
        
        // FileHandler.resetBoard(file_name, file_header);
        // FileHandler.initScoreboard(file_name, file_header);

        switch(choice) {
            case 1: 
                EasyQuiz easy = new EasyQuiz();
                easy.startQuiz();
                total = easy.getPoints();
                break;
            case 2:
                ModerateQuiz mod = new ModerateQuiz();
                mod.startQuiz();
                mod.getPoints();
                break;
            case 3:
                HardQuiz hard= new HardQuiz();
                hard.startQuiz();
                hard.getPoints();
                break;
            default:
                System.out.println("Invalid"); // implement error handling
                break;
        }

        highscore = FileHandler.getHighscore(file_name);
        User player = new User(user);
        total = player.getScore();
        player.setScore(total);
        if(player.getScore() > highscore) {
            highscore = player.getScore();
            FileHandler.updateHighscore(file_name, highscore, player);
        }
        String toAppend = player.getName() + " - " + total;
        FileHandler.appendToFile(file_name, toAppend);
    }
}