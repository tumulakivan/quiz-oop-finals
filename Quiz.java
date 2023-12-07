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
                System.out.print("ans: ");
                ans = sc.nextLine();
                if(!ans.equalsIgnoreCase(answer[index])) {
                    this.damage();
                    System.out.println("wrong");
                    System.out.println("lives: " + this.hp);
                    if(hp == 0) {
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

    @Override
    public void addPoints() {
        this.points += 10;
    }
}