import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int rc=sc.nextInt();
        int rp=sc.nextInt();

        int r=rp/rc;

        int wc=sc.nextInt();
        int wp=r*3*wc;

        System.out.println(wp);
    }
}
