import java.util.Scanner;

public class Main {// 박두지 화이팅!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int[] heights = new int[N];
        
        for (int i = 0; i < N; i++) {
            heights[i] = scanner.nextInt();
        }
        
        int maxUpHill = 0;
        int currentUpHill = 0;
        
        for (int i = 1; i < N; i++) {
            if (heights[i] > heights[i - 1]) {
                currentUpHill += heights[i] - heights[i - 1];
            } else {
                if (currentUpHill > maxUpHill) {
                    maxUpHill = currentUpHill;
                }
                currentUpHill = 0;
            }
        }
        
        if (currentUpHill > maxUpHill) {
            maxUpHill = currentUpHill;
        }
        
        System.out.println(maxUpHill);
        
        scanner.close();
    }
}
