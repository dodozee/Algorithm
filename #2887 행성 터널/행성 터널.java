import java.io.*;
import java.util.*;

/**
 * 크루스칼 알고리즘
 * 핵심 : 3차원 좌표로 표현된 각 노드들을 연결하는 최소 비용을 구하는 문제
 * 1.x,y,z 좌표를 각각 오름차순 정렬해서 그 좌표만을 가지고 행성간의 비용을 구함
 * 2.각 행성간의 비용을 구한 후, 크루스칼 알고리즘을 이용하여 최소 비용을 구함
 *
 */
public class Main { //MST - 크루스칼 알고리즘
    static int[] parent;//부모 테이블
    static ArrayList<Edge> edgeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            points[i] = new Point(i, x, y, z);
        }

        edgeList = new ArrayList<>();

        //1. x,y,z 좌표를 각각 오름차순 정렬하고 각 행성의 번호와 비용을 edgeList에 저장
        Arrays.sort(points, (o1, o2) -> o1.x - o2.x);

        for (int i = 0; i < N - 1; i++) {
            int weight = Math.abs(points[i].x - points[i + 1].x);
            edgeList.add(new Edge(points[i].num, points[i + 1].num, weight));
        }

        Arrays.sort(points, (o1, o2) -> o1.y - o2.y);
        for (int i = 0; i < N - 1; i++) {
            int weight = Math.abs(points[i].y - points[i + 1].y);

            edgeList.add(new Edge(points[i].num, points[i + 1].num, weight));
        }

        Arrays.sort(points, (o1, o2) -> o1.z - o2.z);

        for (int i = 0; i < N - 1; i++) {
            int weight = Math.abs(points[i].z - points[i + 1].z);

            edgeList.add(new Edge(points[i].num, points[i + 1].num, weight));
        }

        parent = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;//부모 테이블 상에서 자기 자신을 부모로 설정
        }

        Collections.sort(edgeList);//간선 비용을 기준으로 오름차순 정렬

        int result = 0;

        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);

            //cycle이 발생하지 않는 경우에만 집합에 포함

            if (find(edge.start) != find(edge.end)) {
                result += edge.weight;
                union(edge.start, edge.end);
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]); //재귀적으로 부모를 찾아감
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }
}

class Point{
    int num;
    int x;
    int y;
    int z;

    public Point(int num, int x, int y, int z) {
        this.num = num;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Edge implements Comparable<Edge>{
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight; //오름차순
    }
}

