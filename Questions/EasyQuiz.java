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
        this.passed = new int[MAX];
    }

    public int getPoints() {
        return this.points;
    }

    public void damage() {
        this.hp--;
    }

    abstract void startQuiz();
    abstract void addPoints();   
}

class EasyQuiz extends Quiz{
    @Override
    public void startQuiz() {
        this.questions[0] = "Java was initially name Oak. [true/false]";
        this.answer[0] = "true";
        this.questions[1] = "Java is a purely procedural programming language. [true/false]";
        this.answer[1] = "false";
        this.questions[2] = "In Java, the int data type is used to represent floating-point numbers. [true/false]";
        this.answer[2] = "false";
        this.questions[3] = "Java is platform-independent due to its compilation to bytecode. [true/false]";
        this.answer[3] = "true";
        this.questions[4] = "The char data type in Java can represent Unicode characters. [true/false]";
        this.answer[4] = "true";
        this.questions[5] = "Java's long data type is larger in size than int. [true/false]";
        this.answer[5] = "true";
        this.questions[6] = "Java is an object-oriented programming language. [true/false]";
        this.answer[6] = "true";
        this.questions[7] = "The first official version of Java was released in the 1990s. [true/false]";
        this.answer[7] = "true";
        this.questions[8] = "The name Java was inspired by the Indonesian island of Bali. [true/false]";
        this.answer[8] = "false";
        this.questions[9] = "Java was originally developed for programming mobile devices. [true/false]";
        this.answer[9] = "false";
        this.questions[10] = "Java's development was led by James Gosling and Bill Gates. [true/false]";
        this.answer[10] = "false";
        this.questions[11] = "Java's name was chosen over options like Silk and Jolt. [true/false]";
        this.answer[11] = "true";
        this.questions[12] = "The void data type in Java is used to indicate the absence of a return value in a method. [true/false]";
        this.answer[12] = "true";
        this.questions[13] = "The static keyword in Java is used to declare instance variables. [true/false]";
        this.answer[13] = "false";
        this.questions[14] = "The println method in Java is used to print a line to the console. [true/false]";
        this.answer[14] = "true";
        this.questions[15] = "Java allows the use of spaces in variable names. [true/false]";
        this.answer[15] = "false";
        this.questions[16] = "The public static void main(String[] args) method is the entry point of a Java program. [true/false]";
        this.answer[16] = "true";
        this.questions[17] = "The System.out.print() method in Java is used for user input. [true/false]";
        this.answer[17] = "false";
        this.questions[18] = "Java supports single-line comments using the // notation. [true/false]";
        this.answer[18] = "true";
        this.questions[19] = "Java programs are written in butecode [true/false]";
        this.answer[19] = "false";
    }

    @Override
    public void addPoints() {
        this.points += 5;
    }
}

class ModerateQuiz extends Quiz {
    @Override
    public void startQuiz() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        this.passed = new int[5];
        this.answer = new String[5];
        int i = 0, items = 0;
        String ans;

        this.questions[0] = "Java supports multiple inheritance through classes [true/false]";
        this.answer[0] = "true";
        this.questions[1] = "What is the primary role of a setter method in Java";
        this.answer[1] = "set";
        this.questions[2] = "Which keyword is used to refer to the current instance of an object in Java?";
        this.answer[2] = "this";
        this.questions[3] = "What is the purpose of the 'new' keyword in Java?";
        this.answer[3] = "instantiate";
        this.questions[4] = "Which type of error is detected during runtime in Java?";
        this.answer[4] = "runtime";   

        while(i < 5) {
            int index = rand.nextInt(5) + 1;
            boolean exists = false;

            for(int x = 0; x < i; x++) {
                if(index == this.passed[i]) {
                    exists = true;
                    break;
                }
            }

            if(!exists) {
                this.passed[i] = index;
                i++;
            }
        }

        // debugging block
        System.out.println(i);

        // test phase
        System.out.println("test header");
        System.out.println();

        while(items < 5) {
            int clue = 0;
            int index = this.passed[items] - 1;
            System.out.println("lives: " + this.hp);
            System.out.println(questions[index]);
            while(true) {
                System.out.println("ans: ");
                ans = sc.nextLine();
                if(!ans.equalsIgnoreCase(answer[index])) {
                    System.out.println("wrong");
                    System.out.println("lives: " + this.hp);
                    System.out.println("clue: " + answer[index].charAt(clue));
                    if(hp == 0) {
                        System.out.println("game over");
                        return;
                    }
                    this.damage();
                    clue++;
                } else {
                    System.out.println("correct");
                    break;
                }
            }
            items++;
        }
    }

    @Override
    public void addPoints() {
        this.points += 10;
    }
}