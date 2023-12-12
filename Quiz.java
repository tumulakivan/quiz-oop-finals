package Finals;

import java.util.Scanner;
import java.util.Random;

abstract class Quiz {
    protected int points = 0;
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
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        this.passed = new int[20];
        this.answer = new String[20];
        int i = 0, items = 0;
        String ans;

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

        while(i < 20) {
            int index = rand.nextInt(20);
            boolean exists = false;

            for(int x = 0; x < i; x++) {
                if(index == this.passed[x]) {
                    exists = true;
                    break;
                }
            }

            if(!exists) {
                this.passed[i] = index;
                i++;
            }
        }

        // clear screen
        for(int space = 0; space < 50; space++) System.out.println();


        System.out.println("Quiz has started!");
        System.out.println();

        while(items < 10) {
            int index = this.passed[items];
            System.out.println("lives: " + this.hp);    
            System.out.println(items + 1 + ".) " + questions[index]);
            while(true) {
                System.out.print("ans: ");
                ans = sc.nextLine();
                if(!ans.equalsIgnoreCase(answer[index])) {
                    this.damage();
                    this.deductPoints();
                    System.out.println("wrong");
                    System.out.println("lives: " + this.hp);
                    if(hp == 0) {
                        System.out.println("game over");
                        System.out.println("total points: " + this.getPoints());
                        return;
                    }
                } else {
                    System.out.println("correct");
                    System.out.println();
                    this.addPoints();
                    break;
                }
            }
            items++;
        }

        System.out.println("total points: " + this.getPoints());
    }

    public void deductPoints() {
        this.points -= 1;
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
        this.passed = new int[20];
        this.answer = new String[20];
        int i = 0, items = 0;
        String ans;

        this.questions[0] = "In Java, what does the `break` keyword primarily relate to?\na) Loop\nb) Exception\nc) Interface\nd) Constructor";
        this.answer[0] = "a";
        this.questions[1] = "What is the primary role of a setter method in Java?\na) List\nb) Set\nc) Map\nd) Queue";
        this.answer[1] = "b";
        this.questions[2] = "Which keyword is used to refer to the current instance of an object in Java?\na) that\nb) self\nc) here\nd) this";
        this.answer[2] = "d";
        this.questions[3] = "What is the purpose of the \"new\" keyword in Java?\na) Create\nb) Instantiate\nc) Initialize\nd) Deallocate";
        this.answer[3] = "b";
        this.questions[4] = "Which type of error is detected during runtime in Java?\na) Syntax\nb) Compilation\nc) Logical\nd) Runtime";
        this.answer[4] = "d";
        this.questions[5] = "Which access modifier allows a variable or method to be accessible only within its own class?\na) Public\nb) Private\nc) Protected\nd) Default";
        this.answer[5] = "b";
        this.questions[6] = "What is the term for variables that are accessible only within the method or block where they are declared?\na) Global\nb) Public\nc) Local\nd) Static";
        this.answer[6] = "c";
        this.questions[7] = "What is the keyword used to define a method that does not return any value in Java?\na) int\nb) null\nc) void\nd) return";
        this.answer[7] = "c";
        this.questions[8] = "In Java, what term is used for variables declared outside any method or block and are accessible throughout the class?\na) Local\nb) Global\nc) Private\nd) Static";
        this.answer[8] = "b";
        this.questions[9] = "What type of method in Java can call itself during its execution?\na) Static\nb) Final\nc) Recursive\nd) Abstract";
        this.answer[9] = "c";
        this.questions[10] = "What does the 'private' access modifier in Java signify for a class member?\na) Accessible globally\nb) Accessible within the same package\nc) Accessible within subclasses\nd) Accessible only within the same class";
        this.answer[10] = "d";
        this.questions[11] = "Which access modifier allows a class member to be accessed from any class in the same package or its subclasses, regardless of the package they are in?\na) Public\nb) Protected\nc) Private\nd) Default";
        this.answer[11] = "b";
        this.questions[12] = "What is the default access modifier in Java if none is specified for a class member?\na) Public\nb) Private\nc) Default\nd) Protected";
        this.answer[12] = "c";
        this.questions[13] = "Which access modifier allows a class member to be accessed globally from any class in Java?\na) Private\nb) Default\nc) Protected\nd) Public";
        this.answer[13] = "d";
        this.questions[14] = "What do you call the values passed to a method when it is called?\na) Variables\nb) Parameters\nc) Arguments\nd) Instances";
        this.answer[14] = "b";
        this.questions[15] = "Which keyword is used to explicitly return a value from a method in Java?\na) void\nb) return\nc) send\nd) retrieve";
        this.answer[15] = "b";
        this.questions[16] = "Actual parameters, also known as\na) Formals\nb) Placeholders\nc) Arguments\nd) Variables";
        this.answer[16] = "c";
        this.questions[17] = "It is also referred to as parameters or method parameters, are placeholders defined in the method declaration or definition.\na) Real parameters\nb) Formal parameters\nc) Actual parameters\nd) Direct parameters";
        this.answer[17] = "b";
        this.questions[18] = "What is the role of a parameter with the 'final' keyword in a Java method?\na) It indicates that the parameter cannot be accessed globally.\nb) It marks the parameter as a constant, preventing its value from being changed.\nc) It specifies that the parameter is optional during method invocation.\nd) It restricts the parameter to be used only within the same class.";
        this.answer[18] = "b";
        this.questions[19] = "What does the 'break' statement do when used inside a switch statement in Java? \na)Terminates the entire program\nb) Exits the switch statement.\nc) Jumps to the next case without executing the current one. \nd) Skips the remaining cases and executes the default case.";
        this.answer[19] = "b";

        while(i < 20) {
            int index = rand.nextInt(20);
            boolean exists = false;

            for(int x = 0; x < i; x++) {
                if(index == this.passed[x]) {
                    exists = true;
                    break;
                }
            }

            if(!exists) {
                this.passed[i] = index;
                i++;
            }
        }

        // clear screen
        for(int space = 0; space < 50; space++) System.out.println();


        System.out.println("Quiz has started!");
        System.out.println();

        while(items < 10) {
            int index = this.passed[items];
            System.out.println("lives: " + this.hp);    
            System.out.println(items + 1 + ".) " + questions[index]);
            while(true) {
                System.out.print("ans: ");
                ans = sc.nextLine();
                if(!ans.equalsIgnoreCase(answer[index])) {
                    this.damage();
                    this.deductPoints();
                    System.out.println("wrong");
                    System.out.println("lives: " + this.hp);
                    if(hp == 0) {
                        System.out.println();
                        System.out.println("game over");
                        System.out.println("total points: " + this.getPoints());
                        return;
                    }
                } else {
                    System.out.println("correct");
                    System.out.println();
                    this.addPoints();
                    break;
                }
            }
            items++;
        }

        System.out.println("total points: " + this.getPoints());
    }

    public void deductPoints() {
        this.points -= 2;
    }

    @Override
    public void addPoints() {
        this.points += 10;
    }
}

