import java.io.*;
import java.util.*;


public class Main {
    static class node{
        int next, length;
        public node(int next, int length){
            this.next = next;
            this.length = length;
        }
    }
    static ArrayList<ArrayList<node>> tree = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i=0;i<=N;i++)
            tree.add(new ArrayList<>());
        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            tree.get(a).add(new node(b, w));
            tree.get(b).add(new node(a, w));
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(search(a, b, N) + "\n");	
        }
        bw.flush();		
        bw.close();
        br.close();
    }
    static int search(int start, int end, int n){
        Queue<node> q = new LinkedList<>();		
        boolean[] visited = new boolean[n+1];	
        visited[start] = true;	
        q.add(new node(start, 0));	
        while(!q.isEmpty()){
            node cur = q.poll();
            if(cur.next == end)		
                return cur.length;
            for(node next : tree.get(cur.next)){
                if(!visited[next.next]){
                    visited[next.next] = true;
                    q.add(new node(next.next, cur.length + next.length));
                }
            }
        }
        return -1;
    }
}

