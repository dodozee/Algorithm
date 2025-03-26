import java.io.*;
import java.util.*;
 
class Point {
    int x;
    int y;
 
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
 
public class Main {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
 
        ArrayList<Point> a; 
        ArrayList<ArrayList<Integer>> graph;
        
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
 
            a = new ArrayList<>();
            
            for (int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
 
                a.add(new Point(x, y));
            }
 
            graph = new ArrayList<>();
            for (int i = 0; i < N + 2; i++) {
                graph.add(new ArrayList<>());
            }
            
            for (int i = 0; i < N + 2; i++) {
                for (int j = i + 1; j < N + 2; j++) {
                    if (Manhattan(a.get(i), a.get(j)) <= 1000) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }
            
            sb.append((BFS(graph, N) ? "happy" : "sad") + '\n');
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int Manhattan(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
    
    public static boolean BFS(ArrayList<ArrayList<Integer>> graph, int N) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
 
        boolean[] visited = new boolean[N + 2];
        visited[0] = true;
 
        while (!q.isEmpty()) {
            int now = q.poll();
 
            if (now == N + 1) {
                return true;
            }
 
            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
 
        return false;
    }
 
}
