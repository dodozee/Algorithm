import java.util.*;
import java.io.*;

public class Main{//박두지 화이팅!!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[1000001];//방문 여부를 위한 체크 배열
        Queue<Integer> queue = new LinkedList<>(); //탐색을 위한 큐
        queue.offer(n); //시작 위치를 큐에 추가
        visited[n] = true;

        int time = 0;

        boolean found = false;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int cur = queue.poll();//큐에서 현재 위치를 꺼냄

                if (cur == k) {
                    found = true;//동생 위치를 찾으면 표시하고 탈출
                    break;
                }

                if (cur - 1 >= 0 && !visited[cur - 1]) {
                    queue.offer(cur - 1);
                    visited[cur - 1] = true;
                }

                if (cur + 1 <= 100000 && !visited[cur + 1]) {
                    queue.offer(cur + 1);
                    visited[cur + 1] = true;
                }

                if (cur * 2 <= 100000 && !visited[cur * 2]) {
                    queue.offer(cur * 2);
                    visited[cur * 2] = true;
                }

            }
            if(found){
                break;
            }
            time++;
        }

        System.out.println(time);//총 몇 초 걸렸는지 출력

    }


}