import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st;
        final int NUMBER_OF_MINUTE = Integer.parseInt(br.readLine());
        Stack<Homework> homeworkStack = new Stack<>();
        int totalScore = 0;
        for (int i = 0; i < NUMBER_OF_MINUTE; i++) {
            st = new StringTokenizer(br.readLine());

            if (st.nextToken().charAt(0) == '1') {
                int score = Integer.parseInt(st.nextToken());
                int minute = Integer.parseInt(st.nextToken());
                if (minute == 1) {
                    totalScore += score;
                } else {
                    homeworkStack.push(new Homework(score, minute - 1));
                }
            } else if (!homeworkStack.isEmpty()) {
                Homework temp = homeworkStack.pop();
                temp.minute--;
                if (temp.minute == 0) {
                    totalScore += temp.score;
                } else {
                    homeworkStack.push(temp);
                }
            }
        }


        sb.append(totalScore);
        sb.append("\n");

        bw.write(sb.toString());

        bw.flush();
 

    }


}

class Homework {
    int score;
    int minute;

    public Homework() {
    }

    public Homework(int score, int minute) {
        this.score = score;
        this.minute = minute;
    }
}