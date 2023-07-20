import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cookiePrice = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        int currentMoney = Integer.parseInt(st.nextToken());

        int requiredMoney =  cookiePrice * num -currentMoney;

        if (requiredMoney < 0) {
            requiredMoney = 0;
        }

        System.out.println(requiredMoney);
        
    }
}
