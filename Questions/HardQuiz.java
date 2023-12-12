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

class HardQuiz extends Quiz{
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
    @Override
    public void startQuiz() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        this.passed = new int[5];
        this.answer = new String[5];
        int i = 0, items = 0;
        String ans;

        this.questions[0] = "What keyword is used to prevent a method from being overridden in Java?";
        this.answers[0] = "Final";
        this.questions[1] = "Which Java keyword is used to implement multiple inheritance in interfaces?";
        this.answers[1] = "Default";
        this.questions[12] = "What is the access modifier for a default (package-private) member in Java?";
        this.answers[12] = "Package Private";
        this.questions[3] = "Which method is called when an object is garbage collected in Java?";
        this.answers[3] = "Finalize";
        this.questions[4] = "What is the purpose of the transient keyword in Java?";
        this.answers[4] = "Serialization";
        this.questions[5] = "What is the output of System.out.println(1 << 3)?";
        this.answers[5] = "8";
        this.questions[6] = "Which class is the superclass of all classes in Java?";
        this.answers[6] = "Object";
        this.questions[7] = "What is the default value of a local variable in Java?";
        this.answers[7] = "Not Initialized";
        this.questions[8] = "What is the purpose of the super keyword in Java?";
        this.answers[8] = "Superclass";
        this.questions[9] = "What is the role of the this keyword in Java?";
        this.answers[9] = "Current Instance";
        this.questions[10] = "Which Java keyword is used to implement abstraction?";
        this.answers[10] = "Abstract";
        this.questions[11] = "What is the difference between == and .equals() in Java when comparing objects?";
        this.answers[11] = "Object Content Equality";
        this.questions[12] = "In Java, what is the purpose of the volatile keyword?";
        this.answers[12] = "Thread synchronization";
        this.questions[13] = "What is the role of the break statement in a Java switch statement?";
        this.answers[13] = "Exit the switch";
        this.questions[14] = "What is the significance of the static keyword in Java?";
        this.answers[14] = "Class";
        this.questions[15] = "What is the purpose of the try, catch, and finally blocks in Java exception handling?";
        this.answers[15] = "Exception Handling";
        this.questions[16] = "Which class provides methods for dynamic memory allocation in Java?";
        this.answers[16] = "java.lang.StringBuilder";
        this.questions[17] = "What is the output of System.out.println(Math.ceil(5.1))?";
        this.answers[17] = "6.0";
        this.questions[18] = "What is the role of the interface keyword in Java?";
        this.answers[18] = "Define a contract for classes";
        this.questions[19] = "Which method is used to convert a primitive data type to a string in Java?";
        this.answers[19] = "String.valueOf()";

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