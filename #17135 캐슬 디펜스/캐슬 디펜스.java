import java.io.*;
import java.util.*;


/**
 *
 */
public class Main {
    static int N, M, D;
    static int[][] map;
    static List<int[]> list;
    static int[] archer;//
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        list = new ArrayList<>(); // 적의 위치 저장
        archer = new int[3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    list.add(new int[] { i, j });//적의 위치 저장
                }
            }
        }

        locateMonster(0, 0);

        System.out.println(result);
    }

    private static void locateMonster(int idx, int start) {
        if (idx == 3) {
            List<int[]> data = copy(list);
            attack(data);
            return;
        }
        for (int i = start; i < M; i++) {
            archer[idx] = i;
            locateMonster(idx + 1, i + 1);
        }
    }

    private static List<int[]> copy(List<int[]> list) {
        List<int[]> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int[] cur = list.get(i);
            temp.add(new int[] { cur[0], cur[1] });
        }

        return temp;
    }

    private static void attack(List<int[]> list) {
        int count = 0;//죽인 적의 수

        while(true){
            if (list.isEmpty()) {
                break;
            }
            List<int[]> targets = new ArrayList<>();//공격할 적의 위치 저장

            for (int i = 0; i < 3; i++) {
                PriorityQueue<Enemy> pq = new PriorityQueue<>();//적의 위치를 저장할 우선순위 큐

                for (int[] cur : list) {
                    int distance = Math.abs(cur[0] - N) + Math.abs(cur[1] - archer[i]);
                    if (distance <= D) {
                        pq.add(new Enemy(cur[0], cur[1], distance));
                    }
                }

                if (!pq.isEmpty()) {//적이 있으면
                    Enemy target = pq.poll();
                    boolean flag = false;

                    for (int j = 0; j < targets.size(); j++) {
                        int[] cur2 = targets.get(j);
                        if (target.x == cur2[0] && target.y == cur2[1]) {
                            flag = true;
                        }
                    }

                    if (!flag) {
                        targets.add(new int[] { target.x, target.y });
                    }

                }
            }
            for (int i = 0; i < targets.size(); i++) {
                for (int j = list.size() - 1; j >= 0; j--) {
                    if(targets.get(i)[0] == list.get(j)[0] && targets.get(i)[1] == list.get(j)[1]) {
                        list.remove(j);
                        count++;
                        break;
                    }
                }
            }

            for (int i = list.size() - 1; i >= 0; i--) {
                list.get(i)[0]++;
                if (list.get(i)[0] == N) {
                    list.remove(i);
                }

            }

            result = Math.max(result, count);
        }
    }
}

class Enemy implements Comparable<Enemy> {

    int x;
    int y;
    int distance;

    public Enemy(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    @Override
    public int compareTo(Enemy o) {
        if (this.distance == o.distance) {
            return this.y - o.y;//y가 작은 순서대로
        } else {
            return this.distance - o.distance;//거리가 작은 순서대로
        }
    }
}