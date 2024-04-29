import java.io.*;
import java.sql.Array;
import java.util.*;


/**
 * dfs를 활용한 backtracking problem
 */
public class Main {
    static int n;
    static boolean[] visited;
    static String[] arr;
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = br.readLine().split(" ");

        visited = new boolean[10];

        dfs(0, "");

        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }

    private static void dfs(int idx, String num) {
        if (idx == n + 1) {
            list.add(num);
            return;
        }
        // 0~9
        for (int i = 0; i <= 9; i++) {
            if (visited[i]) {
                continue;
            }

            if (idx == 0 || check(Character.getNumericValue(num.charAt(idx - 1)), i, arr[idx - 1])) {
                visited[i] = true;
                dfs(idx + 1, num + i);
                visited[i] = false;
            }
        }
    }

    private static boolean check(int a, int b, String op){
        if (op.equals(">")) {
            return a > b;
        } else if (op.equals("<")) {
            return a < b;
        }
        return true;
    }
}