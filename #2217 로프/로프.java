import java.io.*;
import java.util.*;

public class Main{//박두지 화이팅 ㅎㅎ!!
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        int[] ropes = new int[N];

        for (int i = 0; i < N; i++) {
            ropes[i] = s.nextInt();
        }

        Arrays.sort(ropes);//내림차순으로 정렬

        int maxWeight = 0;

        for (int i = 0; i < N; i++) {
            int weight = ropes[i] * (N - i);

            if (weight > maxWeight) {
                maxWeight = weight;
            }
        }
        System.out.println(maxWeight);

    }
}