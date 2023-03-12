import java.io.*;
import java.util.*;
//코딩 사랑 ..두지
public class Main { //시간 초과되어서 다시 풀었다. 그림으로 그려서 풀어가지고 설명하기 난해하다 최대한 설명해보겠다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken()); 
        int B = Integer.parseInt(st.nextToken()); 
        int V = Integer.parseInt(st.nextToken()); //V가 1억까지 범위길래 순간 Long을 썼는데 int형도 21억까지 가능한 범위였다.
        int i = 1; //첫날은 default 값!
        int S = (V-A)/(A-B); // 마지막 날에 한번에 정상에 뛰어넘을 가능성이 있기때문에 V에서 A를 일단 빼놓고 A-B로 나눈다.S는 몫이자 일 수이다. 
            i = i+S; //첫날 + 몫(일 수) 더해준다.
            V=V-S*(A-B); //몫을 제외한 마지막에 남은 거리를 계산한다.
        for(; i<Long.MAX_VALUE;)
        {
            V=V-A; // 처음에 V=V-(A-B) 했는데 잘못된 답이 계속 나왔다. A-B하면 간편하게 될줄 알았는데 착각이였다.
            // 이유는 달팽이가 낮에 정상에 다 올라갈 수 있는데, 저렇게 코드를 짜면 다올라갔다가 다시 밤에 내려온셈이다.
            if (V >0 ) {
                V = V+B;
                i++;
            }else{break;}
        }
        System.out.println(i);
    }
}
