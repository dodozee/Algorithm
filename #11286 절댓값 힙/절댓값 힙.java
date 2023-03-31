
import java.util.*;
import java.io.*;
/* 박두지 화이팅!! 갓천대 컴공 화이팅!!
[문제풀이]
1.java에서 절대값 힙을 구현하기 위해서는 PriorityQueue 클래스를 사용해야한다.
2.절대값이 가장 작은 값을 출려하기 위해선 (값, -절대값) 쌍을 힙에 추가한다.
3.람다식으로 절대값 기준으로 우선순위를 정렬하였다.
4.이후에 0이 입력되면 PriorityQueue에서 가장 큰 값을 poll하여 출력하고, 아니라면 입력된 값을 PriorityQueue에 추가한다.

*/
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) ->{ //람다식으로 구현
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            if(absA == absB) return Integer.compare(a, b);//절대값이 만약에 같으면 부호 붙히고 원래 숫자로 비교해서 출력
            return Integer.compare(absA, absB); //절대값이 작은걸 출력
        });

        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            if(x==0) { // 입력되는 값이 0이라면?
                if (pq.isEmpty()) System.out.println(0);// 우선순위 큐가 비어있으면 0 출력
                else System.out.println(pq.poll());
            } else{ //그게 아니라면 우선순위 큐에 넣는다.
                pq.offer(x);
            }
        }
        
    }
}