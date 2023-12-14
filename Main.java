import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, total = 0;
        String user, file_name = "D:/Files/Code/Java/Finals/scoreboard.txt";
        ThreadSleeper ts = new ThreadSleeper();
        
        ts.initMenu();
        
        System.out.print("Select difficulty: ");
        choice = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter your name: ");
        user = sc.nextLine();
        System.out.println();

        switch(choice) {
            case 1: 
                EasyQuiz easy = new EasyQuiz();
                easy.startQuiz();
                total = easy.getPoints();
                break;
            case 2:
                ModerateQuiz mod = new ModerateQuiz();
                mod.startQuiz();
                total = mod.getPoints();
                break;
            case 3:
                HardQuiz hard= new HardQuiz();
                hard.startQuiz();
                total = hard.getPoints();
                break;
            case 4:
                total = 0;
                break;
            default:
                System.out.println("Invalid"); // implement error handling
                break;
        }

        User player = new User(user);
        player.setScore(total);
        String toAppend = player.getName() + " - " + Integer.toString(total);
        FileHandler.appendToFile(file_name, toAppend);
    }
}