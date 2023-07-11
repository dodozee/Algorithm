import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!!
    static int MOD = 14579;
    public static void main(String[] args) throws Exception {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int tmp = (a+1)*a/2;
        tmp%=MOD;
        
        int answer = tmp;
        
        for (int i = a+1; i <= b; i++){
            answer*=(tmp+=i);
            answer%=MOD;
        }
        
        System.out.println(answer);
    }
}