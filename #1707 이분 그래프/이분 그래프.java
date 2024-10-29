
import java.io.*;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    static int[] parents;
    static ArrayList<Integer>[] A;
    static int[] check;;
    static boolean[] visited;
    static boolean IsEven;

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A = new ArrayList[v+1];
            check = new int[v+1];
            visited = new boolean[v+1];
            IsEven = true;

            for (int j = 1; j < v + 1; j++) {
                A[j] = new ArrayList<>();
            }

            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());

                A[S].add(E);
                A[E].add(S);
            }

            for (int j = 1; j <= v; j++) {
                if (IsEven) {
                    dfs(j);
                } else {
                    break;
                }
            }

            if(IsEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    private static void dfs(int x){

        if(!IsEven) return;

        visited[x] = true;

        for(int node : A[x]){
            if (check[x] == 0) {
                check[x] = 1;
            }
            if(!visited[node]){
                check[node] = check[x] * -1;
                dfs(node);
            } else if (check[node] == check[x]) {
                IsEven = false;
                return;
            }
        }

    }

}


