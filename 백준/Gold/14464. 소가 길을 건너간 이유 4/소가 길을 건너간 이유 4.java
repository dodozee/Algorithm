import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main {
 
    static int C, N;
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
 
        int[] chickens = new int[C];
        for (int i = 0; i < C; i++) {
            chickens[i] = Integer.parseInt(br.readLine());
        }
 
        Cow[] cows = new Cow[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
 
            cows[i] = new Cow(a, b);
        }
 
        Arrays.sort(chickens);
        Arrays.sort(cows);
        
        System.out.println(process(chickens, cows));
    }
 
    private static int process(int[] chickens, Cow[] cows) {
 
        int cnt = 0, cIdx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < C; i++) {
            while(cIdx < N && cows[cIdx].s <= chickens[i]) {
                pq.add(cows[cIdx++].e);
            }
            
            while(!pq.isEmpty() && pq.peek() < chickens[i]) {
                pq.poll();
            }
            
            if(!pq.isEmpty()) {
                cnt++;
                pq.poll();
            }
        }
 
        return cnt;
    }
 
    static class Cow implements Comparable<Cow>{
        int s, e;
 
        public Cow(int s, int e) {
            this.s = s;
            this.e = e;
        }
        
        @Override
        public int compareTo(Cow o) {
            return Integer.compare(this.s, o.s);
        }
    }
}
