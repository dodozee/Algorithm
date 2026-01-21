import java.io.*;
import java.util.*;

public class Main {
    // Fast scanner
    private static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = readByte();
            } while (c <= ' ' && c != -1);

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = readByte();
            }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int N = fs.nextInt();
        int M = fs.nextInt();

        long sum = 0;
        long maxCost = 0;

        for (int i = 0; i < M; i++) {
            int A = fs.nextInt();
            int B = fs.nextInt(); // 문제에서 주어지지만 계산엔 필요 없음 (A+B=2N)
            long cost = Math.max(0, N - A);
            sum += cost;
            if (cost > maxCost) maxCost = cost;
        }

        long answer = sum - maxCost; // 한 장 포기(가장 비싼 카드)
        System.out.println(answer);
    }
}
