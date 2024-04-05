import java.io.*;
import java.util.*;

/**
 * greedy algorithm 알고리즘 + priority queue를 사용
 * 주의할 점 : 양수일 경우 -> 절댓값이 큰 수들 순서대로 묶어서 더하기(단, 1은 묶지 않음: 이유는 1은 곱하는 것보다 더하는게 더 크기 때문)
 *           음수 일 경우 -> 절댓값이 큰 수들 순서대로 묶어서 더하기
 *           0이 있을 경우 -> 0은 묶지 않음
 * 하지만 실제로는 0을 코드상 신경 쓰지 않아도 됨 이유는 마이너스와 곱하여 사라지거나 0끼리 묶여서 사라지게되어서 결국 최대로 높은 수가 나옴
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());//양수
        PriorityQueue<Integer> negative = new PriorityQueue<>();//음수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (num > 0) {
                positive.add(num);
            }else{
                negative.add(num);
            }
        }
        int answer = getSum(positive) + getSum(negative);
        System.out.println(answer);
    }

    private static int getSum(PriorityQueue<Integer> pq) {
        Queue<Integer> queue = new LinkedList<>();

        while (!pq.isEmpty()) {
            int current = pq.poll();

            if (pq.isEmpty()) {
                queue.add(current);
            }else{
                int next = pq.poll();
                if (current == 1 || next == 1) {
                    queue.add(current);
                    queue.add(next);
                }else{
                    queue.add(current * next);
                }
            }
        }
        int result = 0;
        while (!queue.isEmpty()) {
            result += queue.poll();
        }
        return result;
    }
}