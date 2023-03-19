import java.io.*;
import java.util.*;
/*      박두지 화이팅!! 갓천대 화이팅!!!

        처음에 while(sb.length() < n-1) 이 부분에서 while(sb.length() < n) 이렇게 했었다.
        그렇게하니 sb.append()가 while문 들어오고나서 실행이되고 모든게 true인 상태라서

     while (move-- > 0) { // 한칸씩 줄어들면서 이동 거리만큼 반복
                    current = current == n ? 1 : current + 1; // 원형 구조이다. n 번호 오른쪽은 1이다.
                    if (popped[current]) { // 이미 터진 풍선이면
                        move++; // 다시 한 칸 뒤로 가야 함
                    }
                }

               여기서 무한루프로 갇히게 되었다.
               이동한 곳이 이미 터진 풍선이면 move가 ++되는데
               또 한 루프 돌때마다 move--되고
               그거때문에 2시간정도 걸렸다.
               여태 잘 사용하지않던 디버깅 모드가 생각나
               디버깅모드로 하나하나씩 코드를 해석해보여 읽어보니
               어디가 문제인지 금방 알았다.

 */

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 풍선의 개수

        int[] balloons = new int[n+1]; // 풍선 안의 숫자를 저장할 배열
        boolean[] popped = new boolean[n+1]; // 이미 터진 풍선인지 저장할 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            balloons[i] = Integer.parseInt(st.nextToken());
        }

        int current = 1; // 젤 처음 터트리는 풍선이자 현재 위치

        ArrayList<Integer> list = new ArrayList<>(); //터진 순서대로 저장할 리스트 선언
        while (list.size() <n-1) { // 터지지 않은 풍선이 없을 때까지 반복
            list.add(current); // 현재 위치를 리스트에 추가

            popped[current] = true; // 현재 위치의 풍선을 터뜨린다.

            int move = balloons[current]; // 이동할 거리
            if (move > 0) { // 양수이면 오른쪽으로 이동
                while (move-- > 0) { // 한칸씩 줄어들면서 이동 거리만큼 반복
                    current = current == n ? 1 : current + 1; // 원형 구조이다. n 번호 오른쪽은 1이다.
                    if (popped[current]) { // 이미 터진 풍선이면
                        move++; // 다시 한 칸 뒤로 가야 함
                    }
                }
            }else{ // 음수이면 왼쪽으로 이동
                while (move++ < 0) { // 이동 거리의 절댓값만큼 반복
                    current = current == 1 ? n : current - 1; // 원형 구조를 고려하여 이동
                    if (popped[current]) { // 이미 터진 풍선이면
                        move--; // 다시 한 칸 뒤로 가야 함
                    }
                }
            }
        }
        list.add(current); // 현재 위치를 리스트에 추가

        for(int i : list)
            {
            System.out.print(i +" ");
            }
    }
}
