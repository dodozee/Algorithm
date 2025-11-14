import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static long[] dp = new long[300001];
    static long[] dd = new long[300001];
    static long nPaint, s;
    static ArrayList<Paint> arrPaint = new ArrayList<>();

    static class Paint implements Comparable<Paint> {
        int height, price;

        Paint(int a, int b) {
            height = a;
            price = b;
        }

        @Override
        public int compareTo(Paint o) {
            if (this.height == o.height)
                return -Integer.compare(this.price, o.price);

            return Integer.compare(this.height, o.height);
        }
    }

    public static long pL(String s) {
        return Long.parseLong(s);
    }

    public static int pI(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        nPaint = pL(st.nextToken()); s = pL(st.nextToken());

        arrPaint.add(new Paint(0, 0));

        for (int i = 0; i < nPaint; i++) {
            st = new StringTokenizer(br.readLine());
            int a = pI(st.nextToken()), b = pI(st.nextToken());
            arrPaint.add(new Paint(a, b));
        }

        Collections.sort(arrPaint);

        for (int i = 1; i <= nPaint; i++) {
            if (arrPaint.get(i).height < s) continue;

            for (dd[i] = dd[i - 1]; dd[i] < i; dd[i]++) {
                if (arrPaint.get(i).height - arrPaint.get((int) dd[i]).height < s)
                    break;
            }
            dd[i]--;
        }

        for (int i = 1; i <= nPaint; i++) {
            dp[i] = arrPaint.get(i).price + dp[(int)dd[i]];
            dp[i] = Math.max(dp[i], dp[i-1]);
        }

        bw.write(dp[(int)nPaint] + "\n");
        bw.flush();
    }
}