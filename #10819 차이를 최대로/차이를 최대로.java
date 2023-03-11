import java.io.*;
import java.util.Arrays;


public class Main { //나라사랑 가천사랑 동기사랑 !!!화티잉!!!!!!
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr1;
        Integer[] arr2 = new Integer[n];
        String str = br.readLine();

        arr1 = str.split(" "); //문자열 입력 받은거 빈칸 기준으로 하나씩 쪼갠다!!!

        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = Integer.parseInt(arr1[i]); //쪼갠 문자를 숫자형으로 바꾼다!
        }

//        for (int i = 0; i < arr2.length; i++) { 로그용도로 출력함!
//            System.out.println(arr2[i]);
//        }
        Arrays.sort(arr2); //그냥 정렬해준다. 안해도 사실 노상관.

        permutation(arr2, 0,  n); //순열 메서드는 숫자형 배열과, 0부터 n(배열의 크기)까지 모두 다른 순서가 있게 열을 세운다.
        System.out.println(max);
    }

    static void permutation(Integer[] arr, int depth, int n) {
        if (depth == n) {// depth과 n이 같다는건 모든 순서의 경우의 수로 다 돌았다는것. return으로 종료시킨다.
            cal(arr);
            return;
        }else if(depth!=n){
            for (int i = depth; i < n; i++) {
            swap(arr, i, depth); // 배열의 i번째와 depth번째와 바꾼다.
            permutation(arr, depth + 1,n); //재귀적 접근으로 여기서 또 순열을 한다.
            swap(arr, i, depth);
            }
        }
    }

    static void swap(Integer[] arr, int i, int j) { // 바꿔준다.
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void cal(Integer[] arr) {
        int sum = 0;
        for (int i = 0 ; i <arr.length - 1; i++ ) {
            sum += Math.abs(arr[i + 1]-arr[i]); //이웃하는 배열 끼리 차의 절대값을 구한다음 다 더한다.
        }
        if (max < sum) {
            max = sum; //최대값 갱신~
        }
    }

}