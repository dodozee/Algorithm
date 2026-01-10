import java.io.*;
import java.util.*;

class Main {

    static class Work implements Comparable<Work>{
        int t, s, n;

        public Work(int t, int s, int n) {
            this.t = t;
            this.s = s;
            this.n = n;
        }

        @Override
        public int compareTo(Work o) {
            int riskThis = this.t * o.s;
            int riskOther = this.s * o.t;
            if (riskThis < riskOther) return -1;
            else if(riskThis > riskOther) return 1;
            else return this.n - o.n;
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;

    static int N;
    static List<Work> workList = new ArrayList<>();

    public static void solve() throws IOException {
        Collections.sort(workList);
        for (int i = 0; i < workList.size(); i++)
            bw.write(workList.get(i).n + " ");
        bw.write("\n");
        bw.flush();
    }

    public static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            workList.add(new Work(t, s, i+1));
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}