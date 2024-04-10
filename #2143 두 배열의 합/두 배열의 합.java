import java.io.*;
import java.util.*;

import static java.util.Arrays.stream;

/**
 * 이분탐색 + 누적합
 *
 */
public class Main {
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력

        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        //
        A = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int M = Integer.parseInt(br.readLine());
        B = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayList<Integer> accumA = new ArrayList<>();
        ArrayList<Integer> accumB = new ArrayList<>();

        //부배열 구하기
        for (int i = 0; i < N; i++) {
            int sum  = 0;
            for (int j = i; j < N; j++) {
                sum += A[j];
                accumA.add(sum);
            }
        }

        for (int i = 0; i < M; i++) {
            int sum = 0;
            for (int j = i; j < M; j++) {
                sum += B[j];
                accumB.add(sum);
            }
        }

        //정렬
        Collections.sort(accumA);
        Collections.sort(accumB);

        //이중배열 투포인터
        int aSize = accumA.size();
        int bSize = accumB.size();

        long cnt = 0;
        int leftPointer = 0;
        int rightPointer = bSize - 1;


        while (leftPointer < aSize && rightPointer >= 0) {
            int sum = accumA.get(leftPointer) + accumB.get(rightPointer);

            if (sum == T) {
                int a = accumA.get(leftPointer);
                int b = accumB.get(rightPointer);
                long aCnt = 0;
                long bCnt = 0;

                while (leftPointer < aSize && accumA.get(leftPointer) == a) {
                    aCnt++;
                    leftPointer++;
                }

                while (rightPointer >= 0 && accumB.get(rightPointer) == b) {
                    bCnt++;
                    rightPointer--;
                }
                
                cnt += aCnt * bCnt;
            } else if (sum > T) {
                rightPointer--;
            } else {
                leftPointer++;
            }


        }
        System.out.println(cnt);
        
    }
}
