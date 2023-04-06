import java.util.Scanner;

public class Main {//갓천대 화이팅!!! 박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        int copy = n;

        do {
            int sum = copy/10 + copy%10;
            copy = (copy%10)*10 + sum%10;
            count++;
        } while (copy != n);

        System.out.println(count);
    }
}
