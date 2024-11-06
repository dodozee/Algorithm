import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/*

 */
public class Main {

    static Integer[] dp;
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        dp = new Integer[N+1];

        dp[0] = dp[1] = 0;

        System.out.println(recur(N));


    }

    public static int recur(int n) {

        if (dp[n] == null) { //탐색하지 않았은 n이라면
            if (n % 6 == 0) {
                dp[n] = Math.min(recur(n-1), Math.min(recur(n/3), recur(n/2))) + 1;
            } else if (n % 3 == 0) {
                dp[n] = Math.min(recur(n/3), recur(n -1)) + 1;
            } else if (n % 2 == 0) {
                dp[n] = Math.min(recur(n/2), recur(n -1)) + 1;
            }else {
                dp[n] = recur(n-1) + 1;
            }
        }
        return dp[n];
    }


}