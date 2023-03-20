import java.io.*;
import java.util.*;
/*      박두지 화이팅!! 갓천대 화이팅!!!
[문제접근]
1.이미 정렬된 카드 두 묶음이 있다. 개수가 각 a개 b개 있으면 총 a+b번을 비교해야한다.
2.카드 더미들도 낮은 카드개수인 더미끼리 합치는게 최소 횟수가 나온다.
3.우선순위 큐로 풀어보자

-예를 들어서 30 40 20 50 10 60 장씩 있으면
[1] 우선 카드 더미도 정렬한다. 10 20 30 40 50 60
[2]  30 40 50 60 (30) : 처음, 그 다음 낮은 두 카드 더미끼리 합침 그리고 뒤로 보낸다.  총 비교횟수 :30번
[3]  50 60 (30) (70) : 처음, 그 다음 낮은 두 카드 더미끼리 합침 그리고 뒤로 보낸다. 총 비교횟수 : 100번
[4]  (30) (70) (110) : 처음, 그 다음 낮은 두 카드 더미끼리 합침 그리고 뒤로 보낸다. 총 비교횟수 : 210번
[5]  (110) (100): 처음, 그 다음 낮은 두 카드 더미끼리 합침  : 총 310번
[6]  (210) : 남은거 두개 합하여 210까지 더하면 : 총 520번
총 520번
이 과정이 우선 순위 큐랑 동일해서 큐로 코드를 짰다.


[주의할 점]
[틀리기 전]
생각보다 너무 쉽게 10분만에 풀려서 뭔가 분명 잘못 푼거같지만 제출해본다.
[틀린 후]
너무 자신만만한게 역시 죄다. 코드를 잘못 짠거같다. 큐로 다시 해보았다.
[또 틀린 후]
사실 데크로 구현했는데 큐로 해야하나싶다 사실 답은 그대로 나오는데...
[처음 안 사실]
Queue랑 PriorityQueue은 서로 다른 것이였다. 큐를 우선순위 큐라고 부르는줄 알았다.
*/

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> queue = new PriorityQueue<>();

        int n = Integer.parseInt(st.nextToken());
        long arr[] = new long[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long sum=0;

        for (int i = 0; i < n; i++) {
            queue.add(arr[i]);
        }

        while(queue.size()>1){
                                //앞에 와 비교해서 큰지 작은지 비교
            long temp1 = queue.poll();//앞에 두개를 더한다.
            long temp2 = queue.poll();

            sum += temp1 + temp2;
            queue.add(temp1+temp2);//뒤로 다시 push 함
        }

        System.out.println(sum);


    }
}


