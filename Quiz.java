import java.util.Scanner;
import java.util.Random;

abstract class Quiz {
    protected int points;
    protected int hp;
    protected int MAX = 10;
    protected int num_of_questions = 0;
    protected String[] questions;
    protected String[] answer;
    protected int[] passed;

    public Quiz() {
        this.points = 0;
        this.hp = 3;
        this.questions = new String[20];
        this.answer = new String[20];
        this.passed = new int[MAX];
    }

    public int getPoints() {
        return this.points;
    }

    public void damage() {
        this.hp -= 1;
    }

    abstract void startQuiz();
    abstract void addPoints();   
}

class EasyQuiz extends Quiz{
    @Override
    public void startQuiz() {
        questions[0] = "Who is the Father of Java?";
        // answer[0] = "A. James Gosling     B. Ryan Gosling     C. Gusion     D. Gallahad";
    }

    @Override
    public void addPoints() {
        this.points += 5;
    }
}

class ModerateQuiz extends Quiz {
    public boolean checkRepeat(int index) {
        for(int i = 0; i < MAX; i++) {
            if(index == passed[i]) return true;
        }

        return false;
    }

    @Override
    public void startQuiz() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int index, mark = 0;

        questions[0] = "Java supports multiple inheritance through classes [true/false]";
        answer[0] = "true";
        questions[1] = "What is the primary role of a setter method in Java";
        answer[1] = "set";
        questions[2] = "Which keyword is used to refer to the current instance of an object in Java?";
        answer[2] = "this";
        questions[3] = "What is the purpose of the 'new' keyword in Java?";
        answer[3] = "instantiate";
        questions[4] = "Which type of error is detected during runtime in Java?";
        answer[4] = "runtime";
        questions[5] = "Which access modifier allows a variable or method to be accessible only within its own class?";
        answer[5] = "private";
        questions[6] = "Local variables are accessible only within the method or block where they are declared";
        answer[6] = "true";
        questions[7] = "What is the keyword used to define a method that does not return any value in Java?";
        answer[7] = "void";
        questions[8] = "In Java, what term is used for variables declared outside any method or block and are accessible throughout the class?";
        answer[8] = "global";
        questions[9] = "What type of method in Java can call itself during its execution?";
        answer[9] = "recursive";
        questions[10] = "Access modifiers control the visibility of variables and methods in Java";
        answer[10] = "true";
        questions[11] = "What do yo ucall the values passed to a method when it is called?";
        answer[11] = "parameters";
        questions[12] = "Which keyword is used to explicitly return a value from a method in Java?";
        answer[12] = "return";
        questions[13] = "The break statement can be used to exit a loop based on a specific condition";
        answer[13] = "true";
        questions[14] = "When using a labeled break statement in nested loops, what does the label represent?";
        answer[14] = "the loop to terminate";
        questions[15] = "The continue statement can be used to skip the rest of the code inside a loop and move to the next iteration";
        answer[15] = "true";
        questions[16] = "What does the break statement do when used inside a switch statement in Java?";
        answer[16] = "exit the switch case";
        questions[17] = "Actual parameters are also known as";
        answer[17] = "arguments";
        questions[18] = "Formal parameters are placeholders defined in the method";
        answer[18] = "true";
        questions[19] = "A constructor in Java is a special method that is used to initialize objects";
        answer[19] = "true";
        
        int i = 0;
        while(mark < MAX) {
            // check later for segmentation fault
            index = rand.nextInt(20) + 1;
            while(this.checkRepeat(index)) index = rand.nextInt(20) + 1;
            System.out.println(questions[index]);
            sc.nextLine();
            String reply = sc.nextLine();
            if(reply != answer[index]) this.damage();
            passed[i] = index;
        }
    }

    @Override
    public void addPoints() {
        this.points += 10;
    }
}