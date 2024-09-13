 
import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
       return o2 - o1;
    });
 
        N = atoi(br.readLine());
 
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = atoi(st.nextToken());
 
            if(a == 0){
                if(pq.isEmpty()) sb.append(-1).append("\n");
                else sb.append(pq.poll()).append("\n");
            }
            else{
                for (int j = 0; j < a; j++) {
                    pq.offer(atoi(st.nextToken()));
                }
            }
        }
 
        System.out.print(sb);
    }
}