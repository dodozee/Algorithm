import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner s=new Scanner(System.in);
        int c=s.nextInt();
        int k=s.nextInt();
        int p=s.nextInt();
        int ans=0;
        for(int i=1;i<=c;i++){
            ans+=k*i+p*i*i;
        }
        
        System.out.println(ans);
    }
}