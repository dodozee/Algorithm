import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);
    }

    private static void DFS(int number, int jarisu) {
        if(jarisu ==N){
            if(isPrime(number)){
                System.out.println(number);
            }
            return;
        }
        for(int i=1; i < 10; i+=2){
            int next = number*10+i;
            if(isPrime(next)){
                DFS(next, jarisu+1);
            }
        }
    }

    private static boolean isPrime(int number) {//소수인지 판별
        for (int i = 2; i <= number/2; i++) {
            if(number%i==0){
                return false;
            }
        }
        return true;

    }
}