import java.io.*;
import java.util.*;

public class Main {//갓천대 컴공 화이팅!! 박두지 화이팅!!!
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] A = new int[n][2]; //원본 배열 [값][인덱스]
        int[] B = new int[n]; //가공뒤 담을 배열

        st = new StringTokenizer(br.readLine());
        String[] temp = new String[n];
        for (int i = 0; i < n; i++) {
            temp[i] = st.nextToken();
        }

        for (int i = 0; i < n; i++) {
            A[i][0] = Integer.parseInt(temp[i]);
            A[i][1] = i;
        }

        sort(A);
        for (int i = 0; i < n; i++) {
            int idx = A[i][1];

            B[idx] = i; //배열을 담는다.
        }

        for (int b : B) {
            System.out.print(b + " ");
        }
    }

    static void sort(int[][] A)   { //직접 오버라이팅 한다.
        Arrays.sort(A, (next, curr)-> {

                if(next[0] < curr[0]) { // 현재값이 더 큰 경우
                    return -1;
                }
                else if (next[0] > curr[0]) { // 다음값이 더 큰 경우
                    return 1;
                } else return Integer.compare(next[1], curr[1]); //값이 같은 경우, 사전순으로 정렬한다
                });

              

    }
}
