import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
import javax.swing.text.AbstractDocument.BranchElement;
import java.io.*;
 
public class Main {//갓천댓~~ 두지코딩~~
    // 3번이나 틀렸다.... 이유는 x,y 에 0씩 초기화했기때문이다..
    //전부 0인 이차배열에서는 틀리게된다...
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[9][9];
        int max = 0;
        int x = 1; //원랜 0이였다.
        int y = 1; //원랜 0이였다.

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    x = i + 1; //배열의 인덱스는 0부터 시작하므로 1더한다.
                    y = j + 1;

                }
            }
        }
        System.out.println(max);
        System.out.println(x + " " + y);

    }
}
