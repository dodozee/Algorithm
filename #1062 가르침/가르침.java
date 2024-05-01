import java.io.*;
import java.sql.Array;
import java.util.*;


/**
 * 되도록 많은 단어를 학생들한테 가르치고 싶어한다.
 * 그러나, 학생들이 단어를 외우는데에는 한계가 있다.
 * K개의 글자를 가르칠 시간 밖에 없다.
 *
 */
public class Main {
    static int N, K;
    static int max = Integer.MIN_VALUE;
    static boolean[] visited;
    static String[] words;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            str = str.replace("anta", "");
            str = str.replace("tica", "");
            words[i] = str;
        }

        if(K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        visited = new boolean[26];
        visited[0] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        bt(0, 0);
        System.out.println(max);
    }

    private static void bt(int alpha, int len) {
        if (len == K - 5) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                boolean flag = true;
                for (int j = 0; j < words[i].length(); j++) {
                    if (!visited[words[i].charAt(j) - 'a']) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    count++;
                }
            }
            max = Math.max(max, count);
            return;
        }

        for (int i = alpha; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                bt(i, len + 1);
                visited[i] = false;
            }
        }
    }
}