import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] depth;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//출력

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        depth = new int[N+1];

        for(int i=0; i<=N; i++){
            tree.add(new ArrayList<Integer>());
        }

        for(int i = 1 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        setTree(1, 1, 0);

        int M = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(LCA(a, b) + "\n");
        }

        bw.flush();




    }

    private static void setTree(int cur, int d, int p) {
        parent[cur] = p; //부모노드
        depth[cur] = d; //깊이

        for(int i = 0 ; i < tree.get(cur).size(); i++){
            int next = tree.get(cur).get(i);
            if(next != p){
                setTree(next, d+1, cur);
            }
        }
    }

    private static int LCA(int a, int b) {
        int ah = depth[a]; //a의 깊이
        int bh = depth[b]; //b의 깊이

        //두 노드의 깊이가 다르면 깊이를 맞춰준다.
        while(ah != bh){
            if(ah > bh){
                a = parent[a];
                ah--;
            }else{
                b = parent[b];
                bh--;
            }
        }

        //두 노드가 같아질때까지 부모노드로 이동
        while (true) {
            if (a == b) {
                return a;
            } else {
                a = parent[a];
                b = parent[b];
            }
        }



    }
}