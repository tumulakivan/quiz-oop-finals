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

        this.questions[0] = "In Java, what does the `break` keyword primarily relate to?\na) Loop\nb) Exception\nc) Interface\nd) Constructor";
        this.answers[0] = "a";
        this.questions[1] = "What is the primary role of a setter method in Java?\na) List\nb) Set\nc) Map\nd) Queue";
        this.answers[1] = "b";
        this.questions[12] = "Which keyword is used to refer to the current instance of an object in Java?\na) that\nb) self\nc) here\nd) this";
        this.answers[12] = "d";
        this.questions[3] = "What is the purpose of the \"new\" keyword in Java?\na) Create\nb) Instantiate\nc) Initialize\nd) Deallocate";
        this.answers[3] = "b";
        this.questions[4] = "Which type of error is detected during runtime in Java?\na) Syntax\nb) Compilation\nc) Logical\nd) Runtime";
        this.answers[4] = "d";
        this.questions[5] = "Which access modifier allows a variable or method to be accessible only within its own class?\na) Public\nb) Private\nc) Protected\nd) Default";
        this.answers[5] = "b";
        this.questions[6] = "What is the term for variables that are accessible only within the method or block where they are declared?\na) Global\nb) Public\nc) Local\nd) Static";
        this.answers[6] = "c";
        this.questions[7] = "What is the keyword used to define a method that does not return any value in Java?\na) int\nb) null\nc) void\nd) return";
        this.answers[7] = "c";
        this.questions[8] = "In Java, what term is used for variables declared outside any method or block and are accessible throughout the class?\na) Local\nb) Global\nc) Private\nd) Static";
        this.answers[8] = "b";
        this.questions[9] = "What type of method in Java can call itself during its execution?\na) Static\nb) Final\nc) Recursive\nd) Abstract";
        this.answers[9] = "c";
        this.questions[10] = "What does the 'private' access modifier in Java signify for a class member?\na) Accessible globally\nb) Accessible within the same package\nc) Accessible within subclasses\nd) Accessible only within the same class";
        this.answers[10] = "d";
        this.questions[11] = "Which access modifier allows a class member to be accessed from any class in the same package or its subclasses, regardless of the package they are in?\na) Public\nb) Protected\nc) Private\nd) Default";
        this.answers[11] = "b";
        this.questions[12] = "What is the default access modifier in Java if none is specified for a class member?\na) Public\nb) Private\nc) Default\nd) Protected";
        this.answers[12] = "c";
        this.questions[13] = "Which access modifier allows a class member to be accessed globally from any class in Java?\na) Private\nb) Default\nc) Protected\nd) Public";
        this.answers[13] = "d";
        this.questions[4] = "What do you call the values passed to a method when it is called?\na) Variables\nb) Parameters\nc) Arguments\nd) Instances";
        this.answers[14] = "b";
        this.questions[15] = "Which keyword is used to explicitly return a value from a method in Java?\na) void\nb) return\nc) send\nd) retrieve";
        this.answers[15] = "b";
        this.questions[16] = "Actual parameters, also known as\na) Formals\nb) Placeholders\nc) Arguments\nd) Variables";
        this.answers[16] = "c";
        this.questions[17] = "It is also referred to as parameters or method parameters, are placeholders defined in the method declaration or definition.\na) Real parameters\nb) Formal parameters\nc) Actual parameters\nd) Direct parameters";
        this.answers[17] = "b";
        this.questions[18] = "What is the role of a parameter with the 'final' keyword in a Java method?\na) It indicates that the parameter cannot be accessed globally.\nb) It marks the parameter as a constant, preventing its value from being changed.\nc) It specifies that the parameter is optional during method invocation.\nd) It restricts the parameter to be used only within the same class.";
        this.answers[18] = "b";
        this.questions[19] = "What does the 'break statement do when used inside a switch statement in Java? \na)Terminates the entire program\nb) Exits the switch statement.\nc) Jumps to the next case without executing the current one. \nd) Skips the remaining cases and executes the default case.";
        this.answers[19] = "b";










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