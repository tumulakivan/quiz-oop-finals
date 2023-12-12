package Test;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Abstract class for Quiz
abstract class Quiz {
    protected String question;
    protected int difficultyLevel;

    public Quiz(String question, int difficultyLevel) {
        this.question = question;
        this.difficultyLevel = difficultyLevel;
    }

    // Abstract method to display the question
    public abstract void displayQuestion();

    // Abstract method to check the answer
    public abstract boolean checkAnswer(String userAnswer);

    // Method to get the difficulty level
    public int getDifficultyLevel() {
        return difficultyLevel;
    }
}

// Interface for scoring
interface Scorable {
    void updateScore(int score);
}

// Concrete class for Multiple Choice Quiz
class MultipleChoiceQuiz extends Quiz implements Scorable {
    private String correctAnswer;
    private int score;

    public MultipleChoiceQuiz(String question, int difficultyLevel, String correctAnswer) {
        super(question, difficultyLevel);
        this.correctAnswer = correctAnswer;
        this.score = 0;
    }

    @Override
    public void displayQuestion() {
        System.out.println("Multiple Choice Question (Difficulty Level: " + difficultyLevel + ")");
        System.out.println(question);
        // Display multiple choices (options) here
        System.out.println("A. Option A");
        System.out.println("B. Option B");
        System.out.println("C. Option C");
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        boolean isCorrect = userAnswer.equalsIgnoreCase(correctAnswer);
        if (isCorrect) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is: " + correctAnswer);
        }
        return isCorrect;
    }

    @Override
    public void updateScore(int score) {
        this.score += score;
    }

    // Method to get the score
    public int getScore() {
        return score;
    }
}

// Class for Quiz Game
public class Test {
    public static void main(String[] args) {
        // Create a quiz
        MultipleChoiceQuiz quiz = new MultipleChoiceQuiz("What is the capital of France?", 2, "B");

        // Display the question
        quiz.displayQuestion();

        // Get user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your answer: ");
        String userAnswer = scanner.nextLine();

        // Check the answer and update the score
        if (quiz.checkAnswer(userAnswer)) {
            System.out.println("Your current score: " + quiz.getScore());
        }

        // Write the score to a file
        writeScoreToFile(quiz.getScore());
    }

    // Method to write the score to a file
    private static void writeScoreToFile(int score) {
        try (FileWriter writer = new FileWriter("user_score.txt")) {
            writer.write("User Score: " + score);
            System.out.println("Score has been written to user_score.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}