import java.io.*;
import java.util.*;

class Main {
    
    static int m;
    static int n;
    static long[] dots;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dots = new long[n];
        s = br.readLine();
        st = new StringTokenizer(s, " ");

        for (int i = 0; i < n; i++) {
            dots[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(dots);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            s = br.readLine();
            st = new StringTokenizer(s, " ");
            int result = binarySearch(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            sb.append(result).append('\n');
        }

        System.out.println(sb.toString().trim());

    }

    static int binarySearch(int x, int y) {
        int left = 0;
        int right = dots.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (dots[mid] > y) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        int endIndex = right + 1;

        left = 0;
        right = dots.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (dots[mid] < x) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        int startIndex = left;

        return endIndex - startIndex;
    }

}