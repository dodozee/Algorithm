import java.io.*;
import java.util.*;
/*      박두지 화이팅!! 갓천대 화이팅!!!
 [문제접근]
풀이 생각 시간 : 2분
코딩 시간    : 5분
총 시간    :5분

 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int xMax =Integer.MIN_VALUE;
        int xMin =Integer.MAX_VALUE;
        int yMax =Integer.MIN_VALUE;
        int yMin =Integer.MAX_VALUE;
        int[][] arr= new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

            if(arr[i][0]>xMax){
                xMax= arr[i][0];
            }

            if (arr[i][0] <xMin) {
                xMin = arr[i][0];
            }
            if(arr[i][1]>yMax){
                yMax = arr[i][1];
            }
            if (arr[i][1] < yMin) {
                yMin = arr[i][1];
            }

        }

        System.out.println((xMax - xMin) * (yMax-yMin));
       
    }
}
