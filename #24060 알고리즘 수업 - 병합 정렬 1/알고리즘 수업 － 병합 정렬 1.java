import java.io.*;
import java.sql.Array;
import java.util.*;


/**
 * 병합정렬(merge sort)은 분할 정복 방법을 통해 구현할 수 있는 정렬 알고리즘 중 하나
 * divide : 입력 배열을 같으 크기의 2개의 부분 배열로 분할
 * conquer : 부분 배열을 정렬
 * combine : 정렬된 부분 배열을 하나의 배열로 병합
 * <p>
 * divide -> conquer -> combine
 */
public class Main {
    static int[] temp; // 임시 배열
    static int result = -1; // 결과값
    static int count = 0;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        temp = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, 0, n - 1);//병합정렬 실행(배열, 시작 index, 끝 index)

        System.out.println(result);
    }
    private static void mergeSort(int[] array, int start, int end){
        if(count> K) return; // K번째 정렬이 완료되면 종료
        if(start < end){
            int mid = (start + end) / 2;
            mergeSort(array, start, mid); // 왼쪽 부분 배열 정렬
            mergeSort(array, mid+1, end); // 오른쪽 부분 배열 정렬
            merge(array, start, mid, end); // 정렬된 두 부분 배열 병합
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1; // 오른쪽 부분 배열의 시작 index
        int k = 0;

        while(i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }

        while(i <= mid){
            temp[k++] = arr[i++];
        }
        while(j <= end){
            temp[k++] = arr[j++];
        }

        k = 0;
        i = start;

        while (i <= end) {
            count++;
            if (count == K) {
                result = temp[k];
                break;
            }
            arr[i++] = temp[k++];

        }
    }

}