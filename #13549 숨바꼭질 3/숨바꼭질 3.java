import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!
    static class Location {
        int index;
        int time;

        public Location(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int startLocation = Integer.parseInt(inputs[0]); // 수빈의 위치
        int targetLocation = Integer.parseInt(inputs[1]); // 동생의 위치

        int[] visited = new int[100001];

        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(startLocation, 1));
        visited[startLocation] = 1;

        while (!queue.isEmpty()) {
            Location current = queue.poll();

            if (current.index + 1 >= 0 && current.index + 1 <= 100000) {
                if (visited[current.index + 1] == 0 || visited[current.index + 1] > current.time + 1) {
                    visited[current.index + 1] = current.time + 1;
                    queue.add(new Location(current.index + 1, current.time + 1));
                }
            }

            if (current.index - 1 >= 0 && current.index - 1 <= 100000) {
                if (visited[current.index - 1] == 0 || visited[current.index - 1] > current.time + 1) {
                    visited[current.index - 1] = current.time + 1;
                    queue.add(new Location(current.index - 1, current.time + 1));
                }
            }

            if (current.index * 2 >= 0 && current.index * 2 <= 100000) {
                if (visited[current.index * 2] == 0 || visited[current.index * 2] > current.time) {
                    visited[current.index * 2] = current.time;
                    queue.add(new Location(current.index * 2, current.time));
                }
            }
        }

        System.out.println(visited[targetLocation] - 1);
    }
}
