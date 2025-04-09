import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        int maxKill = 0;
        int killCount = 0;

        for (int i = 0; i < n; i++) {
            killCount = 0;
            for (int j = i + 1; j < n; j++) {
                if (heights[i] > heights[j]) {
                    killCount++;
                    maxKill = Math.max(maxKill, killCount);
                } else {
                    break;
                }
            }
        }

        System.out.println(maxKill);
    }
}
