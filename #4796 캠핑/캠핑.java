import java.util.Scanner;

public class Main {//박두지 화이팅@@~~
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNumber = 0;

        while (true) {
            int L = scanner.nextInt();
            int P = scanner.nextInt();
            int V = scanner.nextInt();

            if (L == 0 && P == 0 && V == 0) {
                break;
            }

            int result = solve(L, P, V);
            caseNumber++;

            System.out.println("Case " + caseNumber + ": " + result);
        }

        scanner.close();
    }

    private static int solve(int L, int P, int V) {
        int result = 0;

        result += (V / P) * L;

        result += Math.min(V % P, L);

        return result;
    }
}
