import java.io.*;

public class Main {//2022.4.17 박두지 화이팅!!!
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        compress(0, 0, n);
        System.out.println(sb);
    }

    static void compress(int x, int y, int size) {
        if (isCompressible(x, y, size)) {
            sb.append(arr[x][y]);
            return;
        }

        sb.append("(");
        int newSize = size / 2;
        compress(x, y, newSize);
        compress(x, y + newSize, newSize);
        compress(x + newSize, y, newSize);
        compress(x + newSize, y + newSize, newSize);
        sb.append(")");
    }

    static boolean isCompressible(int x, int y, int size) {
        int color = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
