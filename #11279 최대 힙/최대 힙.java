import java.util.*;
import java.io.*;
/* 박두지 화이팅!! 갓천대 컴공 화이팅!!
[문제풀이]
1.이 문제는 최대 힙 자료구조를 이용하여 값을 추가하고 삭제하는 문제이다.
2.PriorityQueue 클래스를 사용하여 최대 힙을 구현한다.
3.Comparator를 이용하여 내림차순으로 정렬되는 객체를 생성한다.
4.이후에 0이 입력되면 PriorityQueue에서 가장 큰 값을 poll하여 출력하고, 아니라면 입력된 값을 PriorityQueue에 추가한다.

*/


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        // 내림차순으로 정렬되는 최대 힙
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());

            if (x == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.offer(x);
            }
        }
    }
}
