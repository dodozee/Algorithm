import java.io.*;

public class Main {
    static int n;
    static int[] in, post, pre;
    static int index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        in = new int[n];
        post = new int[n];
        pre = new int[n];

        String[] sarr = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(sarr[i]);
        }

        sarr = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            post[i] = Integer.parseInt(sarr[i]);
        }

        getPreOrder(0, n - 1, 0, n - 1);

        for (int n : pre) {
            bw.write(n + " ");

        }

        bw.flush();
    }

    public static void getPreOrder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart <= inEnd && postStart <= postEnd) {
            pre[index++] = post[postEnd]; // 포스트 오더의 가장 오른쪽은 루트이다.

            int pos = inStart;

            for (int i = inStart; i <= inEnd; i++) {
                if (in[i] == post[postEnd]) {
                    pos = i;
                    break;
                }
            }


            getPreOrder(inStart, pos - 1, postStart, postStart + pos - inStart - 1);
            getPreOrder(pos + 1, inEnd, postStart + pos - inStart, postEnd - 1);
        }
    }

}
