import java.util.*;
import java.io.*;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;        
        
        int N = Integer.parseInt(br.readLine());
        
        Lecture[] lectures = new Lecture[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(s, e);
        }  
        Arrays.sort(lectures, (l1, l2) -> l1.s == l2.s ? l1.e - l2.e : l1.s - l2.s);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lectures[0].e);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= lectures[i].s) {
                pq.poll();
            }
            pq.offer(lectures[i].e);
        }

        bw.write(pq.size() + "\n");
        bw.flush();
    }

}
class Lecture {
    int s;
    int e;

    Lecture(int s, int e) {
        this.s = s;
        this.e = e;
    }
}