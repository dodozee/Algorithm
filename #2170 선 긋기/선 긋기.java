import java.io.*;
import java.sql.Array;
import java.util.*;


/**
 *
 */
public class Main {
    static class Info implements Comparable<Info> {
        int s;
        int e;

        public Info(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Info o) {
            if(this.s == o.s){ //s가 같으면
                return o.e - this.e;//내림차순
            }
            
            return this.s - o.s;//오름차순
        }
        
    
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Info> pq = new PriorityQueue<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        Info first = pq.poll();
        
        int start = first.s;
        int end = first.e;
        
        int result = 0;

        while (!pq.isEmpty()) {
            Info temp = pq.poll();
            if(temp.s > end){
                result += end - start;
                start = temp.s;
                end = temp.e;
                continue;
            }
            
            if(temp.e > end){
                end = temp.e;
            }
            
        }
        
        result += end - start;
        
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        
    }
}