import java.io.*;
import java.util.*;
import java.util.Arrays;
/*      박두지 화이팅!! 갓천대 화이팅!!!
[문제접근]
1.이진 탐색으로 했다. left와 right를 이용하여 nums[left] + nums[right]가 nums[i]와 같은지 비교한다
2.만약 같다면, cnt를 1 증가시키고, 다음 수 nums[i+1]를 검사합니다. 
3.만약 다르다면 nums[left] + nums[right]가 nums[i]보다 작으면 left를 증가시키고, 
4.만약 크면 right를 감소시킨다. 이를 반복하여 모든 수에 대해서 탐색을 수행하고, 최종적으로 cnt 값을 출력한다.

[주의할 점]
이진 정렬로 구현하였다. 문제가 어렵기도하고 + 잠와서 고생 좀 한거같다.
*/
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);//이진 탐색하려면 정렬해야한다
        int cnt = 0;
        for (int i = 0; i < n; i++) { //더 작은 수를 찾기 위해서 왼쪽 인데스와 큰수를 위해 오른쪽 인덱스를 설정했다
            int left = 0;
            int right = n - 1;
            //이진 탐색 시작
            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }
                int sum = nums[left] + nums[right];
                if (sum == nums[i]) {
                    cnt++;
                    break;
                } else if (sum < nums[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(cnt);
    }
}
