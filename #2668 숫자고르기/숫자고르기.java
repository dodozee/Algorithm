import java.util.*;

public class Main {//박두지 화이팅!!
    static ArrayList<Integer> cycleList;
    static boolean[] visited;
    static int[] numbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        numbers = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            numbers[i] = scanner.nextInt();
        }

        cycleList = new ArrayList<>();
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(cycleList);
        System.out.println(cycleList.size());
        for (int i = 0; i < cycleList.size(); i++) {
            System.out.println(cycleList.get(i));
        }
    }

    public static void dfs(int start, int target) {
        if (!visited[numbers[start]]) {
            visited[numbers[start]] = true;
            dfs(numbers[start], target);
            visited[numbers[start]] = false;
        }
        if (numbers[start] == target) {
            cycleList.add(target);
        }
    }
}
