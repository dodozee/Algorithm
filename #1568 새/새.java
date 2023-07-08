import java.util.*;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int time = 1;
        int count = 0;

        while (n >= 1) {
            if (n < time) {
                time = 1;
            }
            n -= time;
            time++;
            count++;
        }

        System.out.println(count);
        
    }
}
