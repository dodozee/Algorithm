
import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/*
분석

 */
public class Main {

    static int[] parents;
    static int[] rank;
    static int size = 100001;
    public static void main(String[] args) throws IOException, InterruptedException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      StringBuilder sb = new StringBuilder();
      int t = Integer.parseInt(br.readLine());

      Map<String, Integer> map = new HashMap<>();

        while (t-- > 0) {
                int f = Integer.parseInt(br.readLine());

                parents = new int[size * 2];
                rank = new int[size * 2];

                for (int i = 1; i < size * 2; i++) {
                    parents[i] = i;
                    rank[i] = 1;
                }

                int index = 1;
                for (int i = 0; i < f; i++) {
                    String line = br.readLine();
                    st = new StringTokenizer(line);
                    for(int j = 0; j < 2; j++) {
                        String name = st.nextToken();
                        if (!map.containsKey(name)) {

                            map.put(name, index++);
                        }
                    }
                    String[] network = line.split(" ");

                    int a = map.get(network[0]);
                    int b = map.get(network[1]);
                    int num = union(a, b);
                    sb.append(num).append("\n");
                }
            }
            System.out.println(sb);
        }

    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return find(parents[x]);

    }

    static int union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x > y) { //y가 부모
                parents[x] = y;
                rank[y] += rank[x];//y의 랭크에 x의 랭크를 더해준다.
                return rank[y];
            } else { //x가 부모
                parents[y] = x;
                rank[x] += rank[y];
                return rank[x];

            }
        }
        return rank[x];
    }

}