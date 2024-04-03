import java.io.*;
import java.util.*;

class Emoticon{

    int clipboard;
    int display;
    int time;

    public Emoticon(int clipboard, int display, int time) {
        this.clipboard = clipboard;
        this.display = display;
        this.time = time;
    }
}
public class Main { //bfs를 활용하여 품. 리얼포스 R3로 처음 푼 문제
    static int s;
    static boolean[][] visited = new boolean[2001][2001];
    static Queue<Emoticon> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//출력
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());

        bfs(new Emoticon(0, 1, 0));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(Emoticon start) {
        queue.add(start);

        while (!queue.isEmpty()) {
            start = queue.poll();
            if (start.display == s) {
                sb.append(start.time);
                break;
            }

            if (!visited[start.display][start.display]) {
                visited[start.display][start.display] = true;
                queue.add(new Emoticon(start.display, start.display, start.time + 1));


            }

            if (start.clipboard != 0 && start.display + start.clipboard <= 2000) {
                if (!visited[start.display + start.clipboard][start.clipboard]) {
                    visited[start.display + start.clipboard][start.clipboard] = true;
                    queue.add(new Emoticon(start.clipboard, start.display + start.clipboard, start.time + 1));
                }
            }


            if (start.display > 0) {
                if (!visited[start.display - 1][start.clipboard]){
                    visited[start.display-1][start.clipboard] = true;
                    queue.add(new Emoticon(start.clipboard, start.display -1 , start.time + 1));
                }

            }

        }
    }
}

