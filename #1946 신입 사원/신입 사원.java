import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Applicant[] applicants = new Applicant[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int documentScore = Integer.parseInt(st.nextToken());
                int interviewScore = Integer.parseInt(st.nextToken());
                applicants[i] = new Applicant(documentScore, interviewScore);
            }

            Arrays.sort(applicants);

            int count = 1;
            int minInterviewScore = applicants[0].interviewScore;

            for (int i = 1; i < N; i++) {
                if (applicants[i].interviewScore < minInterviewScore) {
                    count++;
                    minInterviewScore = applicants[i].interviewScore;
                }
            }

            System.out.println(count);
        }
    }

    static class Applicant implements Comparable<Applicant> {
        int documentScore;
        int interviewScore;

        public Applicant(int documentScore, int interviewScore) {
            this.documentScore = documentScore;
            this.interviewScore = interviewScore;
        }

        @Override
        public int compareTo(Applicant other) {
            return Integer.compare(this.documentScore, other.documentScore);
        }
    }
}
