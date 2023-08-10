import java.util.Scanner;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int secondLargest;

        if ((A >= B && A <= C) || (A <= B && A >= C)) {
            secondLargest = A;
        } else if ((B >= A && B <= C) || (B <= A && B >= C)) {
            secondLargest = B;
        } else {
            secondLargest = C;
        }

        System.out.println(secondLargest);

        sc.close();
    }
}
