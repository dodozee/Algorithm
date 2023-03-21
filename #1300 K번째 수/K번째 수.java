import java.io.*;
import java.util.*;
/*      박두지 화이팅!! 갓천대 화이팅!!!
[문제접근]
1.처음에 2차원 배열에 i,j에 해당하는 값을 넣을 수가 없다.메모리 사이즈가 되질 않는다.
2.두수가 곱해진 2차배열에 정리하면 i열은 mid의 몫과 한 열이 이루고 있는 배열의 갯수와 더 작은 수를 비교하여 n열까지 누적하면 Math.min()메서드를 이용하여 작은 값의 누적이 1차배열의 순서입니다.
[주의할 점]
int * int 는 정수형을 초과해서 틀린거같다.
long으로 바꿔보았다.
*/

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long k = Long.parseLong(st.nextToken());
        long left = 1; //배열 A와 B는 인덱스 1부터 시작하므로 left는 1부터 잡으면된다.
        long right = k;

        long result= binarySearch(n,k,left, right);

        System.out.println(result);



    }

    static long binarySearch(Long n, long k,long left, long right){//재귀 함수를 사용하여 이분탐색 구현

        if (left > right) {
            return 0;
        }
        long mid = (left + right) / 2;
        long cnt=0;
        for (int i = 1; i <= n; i++) {
            cnt += Math.min(mid/i, n); //mid 보다 이하인수는 몇개인지 카운트로 센다.
        }
        if (cnt < k) { //cnt가 찾는 k번째보다 작으면 재귀로 더 쪼갠다.
            return binarySearch(n, k, mid + 1, right);
        }else{
            return mid == left ? left : binarySearch(n, k, left, mid); //mid와 같다면 mid를 return 시키고 더 크다면 더 쪼갠다.
        }
    }
}