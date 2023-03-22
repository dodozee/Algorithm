import java.io.*;
import java.util.*;
/*      박두지 화이팅!! 갓천대 화이팅!!!

[문제접근 및 해석]
1. 버블 정렬로 풀면 시간초과 및 메모리 초과가 되버린다.
2. 정말 쉽게 말해서 이 문제의 의도는 정렬이 다될때는 == 정렬 다되었을때 그 다음 외부 for문이 돌고 있던 i를 묻는 것이다.
3. 쉽게 말해서 몇 루프때 정렬이 다되었는지 궁금한것이다.
4. 1번에 말했듯 실제로 버블정렬을 돌려버리면 초과가 나버린다.
5. 버블 정렬의 원리를 이해하면 쉽게 풀린다.
6. 버블 정렬은 맨 앞에 시작하는 배열 arr[i]번 요소부터 시작하여 a[i+1]과 대소비교를하고 오름차순 기준으로 a[i]가 크면 a[i+1]과 자리를 바꾼다.
7. 이 말은 즉, 정렬이 되기 전 원본 배열과 정렬이 되고 난 후 배열과 비교를 하면 알 수 있다.
8. 바뀌기 전,후의 이동한 숫자끼리 인덱스를 비교하기 위해서는 정렬을 해야하는데 정렬을 하려면 
9. Arrays.sort() 클래스의 정적 메서드를 사용하면 되는데, 값과 인덱스 둘다 담고 있는 Data 객체를 비교하려면 손을 봐줘야한다.
10. Arrays.sort()는 Compareable 인터페이스를 구현하여 정렬을 하는데 우리가 임의대로 정렬 기준을 바꿔주면된다.
11. Data클래스를 만들당시 Compareable를 구현하고 이 인터페이스가 갖고 있는 compareTo를 오버라이딩 해준다.
12. 비교할 때 스왑이 된다면 오른쪽에 있는 요소는 왼쪽으로 딱 -1칸 되고 왼쪽에 있는 큰 놈은 어디까지 갈진모르지만 오른쪽으로 끝까지 갈 수 있다.
13. 전, 후 비교했을때 배열 이동에서 가장 왼쪽으로 멀리간 녀석을 찾아서 몇 바퀴 루프 돈지 알 수 있다.
14. 가장 많이 이동한 칸의 수 +1을 해줘야한다. 왜냐면 정렬이 다되고 그 다음의 턴에 changed 가 true되지 않고 false가 끝까지 가기때문이다.

[주의할 점 & 느낀점]
1. 문제의 의도를 파악하기전까지 거의 1시간정도 소요한거같다.
2. 의도를 알자말자 수월하게 완벽하게 이해하고 풀었다.
*/

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

            Data[] arr = new Data[n]; // Comparable 인터페이스를 구현한 Data 클래스 객체를 담을 배열 생성
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i] = new Data(Integer.parseInt(st.nextToken()), i); //Data 객체 생성과 초기화 그리고 배열에 담기
            }
            Arrays.sort(arr); //value기준으로 정렬 한다.
            int max = 0; //제일 많이 이동한 인스턴스를 찾는 중!

            for (int i = 0; i < n; i++) {
                if (max < arr[i].index - i) { // 원래 갖고 있는 인스턴스와 지금 정렬 후 몇번쨰 있는지 차이를 구한다!
                    max = arr[i].index - i; 
                }
            }
            System.out.println(max + 1);//가장 많이 이동한 칸의 수 +1을 해줘야한다. 왜냐면 정렬이 다되고 그 다음의 턴에 changed 가 true되지 않고 false가 끝까지 가기때문이다.

    }
}
class Data implements Comparable<Data>
{
    int value;
    int index;

    public Data(int value, int index) { //Data 객체를 생성할 때 value와 index값을 받아서 초기화한다.
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Data o) { //compareTo 메서드 구현
        return this.value - o.value;
    }
}
