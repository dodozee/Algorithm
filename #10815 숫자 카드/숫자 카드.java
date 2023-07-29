import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {//박두지 화이팅!!
    static int N, M;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(binarySearch(num)){
                bw.write("1 ");
            }
            else {
                bw.write("0 ");
            }
        }

        bw.close();
        br.close();
    }
    private static boolean binarySearch(int num) {
        int left = 0;
        int right = N - 1;

        while(left <= right){
            int midIndex = (left + right) / 2;
            int mid = arr[midIndex];

            if(num < mid) right = midIndex - 1;
            else if(num > mid) {
                left = midIndex + 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}