class HardQuiz extends Quiz {
    @Override
    public void startQuiz() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        this.passed = new int[20];
        this.answer = new String[20];
        int i = 0, items = 0;
        String ans;

        this.questions[0] = "What keyword is used to prevent a method from being overridden in Java?";
        this.answer[0] = "Final";
        this.questions[1] = "Which Java keyword is used to implement multiple inheritance in interfaces?";
        this.answer[1] = "Default";
        this.questions[12] = "What is the access modifier for a default (package-private) member in Java?";
        this.answer[12] = "Package Private";
        this.questions[3] = "Which method is called when an object is garbage collected in Java?";
        this.answer[3] = "Finalize";
        this.questions[4] = "What is the purpose of the transient keyword in Java?";
        this.answer[4] = "Serialization";
        this.questions[5] = "What is the output of System.out.println(1 << 3)?";
        this.answer[5] = "8";
        this.questions[6] = "Which class is the superclass of all classes in Java?";
        this.answer[6] = "Object";
        this.questions[7] = "What is the default value of a local variable in Java?";
        this.answer[7] = "Not Initialized";
        this.questions[8] = "What is the purpose of the super keyword in Java?";
        this.answer[8] = "Superclass";
        this.questions[9] = "What is the role of the this keyword in Java?";
        this.answer[9] = "Current Instance";
        this.questions[10] = "Which Java keyword is used to implement abstraction?";
        this.answer[10] = "Abstract";
        this.questions[11] = "What is the difference between == and .equals() in Java when comparing objects?";
        this.answer[11] = "Object Content Equality";
        this.questions[12] = "In Java, what is the purpose of the volatile keyword?";
        this.answer[12] = "Thread synchronization";
        this.questions[13] = "What is the role of the break statement in a Java switch statement?";
        this.answer[13] = "Exit the switch";
        this.questions[14] = "What is the significance of the static keyword in Java?";
        this.answer[14] = "Class";
        this.questions[15] = "What is the purpose of the try, catch, and finally blocks in Java exception handling?";
        this.answer[15] = "Exception Handling";
        this.questions[16] = "Which class provides methods for dynamic memory allocation in Java?";
        this.answer[16] = "java.lang.StringBuilder";
        this.questions[17] = "What is the output of System.out.println(Math.ceil(5.1))?";
        this.answer[17] = "6.0";
        this.questions[18] = "What is the role of the interface keyword in Java?";
        this.answer[18] = "Define a contract for classes";
        this.questions[19] = "Which method is used to convert a primitive data type to a string in Java?";
        this.answer[19] = "String.valueOf()";

        while(i < 20) {
            int index = rand.nextInt(20);
            boolean exists = false;

            for(int x = 0; x < i; x++) {
                if(index == this.passed[x]) {
                    exists = true;
                    break;
                }
            }

            if(!exists) {
                this.passed[i] = index;
                i++;
            }
        }

        // clear screen
        for(int space = 0; space < 50; space++) System.out.println();


        System.out.println("Quiz has started!");
        System.out.println();

        while(items < 10) {
            int clue = 0;
            int index = this.passed[items];
            System.out.println("lives: " + this.hp);    
            System.out.println(items + 1 + ".) " + questions[index]);
            while(true) {
                System.out.print("ans: ");
                ans = sc.nextLine();
                if(!ans.equalsIgnoreCase(answer[index])) {
                    this.damage();
                    this.deductPoints();
                    System.out.println("wrong");
                    System.out.println("lives: " + this.hp);
                    if(hp == 0) {
                        System.out.println();
                        System.out.println("game over");
                        System.out.println("total points: " + this.getPoints());
                        return;
                    }
                    System.out.println("clue: " + answer[index].charAt(clue));
                    clue++;
                } else {
                    System.out.println("correct");
                    System.out.println();
                    this.addPoints();
                    break;
                }
            }
            items++;
        }

        System.out.println("total points: " + this.getPoints());
    }

    public void deductPoints() {
        this.points -= 5;
    }

    @Override
    public void addPoints() {
        this.points += 20;
    }
}

