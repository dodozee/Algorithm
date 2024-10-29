
import java.io.*;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
분석
1. 배열에 정수를 넣는다(0 제외, 0은 출력하는 용도)
2. 배열에서 '절댓값'이 가장 작은 값을 출력한 후 그 값을 배열에서 제거. 만약 배열에서 절댓값이 작은 값이 작은 값이 여러개 일경우 그 중 가장 작은 값을 출력하고 배열에서 제거.
3. 배열이 비어있을 때까지 2번을 반복한다.
자료구조는 절댓값 힙을 구현할 수 있는 우선순위 큐를 사용하면 될듯.

 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if (first_abs == second_abs) {
                return o1 > o2 ? 1 : -1;
            } else {
                return first_abs - second_abs;
            }
        });

        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.add(num);
            }
        }

    }
}


