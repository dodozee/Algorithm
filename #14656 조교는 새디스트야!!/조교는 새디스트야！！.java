import java.util.*;
public class Main {//박두지 화이팅!!
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        int cnt=0;
        for(int i=1;i<=n;i++){
            int a=s.nextInt();
            if(a!=i) cnt++;
        }
        System.out.print(cnt);
    }
}