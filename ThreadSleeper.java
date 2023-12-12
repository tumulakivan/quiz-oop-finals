package Finals;

public class ThreadSleeper {
    private long ms;

    public ThreadSleeper() {
        this.ms = 0;
    }

    public void initMenu() {
        String top = "WELCOME TO QUIZOLOGYTARIANISM\n";
        String intro = "Are YOU smarter than a 1st grader? Let's find out by taking our QUIZOLOGYTARIANISM course!\n";
        String prompt = "To start, please select any given number below.\n";
        String select1 = "1 - EASY\n";
        String select2 = "2 - MODERATE\n";
        String select3 = "3 - HARD\n";
        String select4 = "4 - I'M TOO DUMB FOR THIS";

        try {
            String text = top + intro + prompt + select1 + select2 + select3 + select4;
            for(char c : text.toCharArray()) {
                System.out.print(c);
                if(c == '\n') Thread.sleep(0);
                else Thread.sleep(this.ms);
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        try {
            String text = "\n";
            for(char c : text.toCharArray()) {
                System.out.println(c);
                Thread.sleep(500);
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}