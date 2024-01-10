import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {//박두지 화이팅
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(a);
        arr.add(b);
        arr.add(c);
        Collections.sort(arr);
        System.out.println(arr.get(1));
    }
}