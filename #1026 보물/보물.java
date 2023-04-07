import java.io.*;
import java.util.*;

public class Main {/* 박두지 화이팅!! 갓천대 화이팅!!
    [문제 풀이]
    1.정수형 배열 a,b를 입력받는다.
    2.a,b를 오름차순으로 정렬한다.
    3.a의 최소의 원소와 b의 최대의 원소를 for문을 돌리며 곱하고 result에 저정한다.
    4.result를 출력.
    */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int[] b = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);//a를 오름차순으로 정렬
        Arrays.sort(b);//b를 오름차순으로 정렬

        int result = 0;

        for (int i = 0; i < n; i++) {
            result += a[i]*b[n-1-i]  ; //a의 최소와 b의 최대부터 곱해서 result에 더함
        }

        System.out.println(result); //결과 출력.

        br.close();
    }
}

