import java.util.Scanner;

public class Main {

    static char star[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        n = 4 * n - 3; 
        star = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                star[i][j] = ' ';
            }
        }

        Star_19(0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(star[i][j]);
            }
            System.out.println();
        }
    }

    public static void Star_19(int s, int len) {
        if (len<=s) return;

        for (int i = s; i < len; i++) {
            star[s][i] = '*'; 
            star[len - 1][i] = '*'; 
            star[i][s] = '*'; 
            star[i][len - 1] = '*'; 
        }


        Star_19(s + 2, len - 2);
    }
}