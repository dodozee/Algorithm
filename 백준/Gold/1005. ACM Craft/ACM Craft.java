import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] width, count, answer;
    static ArrayList<ArrayList<Integer>> graph;	
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 0;test_case < T;test_case++) {
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            width = new int[N+1];
            count = new int[N+1];
            graph = new ArrayList<>();
            for(int i=0;i<=N;i++)
                graph.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine()," ");
            for(int i=1;i<=N;i++)
                width[i] = Integer.parseInt(st.nextToken());
            for(int i=0;i<K;i++) {
                st = new StringTokenizer(br.readLine()," ");
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                count[B]++;	
                graph.get(A).add(B);
            }
            int W = Integer.parseInt(br.readLine());
            Queue<Integer> q = new LinkedList<>();
            answer = new int[N+1];
            //child 0개 확인
            for(int i=1;i<=N;i++) {
                answer[i] = width[i];	
                if(count[i] == 0)
                    q.offer(i);
            }
            while(!q.isEmpty()) {
                int cur = q.poll();
                for(int next : graph.get(cur)) {
                    answer[next] = Math.max(answer[next], answer[cur] + width[next]);
                    count[next]--;	
                    if(count[next] == 0)	
                        q.offer(next);
                }
            }
            bw.write(answer[W] + "\n");	
        }
        bw.flush();		
        bw.close();
        br.close();
    }

}