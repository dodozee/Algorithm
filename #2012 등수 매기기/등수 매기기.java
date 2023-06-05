import java.util.*;

public class Main{//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] expectedRanks = new int[N];

        for (int i = 0; i < N; i++) {
            expectedRanks[i] = s.nextInt();
        }

        Arrays.sort(expectedRanks);
        
        
        long dissatisfaction = 0; //불만족도의 총 합을 저장할 변수

        for (int i = 0; i < N; i++) {
            dissatisfaction += Math.abs(expectedRanks[i] - (i + 1));
            
        }

        System.out.println(dissatisfaction);
    }
}