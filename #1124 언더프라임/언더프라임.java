import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[] prime = new boolean[100001];
        int[] count = new int[100001];
        
        prime[0] = prime[1] = true;
        
        for(int i=2;i<100001;i++){
            if(prime[i]) continue;
            for(int j=i+i;j<100001;j+=i){
                prime[j] = true;
                int tmp = j;
                while(tmp%i==0){
                    tmp/=i;
                    count[j]++;
                }
            }
        }
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int res = 0;
        for(int i=a;i<=b;i++){
            if(!prime[count[i]]) res++;
        }

        System.out.println(res);
    }
}
