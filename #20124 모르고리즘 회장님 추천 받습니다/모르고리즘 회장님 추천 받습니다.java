import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] node = new Node[N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            node[i] = new Node(score,name);
        }

        Arrays.sort(node);
        System.out.println(node[0].n);
    }

    static class Node implements Comparable<Node>{
        int s;
        String n;

        public Node(int score,String name) {
            this.s = score;
            this.n = name;
        }

        @Override
        public int compareTo(Node o) {
            if(this.s == o.s)
                return this.n.compareTo(o.n);
            else
                return o.s-this.s;
        }
    }
}