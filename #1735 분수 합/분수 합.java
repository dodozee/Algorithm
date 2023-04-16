import java.util.*;
import java.io.*;


public class Main { //박두지 화이팅!!! 갓천대 화이팅!!!
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int momNum = b1 * b2; //분모
        int sonNum = a1 * b2 + a2 * b1;// 분자

        int gcd = gcd(sonNum, momNum);
        System.out.println(sonNum / gcd + " " + momNum / gcd);
    }

    private static int gcd(int a, int b) { //최소공약수 구하는 메서드
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}