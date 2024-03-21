import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {//두지 화이팅~
    public static int[] A, tmp;
    public static long result;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        A = new int[N+1];
        tmp = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }



        result = 0;

        merge_sort(1, N);
        System.out.println(result);

    }

    private static void merge_sort(int s, int e) {
        if (e - s < 1) return;

        int m = s+ (e-s) / 2;

        merge_sort(s, m);
        merge_sort(m+1, e);

        for (int i = s; i <= e; i++) {
            tmp[i] = A[i]; // start ~ end 까지 모두 tmp에 복사
        }

        //두 그룹을 병합하는 로직
        int k = s; // k는 s부터 시작
        int index1 = s; // index1은 s부터 시작 -> 앞쪽 그룹 시작점
        int index2 = m + 1; // index2는 m+1부터 시작 -> 뒤쪽 그룹 시작점

        while (index1 <= m && index2 <= e){
            if (tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2]; // 뒤쪽 그룹의 값이 더 작으면 A[k]에 넣어줌
                result = result + index2 -k; // 뒤쪽 그룹의 index2 - 앞쪽 그룹의 k
                k++; // k를 증가시켜줌
                index2++; // index2를 증가시켜줌

            } else{
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }

        // 남은 값들을 넣어주는 로직
        while (index1 <= m){
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        // 남은 값들을 넣어주는 로직
        while (index2 <= e){
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}