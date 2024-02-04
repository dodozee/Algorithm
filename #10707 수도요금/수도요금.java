import java.util.*;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt(), b = s.nextInt(), c = s.nextInt(), d = s.nextInt(), p = s.nextInt();
        int x, y;
        x = a * p;
        if(c < p)
            y = b + ((p - c) * d);
        else
            y = b;
        System.out.println(Math.min(x, y));
    }
}