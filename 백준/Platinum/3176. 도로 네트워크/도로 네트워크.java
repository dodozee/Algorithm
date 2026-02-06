import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// LCA

public class Main {
    static List<Integer>[] arr; // 인접리스트 그래프
    static List<Integer>[] cost;
    static int[][] parents;
    static int[][] minList, maxList;
    static int[] depth;
    static int k; // 최대 높이
    static int n;
    
    // 부모노드 저장
    private static void dfs(int node, int cnt) {
        depth[node] = cnt;
        
        for(int i = 0; i < arr[node].size(); i++) {
            int next = arr[node].get(i);
            if(depth[next] == 0) {
                parents[next][0] = node;
                minList[next][0] = cost[node].get(i);
                maxList[next][0] = cost[node].get(i);
                dfs(next, cnt + 1);
            }
        }
    }
    
    
    // 노드별 2^i 번째 부모노드 저장
    private static void fillParents() {
        for(int i = 1; i < k; i++) { 
            for(int j = 1; j <= n; j++) {
                parents[j][i] = parents[parents[j][i-1]][i-1];
                minList[j][i] = Math.min(minList[j][i-1], minList[parents[j][i-1]][i-1]);
                maxList[j][i] = Math.max(maxList[j][i-1], maxList[parents[j][i-1]][i-1]);
            }
        }
    }
        
    private static int[] lca(int a, int b) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        
        // depth가 깊은 노드를 기준으로
        if(depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        
        for(int i = k - 1; i >= 0; i--) {
            if(Math.pow(2, i) <= depth[a] - depth[b]) {
                min = Math.min(min, minList[a][i]);
                max = Math.max(max, maxList[a][i]);
                a = parents[a][i];
            }
        }
        
        if(a == b)
            return new int[] {min, max};
        else {

            for(int i = k-1; i >= 0; i--) {
                if(parents[a][i] != parents[b][i]) {
                    min = Math.min(min, Math.min(minList[a][i], minList[b][i]));
                    max = Math.max(max, Math.max(maxList[a][i], maxList[b][i]));
                    a = parents[a][i];
                    b = parents[b][i];
                }
            }
        }
        
        min = Math.min(min, Math.min(minList[a][0], minList[b][0]));
        max = Math.max(max, Math.max(maxList[a][0], maxList[b][0]));
        
        return new int[] {min, max};
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        
        k = 0;
        int tmp = 1;
        while(tmp <= n) {
            tmp <<= 1;
            k++;
        }
        
        arr = new ArrayList[n+1];
        cost = new ArrayList[n+1];
        for (int i = 0; i<= n; i++) {
            arr[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();            
        }
        
        minList = new int[n+1][k];
        maxList = new int[n+1][k];
        for(int[] m : minList)
            Arrays.fill(m, Integer.MAX_VALUE);
        
        depth = new int[n+1];
        parents = new int[n+1][k];
        
        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            arr[a].add(b);
            arr[b].add(a);
            cost[a].add(c);
            cost[b].add(c);
        }
        
        dfs(1, 1);
        fillParents();
        
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            int[] res = lca(d, e);
            sb.append(String.valueOf(res[0]) + " " + String.valueOf(res[1]) + "\n");
        }
        
        System.out.println(sb.toString());
        

    }

}