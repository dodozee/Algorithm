import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/*
분석

 */
public class Main {
    static int[][] map;
    static int row_len, column_len;

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[101][101];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        row_len = 3;
        column_len = 3;

        int result = -1;
        int count = 0; // 100번을 넘어가면 -1을 출력

        while (count <= 100) {
            if (map[r - 1][c - 1] == k) {
                result = count;
                break;
            }
            if (row_len >= column_len) {
                R();
            }else{
                C();
            }

            count++;
        }
        System.out.println(result);

    }
    private static void R() {
        int[][] mapCopy = new int[101][101];
        int col = 0;

        for (int i = 0; i < row_len; i++) {
            HashMap<Integer,Integer> hashMap = new HashMap<>();

            for (int j = 0; j < column_len; j++) {
                if (map[i][j] == 0)
                    continue;

                if (hashMap.containsKey(map[i][j])) {
                    hashMap.put(map[i][j], hashMap.get(map[i][j]) + 1);
                } else {
                    hashMap.put(map[i][j], 1);
                }
            }
            ArrayList<Node> list = new ArrayList<>();

            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                list.add(new Node(entry.getKey(), entry.getValue()));
            }

            col = Math.max(col, list.size() * 2);
            Collections.sort(list);

            for (int p = 0; p < list.size(); p++) {
                if (p >= 50) {
                    break;
                }
                Node node = list.get(p);
                mapCopy[i][p * 2] = node.num;
                mapCopy[i][p * 2 + 1] = node.count;
            }
        }
        column_len = Math.min(99, col);
        map = mapCopy;
    }

    private static void C() {
        int[][] mapCopy = new int[101][101];
        int row = 0;
        for (int j = 0; j < column_len; j++) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < row_len; i++) {
                if (map[i][j] == 0) {
                    continue;
                }
                if (hashMap.containsKey(map[i][j])) {
                    hashMap.put(map[i][j], hashMap.get(map[i][j]) + 1);
                } else {
                    hashMap.put(map[i][j], 1);
                }

            }
            ArrayList<Node> list = new ArrayList<>();

            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                list.add(new Node(entry.getKey(), entry.getValue()));//key : 숫자, value : 개수
            }

            row = Math.max(row, list.size() * 2); // 최대값을 구하는 이유는 최대값을 기준으로 다음 행의 길이를 결정하기 위함
            Collections.sort(list);

            for (int p = 0; p < list.size(); p++) {
                if (p >= 50) { //50을 넘어가면 50까지만 저장
                    break;
                }
                Node node = list.get(p);
                mapCopy[p * 2][j] = node.num;
                mapCopy[p * 2 + 1][j] = node.count;
            }

        }
        row_len = Math.min(99, row);
        map = mapCopy;
    }
}

class Node implements Comparable<Node> {
    int num;
    int count;

    public Node(int num, int count) {
        this.num = num;
        this.count = count;
    }

    @Override
    public int compareTo(Node node) {
        if (this.count == node.count) {
            return this.num - node.num;
        }
        return this.count - node.count;
    }
}