import java.io.*;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
슈도 코드
1. 1~N 까지 번호가 있는 N장의 카드가 있는데, 1번이 가장 위 번호가 올라갈수록 아래로 쌓이였음
2. 맨 윗장 카드를 버리고 그리고 그 다음 카드를 맨 아래로 옮긴다.-> 큐 자료구조 이용하면 됨.
3. 맨 마지막에 남는 카드를 구하시오.

 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (queue.size() != 1) {
            queue.poll();
            queue.offer(queue.poll());
        }

        System.out.println(queue.poll());
    }
}


