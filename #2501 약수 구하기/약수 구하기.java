
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {//두지 코더 화이팅!! 갓천대 컴공 화이팅!!
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                list.add(i);
            }
        }
        if(list.size() < y) { // list 사이즈보다 y번째가 작으면 없다는 뜻이다.
            System.out.println(0);
        }else{ //그게 아니라면 y번째가 나온다.
            System.out.println(list.get(y-1)); //list는 index 0부터 add되기 때문에 -1 해줘야한다.
        }
        
    }

}