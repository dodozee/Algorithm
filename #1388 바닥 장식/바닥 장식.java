import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException { //갓천대 화이팅! 이길여 총장님 오래사세요!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        int n = Integer.parseInt(st.nextToken()); //행크기 n
        int m = Integer.parseInt(st.nextToken()); //열크기 m

        StringBuilder sb = new StringBuilder();

        char[][] floor = new char[n][m]; //타일을 담을 배열 크기대로 생성 한다!

        for (int i = 0; i < n; i++) {
            floor[i] = br.readLine().toCharArray(); //문자열을 문자로 이루어진 배열로 바꾼다.
            for (int j = 0; j < m; j++) {
                if (floor[i][j] == '-') {
                    ans= ans +1;
                    while( j< m && floor[i][j] =='-'){ //연속된 타일을 뛰어넘기는 중.
                        j++;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (floor[j][i] == '|') { //행열을 대칭시키듯 i와 j를 바꾼다 -> 그럼 똑같은 로직을 사용할 수 있다.
                    ans = ans + 1;
                    while (j < n && floor[j][i] == '|') {
                        j++;
                    }
                }
            }
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
    }
}
