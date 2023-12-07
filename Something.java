import java.util.Random;
import java.util.Scanner;

public class Something {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int index;
        int[] unique = new int[5];
        String[] test = new String[5];
        String[] answer = new String[5];
        String ans, correct;
        int i = 0, check = 0;

        while(i < 5) {
            index = r.nextInt(5) + 1;
            boolean exists = false;

            for(int x = 0; x < i; x++) {
                if(index == unique[x]) {
                    exists = true;
                    break;
                }
            }

            if(!exists) {
                unique[i] = index;
                i++;
            }
        }

        System.out.println(i);
        for(int x = 0; x < 5; x++) {
            System.out.println(unique[x]);
        }

        test[0] = "Java supports multiple inheritance through classes [true/false]";
        answer[0] = "true";
        test[1] = "What is the primary role of a setter method in Java";
        answer[1] = "set";
        test[2] = "Which keyword is used to refer to the current instance of an object in Java?";
        answer[2] = "this";
        test[3] = "What is the purpose of the 'new' keyword in Java?";
        answer[3] = "instantiate";
        test[4] = "Which type of error is detected during runtime in Java?";
        answer[4] = "runtime";

        int hp = 3;
        while(check < 5) {
            int clue = 0;
            int testIndex = unique[check] - 1;
            // int hp = 3;
            // sc.nextLine();
            System.out.println(test[testIndex]);
            while(true) {
                System.out.print("ans: ");
                ans = sc.nextLine();
                if(!ans.equalsIgnoreCase(answer[testIndex])) {
                    System.out.println(hp);
                    System.out.println("wrong");
                    System.out.println("clue: " + answer[testIndex].charAt(clue));
                    if(hp == 0) {
                        System.out.println("done");
                        return;
                    } 
                    hp--;
                    clue++;
                }
                else {
                    System.out.println("correct");
                    break;
                }
            }
            /*/
            if(hp == 0) {
                System.out.println("done");
                break;
            }
            */

            check++;
        }
    }
}
