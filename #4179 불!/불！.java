import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {//박두지 화이팅!!!
    static int[][] map, visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        visited = new int[r][c];

        Queue<Node> jQueue = new LinkedList<>();
        Queue<Node> fQueue = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            String t = br.readLine();
            for (int j = 0; j < c; j++) {
                char temp = t.charAt(j);
                if(temp == '#'){
                    map[i][j] = -1;
                }else if(temp == 'J'){
                    jQueue.add(new Node(i, j));
                    visited[i][j] = 1;
                }else if(temp == 'F'){
                    fQueue.add(new Node(i, j));
                    map[i][j] = -2;
                }else{
                    map[i][j] = 0;
                }
            }
        }
        int answer = 0;
        while(true){
            answer++;
            int fs = fQueue.size();
            while(fs>0){
                fs --;
                Node node = fQueue.poll();
                int x = node.x;
                int y = node.y;
                for(int i=0; i<4; i++){
                    if(x+dx[i] > 0 && x+dx[i]< r && y+dy[i] >= 0 && y+dy[i] < c){
                        if(map[x+dx[i]][y+dy[i]] >= 0){
                            map[x+dx[i]][y+dy[i]] = -2;
                            fQueue.add(new Node(x+dx[i], y+dy[i]));
                        }
                    }
                }
            }
            int js = jQueue.size();
            while(js>0){
                js--;
                Node node = jQueue.poll();
                int x = node.x;
                int y = node.y;
                for(int i=0; i<4; i++){
                    if (x + dx[i] < 0 || x + dx[i] >= r || y + dy[i] < 0 || y + dy[i] >= c) {
                        System.out.println(answer);
                        return;
                    }
                    if(map[x+dx[i]][y+dy[i]] == 0 && visited[x+dx[i]][y+dy[i]] == 0){
                        visited[x+dx[i]][y+dy[i]] = 1;
                        jQueue.add(new Node(x+dx[i], y+dy[i]));
                    }
                }
            }
            if(jQueue.isEmpty()){
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
    }
}

class Node{
    int x;
    int y;

    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
